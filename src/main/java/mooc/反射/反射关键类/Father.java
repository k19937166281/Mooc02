package mooc.反射.反射关键类;

public class Father {
}
class Son extends Father implements Cloneable,Comparable<Son>{

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public int compareTo(Son o) {
        return 0;
    }

    public static void main(String[] args) {
        Son son = new Son();
        Class sonClass = son.getClass();

        Class superclass = sonClass.getSuperclass();
        System.out.println(superclass.getName());

        Class[] interfaces = sonClass.getInterfaces();

        for (Class anInterface : interfaces) {
            System.out.println(anInterface.getName());
        }

    }
}
