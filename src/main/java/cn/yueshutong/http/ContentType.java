package cn.yueshutong.http;

import cn.yueshutong.file.ClassPathResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Properties;

/**
 * 根据文件后戳判断文件的ContentType
 */
public class ContentType {
    private final static String defaultContentType = "application/octet-stream";
    private static Logger logger = LoggerFactory.getLogger(ContentType.class);

    public static String getContentType(String uri) {
        int i = uri.lastIndexOf(".");
        if (i == -1) {
            return defaultContentType;
        }
        String s = uri.substring(i);
        ClassPathResource classPathResource = new ClassPathResource();
        Properties properties = new Properties();
        try {
            properties.load(classPathResource.read("content-type.properties"));
        } catch (IOException e) {
            logger.error("properties.load()",e);
        }
        Object r = properties.get(s);
        if (r == null) {
            return defaultContentType;
        }
        return r.toString();
    }
}
