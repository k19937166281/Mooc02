package mooc.gaojiwenbenchuli;

import java.util.Properties;

public class Find {

    public static void main(String[] args) {
        propertiesTest();
    }
    //例如 application.properties 之类的文件本质上 是一个 java.util.properties 类
    public static void propertiesTest(){
        Properties properties = new Properties();
        properties.setProperty("key","value");
        properties.list(System.out);
    }

}
