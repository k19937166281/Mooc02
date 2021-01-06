package mooc.注解.zj04.document;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface DocumentedAnnotation {
	String value();
}
