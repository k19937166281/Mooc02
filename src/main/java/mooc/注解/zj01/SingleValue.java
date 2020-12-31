package mooc.注解.zj01;

import java.io.FilenameFilter;
import java.lang.annotation.*;

/**
 * @author k1326
 */ //能够放在注解上面的注解,元注解
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)//注释保留策略
@Documented
public @interface SingleValue {
    String value() default "";
    enum Status{FIXED("1");String a; Status(String a){
        this.a =a;
    };};
}
