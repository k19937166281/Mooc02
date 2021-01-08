package mooc.反射.反射入门;

import java.io.Serializable;

public class CreateObject implements Cloneable, Serializable {
    private static final long serialVersionUID = 1L;

    public void say(){
        System.out.println("hello");
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
