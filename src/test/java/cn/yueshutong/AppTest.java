package cn.yueshutong;

import cn.yueshutong.file.ClassPathResource;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

/**
 * Unit test for simple App.
 */
public class AppTest {
    private Logger logger = LoggerFactory.getLogger(AppTest.class);

    @Test
    public void shouldAnswerWithTrue() throws IOException {
        //读取html文件
        ClassPathResource resource = new ClassPathResource();
        String html = resource.readString("commons.html",StandardCharsets.UTF_8);
        logger.info(html);
        //写入到
        Properties properties = new Properties();
        //开始
        Elements tr = Jsoup.parse(html).getElementsByTag("tr");
        for (Element element : tr) {
            Elements td = element.getElementsByTag("td");
            int size = td.size();
            if (size<4){
                continue;
            }
            logger.info(td.html().replaceAll("\\n"," ")+" "+size);
            String text0 = td.get(0).text();
            String text1 = td.get(1).text();
            properties.setProperty(text0,text1);
            String text2 = td.get(2).text();
            String text3 = td.get(3).text();
            properties.setProperty(text2,text3);
        }
        File file = new File("/Users/yueshutong/IdeaProjects/FileHelper/src/main/resources/content-type.properties");
        if (!file.exists()){
            file.createNewFile();
        }
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        properties.store(fileOutputStream,"HTTP ContentType");
    }

}
