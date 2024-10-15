package com.qbc.common.service;

import com.qbc.common.pojo.PageInfo;
import com.qbc.common.pojo.Result;

import java.util.List;

/**
 * @ClassNme CommonService
 * @Description TODO
 * @Author chenpei
 * @Date 2024/10/14 11:38
 * @Version 1.0
 **/
public interface CommonService<V, E, T>{
    Result<PageInfo<V>> page(V entityVo);

    Result<List<V>> list(V entityVo);

    Result<V> get(T id);

    Result<V> save(V entityVo);

    Result<T> delete(T id);
}
