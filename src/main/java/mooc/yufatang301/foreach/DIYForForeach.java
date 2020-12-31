package mooc.yufatang301.foreach;



import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class DIYForForeach {

    public static void main(String[] args) {

        //list 记录的不是左侧  而是 右侧  记录的是 变量名指向的实例对象，
        // 而不是  变量本身
        //通过变量名将实例对象存储进入list之后，再去改变改变变量的指向，对list原来存储的对象没有任何影响
        Person person = null;
        //先改变值，后装入
        person = new Person("zs",1);
        List<Person> personList = new ArrayList<>();
        personList.add(person);
        //先装入，后 改变值  会 报 NullPointException
        //person = new Person("",1);
        for (Person person1 : personList) {
            System.out.println(person1.getAge());
        }

        System.out.println("--------------------");
        System.out.println("--------------------");

        List<Person> testForeachChangeValue = new ArrayList<>();
        testForeachChangeValue.add(person);

        for (Person testPerson : testForeachChangeValue) {
            testPerson.setAge(11);
            //此处只是  把  testPerson 这个 指针或者参考 指向了另外一个实例对象
            // 并没有改变  testForeachChangeValue 里面的值
            //所以说 foreach 时  不能改变 Collection 中的东西
            testPerson = new Person("",121);
        }
        for (Person testPerson : testForeachChangeValue) {
            System.out.println(testPerson.getName()+"\t"+testPerson.getAge());
        }

        System.out.println("--------------------");
        System.out.println("--------------------");

        double[] nums = new double[6];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Math.random();
        }
        for (double num : nums) {
            System.out.println(num);
        }
        HashSet<String> strings = new HashSet<>();
        strings.add("1");
        strings.add("11");
        strings.add("12");
        for (Iterator<String> iterator = strings.iterator();iterator.hasNext();){
            String next = iterator.next();
            iterator.remove();
        }
        for (String string : strings) {
            System.out.println(string);
        }
    }
}
