package mooc.反射.反射关键类;
//JVM 为每个对象都保留其类型标识信息（RuntimeTypeIdentification）
public class RuntimeTypeIdentification {
    public static void main(String[] args) throws ClassNotFoundException {
        String s1 = "abc";
        Class c1 = s1.getClass();
        System.out.println(c1.getName());

        Class c2 = Class.forName("java.lang.String");
        System.out.println(c2.getName());

        Class<String> stringClass = String.class;
        System.out.println(stringClass.getName());
    }
}
