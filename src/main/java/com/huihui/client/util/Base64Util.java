package com.huihui.client.util;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;

/**
 * @className: Base64Util
 * @description:
 * @author: huihui
 * @createDate: 2019-09-04
 * @version: 1.0
 */
public class Base64Util {

    private static final Logger LOGGER = LoggerFactory.getLogger(Base64Util.class);

    private static final String charset = "utf-8";

    /**
     * 解密
     *
     * @param data
     * @return
     * @author jqlin
     */
    public static String decode(String data) {
        try {
            if (null == data) {
                return null;
            }

            return new String(Base64.decodeBase64(data.getBytes(charset)), charset);
        } catch (UnsupportedEncodingException e) {
            LOGGER.error(String.format("字符串：%s，解密异常", data), e);
        }

        return null;
    }

    /**
     * 加密
     *
     * @param data
     * @return
     * @author jqlin
     */
    public static String encode(String data) {
        try {
            if (null == data) {
                return null;
            }
            return new String(Base64.encodeBase64(data.getBytes(charset)), charset);
        } catch (UnsupportedEncodingException e) {
            LOGGER.error(String.format("字符串：%s，加密异常", data), e);
        }

        return null;
    }

}
