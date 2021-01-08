package java思想理解;

import java.io.File;
//继承
public class Avatar extends File
{

    //独属于头像的属性
    private String userName;//抽象出  头像私有  属性    所属用户名

    private int times;//抽象出   头像私有  属性   用户的更换的第几次头像；

    //属于图片的属性   宽，高，大小，图片类型（jpg  png...），位深度，压缩等级   ..........
    private int width;//抽象出  图片私有  属性    宽度

    private int height;//抽象出  图片私有  属性    高度

	//....................................

    //关于  File（文件对象）的属性，已经在JDK中被定义了。我们继承了File类。
    public Avatar(String pathname) {
        super(pathname);
    }

    public void print(){
        System.out.println("Avatar类继承了File类，能够使用父类的方法");
    }

    // 继承 File类的  方法  ，重写，达成自己的逻辑
    //这个方法是判断  File 对象是否是文件  而不是文件夹   是文件就会返回true
    //现在我要让它反过来
    @Override
    public boolean isFile() {//方法返回类型  Boolean  它的取值  仅有  true  false
        //众所周知，boolean的值只有true  false  默认值  false
        // 此时   boolean 类型的 result  的值  由底层代码控制
        boolean result=super.isFile();//接收   返回值
        return !result;//   ！关键符     让  true 变成 false    ；让false变成true    达成我的目的

        //return super.isFile();    //这是继承这个方法时的默认代码
    }


    public static void main(String[] args) {

        Avatar avatar=new Avatar("C:\\1.png");
        System.out.println(avatar.exists());//true  存在
        System.out.println(avatar.getAbsolutePath());//C:\1.png
        System.out.println(avatar.delete());//true  删除成功
        System.out.println(avatar.exists());//false  不存在

        avatar.print();

    }

}
