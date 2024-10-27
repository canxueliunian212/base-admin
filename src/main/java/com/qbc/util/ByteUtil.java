package com.qbc.util;

import lombok.extern.slf4j.Slf4j;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @ClassNme ByteUtil
 * @Description TODO
 * @Author chenpei
 * @Date 2024/10/22 21:43
 * @Version 1.0
 **/
@Slf4j
public class ByteUtil {

    /**
     * @Author chenpei
     * @Description //二进制转十六进制
     * @Date 21:52 2024/10/22
     * @Param [bytes]
     * @return java.lang.String
     **/
    public static String bytesToHex(byte[] bytes) {
        StringBuilder hexStr = new StringBuilder(bytes.length);
        int num;
        for (byte aByte : bytes) {
            num = aByte;
            if (num < 0) {
                num += 256;
            }
            if (num < 16) {
                hexStr.append("0");
            }
            hexStr.append(Integer.toHexString(num));
        }
        return hexStr.toString().toUpperCase();
    }

    public static  byte[] objecttoByte(Object obj) {
        byte[] bytes = null;

        try(ByteArrayOutputStream bo = new ByteArrayOutputStream(); ObjectOutputStream oo = new ObjectOutputStream(bo)) {
            //开始写入输出流
            oo.writeObject(obj);
            //输出流转byte
            bytes = bo.toByteArray();
        } catch (Exception e) {
            //输出到日志文件中
            log.error(ErrorUtil.errorInfoToString(e));
        }
        return bytes;
    }

    /**
     * @Author chenpei
     * @Description //byte[]转Object对象
     * @Date 11:20 2024/10/26
     * @Param [bytes]
     * @return java.lang.Object
     **/
    public static Object byteToObject(byte[] bytes) {
        Object obj = null;

        try(ByteArrayInputStream bi = new ByteArrayInputStream(bytes); ObjectInputStream oi = new ObjectInputStream(bi)) {
            // 读取输入流
            obj = oi.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }
}
