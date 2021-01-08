package mooc.stream.s3;

public class Student implements Comparable<Student>{
    private String name;
    private int age;

    public String getName() {
        System.out.println("执行getName()");
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this==o) return true;
        if(!(o instanceof Student)) return true;
        Student stu = (Student)o;
        return age==stu.age && name.equals(stu.name);

    }

    @Override
    public int hashCode() {
        //return Objects.hash(name,age);
        return name.hashCode()*10+age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Student o) {
        return this.age-o.age;
    }

}
