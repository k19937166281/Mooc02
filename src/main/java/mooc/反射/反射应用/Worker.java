package mooc.反射.反射应用;

import java.lang.reflect.Method;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Worker {
    public static void hello(){
        System.out.println("hello java!");
    }

    public static void main(String[] args) {
        Timer timer = new Timer();
        Calendar instance = Calendar.getInstance();
        instance.set(Calendar.SECOND,instance.get(Calendar.SECOND)+1);
        Date time = instance.getTime();

        MyTask myTask = new MyTask();
        timer.scheduleAtFixedRate(myTask,time,3000);
    }
}
class MyTask extends TimerTask{
    @Override
    public void run() {
        try{
            Class aClass = Class.forName("Mooc.反射应用.Worker");
            Method method =  aClass.getMethod("hello");
            //静态方法 填个null就行，不用填所在类的Class对象
            method.invoke(null);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
