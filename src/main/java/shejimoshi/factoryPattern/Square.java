package shejimoshi.factoryPattern;
//三种实现类 正方形
public class Square implements Shape{
    @Override
    public void draw() {
        System.out.println("inside Square::draw() method.");
    }
}
