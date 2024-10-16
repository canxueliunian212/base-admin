package com.qbc.common.service;

import com.qbc.common.pojo.PageCondition;
import com.qbc.common.pojo.PageInfo;
import com.qbc.common.pojo.Result;
import com.qbc.common.repository.CommonRepository;
import com.qbc.util.CopyUtil;
import com.qbc.util.ErrorUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.util.StringUtils;

import javax.persistence.Id;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @ClassNme CommonServiceImpl
 * @Description TODO
 * @Author chenpei
 * @Date 2024/10/15 10:59
 * @Version 1.0
 **/
@Slf4j
public class CommonServiceImpl<V, E, T> implements CommonService<V, E, T> {

    private Class<V> entityVoClass;// エンティティクスすVo

    private Class<E> entityClass;//エンティティクラス

    @Autowired
    private CommonRepository<E, T> commonRepository;//注入实体类仓库

    public CommonServiceImpl() {
        Type[] types = ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments();
        this.entityVoClass = (Class<V>) types[0];
        this.entityClass = (Class<E>) types[1];
    }



    @Override
    public Result<PageInfo<V>> page(V entityVo) {
        // ページング情報が不足してい
        if (!(entityVo instanceof PageCondition)) {
            throw new RuntimeException("缺失分页参数！");
        }
        PageCondition pageCondition = (PageCondition) entityVo;
        //先entityVo转entity，再调用findAll（传多一个分页参数），结果集再转回entityVo
        return Result.of(PageInfo.of(commonRepository.findAll(Example.of(CopyUtil.copy(entityVo, entityClass)), pageCondition.getPageable()), entityVoClass));
    }

    @Override
    public Result<List<V>> list(V entityVo) {
        //先entityVo转entity，再调用findAll，结果集再转回entityVo
        return Result.of(CopyUtil.copyList(commonRepository.findAll(Example.of(CopyUtil.copy(entityVo, entityClass))), entityVoClass));
    }

    @Override
    public Result<V> get(T id) {
        //findById返回Optional<T>，再获取entity转成entityVo
        return commonRepository.findById(id).map(e -> Result.of(CopyUtil.copy(e, entityVoClass))).orElseGet(() -> Result.of(null, false, "ID不存在！"));
    }

    @Override
    public Result<V> save(V entityVo) {
        //传进来的对象（属性可能残缺）
        E entity = CopyUtil.copy(entityVo, entityClass);

        //最终要保存的对象
        E entityFull = entity;

        //为空的属性值，忽略属性，BeanUtils复制的时候用到
        List<String> ignoreProperties = new ArrayList<>(5);

        //获取最新数据，解决部分更新时jpa其他字段设置null问题
        try {
            //新增 true，更新 false，要求实体类的Id属性排在第一位，因为for循环读取是按照顺序的
            boolean isInsert = false;

            // 反射获取Class的属性（Field表示类中的成员变量）
            for (Field field : entity.getClass().getDeclaredFields()) {
                //获取授权
                field.setAccessible(true);
                //属性名称
                String fieldName = field.getName();
                //属性的值
                Object fieldValue = field.get(entity);
                //找出Id主键
                if (field.isAnnotationPresent(Id.class)) {
                    if (!StringUtils.isEmpty(fieldValue)) {
                        // 如果Id主键不为空，则为更新
                        Optional<E> one = commonRepository.findById((T) fieldValue);
                        if (one.isPresent()) {
                            entityFull = one.get();
                        }
                    } else {
                        // 如果主键Id为空
                        isInsert = true;
                    }
                }

            }
        } catch (IllegalAccessException e) {
            //输出到日志文件中
            log.error(ErrorUtil.errorInfoToString(e));
        }


        return null;
    }

    @Override
    public Result<T> delete(T id) {
        return null;
    }
}
