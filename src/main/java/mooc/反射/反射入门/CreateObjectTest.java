package mooc.反射.反射入门;

import java.io.*;

public class CreateObjectTest {

    public static void main(String[] args) throws CloneNotSupportedException, IOException, ClassNotFoundException {

        //创建对象的方法
        //1
        CreateObject cOofNew = new CreateObject();
        cOofNew.say();

        //二 没有使用 构造方法  而是从内存中复制了整体，又分配了一块内存存储复制体
        CreateObject clone = (CreateObject)cOofNew.clone();
        clone.say();

        //三 没有使用 构造方法
        // 序列化（通过JDK的方法把对象写入文件） 反序列化（通过JDK的方法通过文件创建对象）
        //序列化会引发安全漏洞（因为有文件读写操作），JDK官方宣布未来会移除出JDK

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("data.obj"));
        objectOutputStream.writeObject(cOofNew);
        objectOutputStream.close();

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("data.obj"));
        CreateObject coofSerial = (CreateObject)objectInputStream.readObject();
        objectInputStream.close();
        coofSerial.say();

    }
}
