package cn.yueshutong.http;

import org.junit.Test;

public class ContentTypeTest {

    @Test
    public void test() {
        String[] s = new String[]{"/sss/sss.xml","/sss/ss","/ssss/sss.html"};
        for (String ss : s){
            String contentType = ContentType.getContentType(ss);
            System.out.println(contentType);
        }
    }

}