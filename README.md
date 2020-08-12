# FileHelper

这个项目我会不断维护，抽取常用但难以实现的各种文件操作。

一人计短，多人计长，也期待你加入贡献的行列。

## 1.读取Resources下的资源

```java
ClassPathResource resource = new ClassPathResource();
String html = resource.readString("commons.html",StandardCharsets.UTF_8);
String htm = resource.readString("commons.htm");
byte[] bytes = resource.readByte("commons.html");
InputStream inputStream = resource.read("commons.html");
String resourcePath = resource.getPath(); //获取resources根目录
```

## 2.读取文件的ContentType

```java
String contentType = ContentType.getContentType("/index.html");
```

## About

Email：[codeblog@qq.com](mailto:codeblog@qq.com)

如果帮助到你了，请不吝赞赏！谢谢！

<img src='https://i.loli.net/2020/01/13/pPoFNwT6fKCZQ2i.png' width="400px" />
