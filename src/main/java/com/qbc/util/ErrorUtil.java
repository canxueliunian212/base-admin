package com.qbc.util;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * @ClassNme ErrorUtil
 * @Description TODO
 * @Author chenpei
 * @Date 2024/10/14 16:48
 * @Version 1.0
 **/
public class ErrorUtil {

    /**
     * Exception出错的栈信息转成字符串
     * 用于打印到日志中
     */
    public static String errorInfoToString(Throwable e) {
        //try-with-resource语法糖 处理机制
        try(StringWriter sw = new StringWriter(); PrintWriter pw = new PrintWriter(sw)){
            e.printStackTrace(pw);
            pw.flush();
            sw.flush();
            return sw.toString();
        }catch (Exception ignored){
            throw new RuntimeException(ignored.getMessage(),ignored);
        }
    }
}
