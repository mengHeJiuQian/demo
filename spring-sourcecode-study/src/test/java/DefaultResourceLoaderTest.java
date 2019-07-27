import org.springframework.core.io.*;

/**
 * 创建人：yang.liu
 * 创建时间：2019/7/27 13:49
 * 版本：1.0
 * 内容描述：测试 DefaultResourceLoader 加载资源的逻辑
 */
public class DefaultResourceLoaderTest {

    public static void main(String[] args) {
//        ResourceLoader resourceLoader = new DefaultResourceLoader();
        ResourceLoader resourceLoader = new FileSystemResourceLoader();

        Resource fileResource1 = resourceLoader.getResource("D:/Users/chenming673/Documents/spark.txt");
        System.out.println("fileResource1 is FileSystemResource:" + (fileResource1 instanceof FileSystemResource));
        System.out.println("fileResource1 is FileSystemResource:" + (fileResource1 instanceof ClassPathResource));

        Resource fileResource2 = resourceLoader.getResource("/Users/chenming673/Documents/spark.txt");
        System.out.println("fileResource2 is ClassPathResource:" + (fileResource2 instanceof ClassPathResource));

        Resource urlResource1 = resourceLoader.getResource("file:/Users/chenming673/Documents/spark.txt");
        System.out.println("urlResource1 is UrlResource:" + (urlResource1 instanceof UrlResource));

        Resource urlResource2 = resourceLoader.getResource("http://www.baidu.com");
        System.out.println("urlResource1 is urlResource:" + (urlResource2 instanceof  UrlResource));
    }
}
