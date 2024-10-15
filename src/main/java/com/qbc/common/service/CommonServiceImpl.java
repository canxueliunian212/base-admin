package com.qbc.common.service;

import com.qbc.common.pojo.PageInfo;
import com.qbc.common.pojo.Result;
import com.qbc.common.repository.CommonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

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

        return null;
    }

    @Override
    public Result<List<V>> list(V entityVo) {

        return null;
    }

    @Override
    public Result<V> get(T id) {
        return null;
    }

    @Override
    public Result<V> save(V entityVo) {
        return null;
    }

    @Override
    public Result<T> delete(T id) {
        return null;
    }
}
