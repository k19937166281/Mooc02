package mooc.注解.zj04.repeatable;

import java.lang.reflect.Method;


@RepeatableAnnotation
@RepeatableAnnotation

public class Main {

	public static void main(String[] a) throws Exception
	{
		String className = "mooc.注解.src.repeatable.Student";
		for (Method m : Class.forName(className).getMethods())
		{
			if (m.isAnnotationPresent(RepeatableAnnotations.class))
			{
				RepeatableAnnotation[] annos = m.getAnnotationsByType(RepeatableAnnotation.class);
				for (RepeatableAnnotation anno : annos)
				{
					System.out.println(anno.a() + "," + anno.b() + "," + anno.c());
					try
					{
						m.invoke(null,anno.a(),anno.b(),anno.c());
					} catch (Throwable ex) {
						System.out.printf("Test %s failed: %s %n", m, ex.getCause());
					}
				}
			}
		}
	}

}
