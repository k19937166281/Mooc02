package mooc.Java类加载器.Java类加载机制;

public class ClassLoaderTree {
    public static void main(String[] args) {
        ClassLoader classLoader = ClassLoaderTree.class.getClassLoader();

        while (null != classLoader){
            System.out.println(classLoader.getClass().getName());
            classLoader = classLoader.getParent();
        }

        if (null == classLoader){
            System.out.println("启动类加载器实现于C语言");
        }
    }
}
