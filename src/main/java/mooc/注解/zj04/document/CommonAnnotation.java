package mooc.注解.zj04.document;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface CommonAnnotation {
	String value();
}
