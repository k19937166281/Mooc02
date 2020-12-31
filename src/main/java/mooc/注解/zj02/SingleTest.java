package mooc.注解.zj02;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
//表示该注解会保留在class文件中
@Retention(RetentionPolicy.RUNTIME)
//表示该注解只能用于方法
@Target({ElementType.METHOD,ElementType.FIELD})
public @interface SingleTest {
    int value() default 0;
}
