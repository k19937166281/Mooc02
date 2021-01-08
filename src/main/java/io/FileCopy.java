package io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("E:\\xuihuifangjiao\\tupianchuli\\,\\1.jpg");
        FileOutputStream fileOutputStream = new FileOutputStream("E:\\xuihuifangjiao\\tupianchuli\\,\\2.jpg");
        byte[] b = new byte[1024];
        int off = 0;
        int len = 1024;
        while ((fileInputStream.read(b, off, len))!=-1){
            fileOutputStream.write(b,off,len);
        }
        fileOutputStream.flush();
        fileInputStream.close();
        fileOutputStream.close();
    }
}
