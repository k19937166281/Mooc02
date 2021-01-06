package mooc.注解.zj04.repeatable;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface RepeatableAnnotations {
	RepeatableAnnotation[] value();
}
