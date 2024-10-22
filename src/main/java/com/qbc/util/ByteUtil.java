package com.qbc.util;

import lombok.extern.slf4j.Slf4j;

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
}
