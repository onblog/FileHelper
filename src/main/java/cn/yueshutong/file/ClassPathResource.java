package cn.yueshutong.file;

import java.io.*;
import java.nio.charset.Charset;

/**
 * 读取ClassPathResource下的资源文件
 */
public class ClassPathResource {

    /**
     * 不存在返回Null
     */
    public InputStream read(String classPath) {
        return this.getClass().getClassLoader().getResourceAsStream(classPath);
    }

    /**
     * 不存在返回Null
     */
    public byte[] readByte(String classPath) {
        //判空
        InputStream inputStream = read(classPath);
        if (inputStream == null) {
            return null;
        }
        //读取
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        try (BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
             BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(stream)) {
            byte[] bytes = new byte[1024];
            int n;
            while ((n = bufferedInputStream.read(bytes)) != -1) {
                bufferedOutputStream.write(bytes, 0, n);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stream.toByteArray();
    }

    /**
     * 不存在返回Null
     */
    public String readString(String classPath) {
        byte[] bytes = readByte(classPath);
        if (bytes==null){
            return null;
        }
        return new String(bytes);
    }

    /**
     * 不存在返回Null
     * @param charset StandardCharsets.UTF_8
     */
    public String readString(String classPath, Charset charset){
        byte[] bytes = readByte(classPath);
        if (bytes==null){
            return null;
        }
        return new String(bytes, charset);
    }

}
