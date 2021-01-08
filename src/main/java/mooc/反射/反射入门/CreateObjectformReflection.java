package mooc.反射.反射入门;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class CreateObjectformReflection {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {

            //两种通过反射的方式创建对象
        //与new 克隆 序列化 最大的不同是  自由度很高，
        // 反射传的字符串参数可以通过数据库得到，也可以通过配置文件得到，我们可以不修改程序代码，仅仅修改配置文件就能产生不同的结果
        //这个鬼玩意儿需要填入正确的  包名+类名
        Object obj = Class.forName("Mooc.反射入门.CreateObject").newInstance();
        Method method = Class.forName("Mooc.反射入门.CreateObject").getMethod("say");
        method.invoke(obj);

        CreateObject createObject = (CreateObject)Class.forName("Mooc.反射入门.CreateObject").newInstance();

        Constructor<CreateObject> constructor = CreateObject.class.getConstructor();
        CreateObject createObject1 = constructor.newInstance();
        createObject1.say();
    }
}
