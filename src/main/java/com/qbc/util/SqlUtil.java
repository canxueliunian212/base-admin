package com.qbc.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;

import java.text.SimpleDateFormat;

/**
 * @ClassNme SqlUtil
 * @Description TODO
 * @Author chenpei
 * @Date 2024/10/27 11:20
 * @Version 1.0
 **/
@Slf4j
public class SqlUtil {

    /**
     * 日期转换格式
     */
    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * 数据库驱动类，用于判断数据库类型
     * MySQL：com.mysql.cj.jdbc.driver（默认）
     * postgresql：org.postgresql.driver
     * Oracle：oracle.jdbc.oracledriver
     */
    @Value("${string.datasource.driver-class-name:com.mysql.cj.jdbc.Driver}")
    private static String sqlType;
}
