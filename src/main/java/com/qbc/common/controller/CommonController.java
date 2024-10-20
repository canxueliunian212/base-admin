package com.qbc.common.controller;

import com.qbc.annotation.Decrypt;
import com.qbc.annotation.Encrypt;
import com.qbc.common.pojo.PageInfo;
import com.qbc.common.pojo.Result;
import com.qbc.common.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;

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
}
