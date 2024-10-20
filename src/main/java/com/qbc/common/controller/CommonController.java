package com.qbc.common.controller;

import com.qbc.annotation.Decrypt;
import com.qbc.annotation.Encrypt;
import com.qbc.common.pojo.PageInfo;
import com.qbc.common.pojo.Result;
import com.qbc.common.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * @ClassNme CommonController
 * @Description TODO
 * @Author chenpei
 * @Date 2024/10/14 11:35
 * @Version 1.0
 **/
public class CommonController<V, E, T> {


    @Autowired
    private CommonService<V, E, T> commonService;

    @PostMapping("page")
    @Decrypt
    @Encrypt
    public Result<PageInfo<V>> page(V entityVo) {
        return commonService.page(entityVo);
    }

    @PostMapping("list")
    @Decrypt
    @Encrypt
    public Result<List<V>> list(V entityVo) {
        return commonService.list(entityVo);
    }

    @GetMapping("get/{id}")
    public Result<V> get(@PathVariable("id") T id) {
        return commonService.get(id);
    }

    @PostMapping("save")
    @Decrypt
    @Encrypt
    public Result<V> save(V entityVo) {
        return commonService.save(entityVo);
    }

    @DeleteMapping("delete/{id}")
    public Result<T> delete(@PathVariable("id") T id) {
        /*
        批量删除
        @DeleteMapping("deleteBatch")
        public Result<T> deleteBatch(@RequestBody List<String> ids){}
        前端调用：
        $.ajax({
            url: ctx + "deleteBatch",
            type: "DELETE",
            data: JSON.stringify([id1,id2]),
            dataType: "JSON",
            contentType: 'application/json',
            success: function (data) {

            }
        });
         */
        return commonService.delete(id);
    }


}
