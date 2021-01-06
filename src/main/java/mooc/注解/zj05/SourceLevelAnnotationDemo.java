package mooc.注解.zj05;


import mooc.注解.zj05.rect.Point;
import mooc.注解.zj05.rect.Rectangle;

public class SourceLevelAnnotationDemo
{
   public static void main(String[] args)
   {
       ToStringAnnotationProcessor toStringAnnotationProcessor = new ToStringAnnotationProcessor();

       Rectangle rect = new Rectangle(new Point(10, 10), 20, 30);
      //System.out.println(ToStringGenerator.toString(rect));
   }
}
