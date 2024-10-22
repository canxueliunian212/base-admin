package com.qbc.util;

import lombok.extern.slf4j.Slf4j;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

/**
 * @ClassNme MD5Util
 * @Description TODO
 * @Author chenpei
 * @Date 2024/10/22 13:56
 * @Version 1.0
 **/
@Slf4j
public class MD5Util {

    /**
     * 生成MD5加密串
     */
    public static String getMd5(String message) {
        String md5 = "";

        try {
            // 创建一个md5算法对象
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageBytes = message.getBytes(StandardCharsets.UTF_8);
            //获得MD字节数组，16*8= 128位
            byte[] md5Byte = md.digest(messageBytes);
            //转换为16进制字符串
            md5 = ByteUtil.bytesToHex(md5Byte);
        } catch (Exception e) {
            //输出到日志文件中
            log.error(ErrorUtil.errorInfoToString(e));
        }
        return md5;
    }

    /**
     * @Author chenpei
     * @Description //验证方法
     * @Date 21:54 2024/10/22
     * @Param [text, md5]
     * @return boolean
     **/
    private static boolean verify(String text, String md5) {
        return md5.equals(getMd5(text));
    }
}
