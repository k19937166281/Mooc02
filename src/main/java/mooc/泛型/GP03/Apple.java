package mooc.泛型.GP03;

public class Apple extends Fruit {

    public Apple(int size)
    {
        super(size);
    }

    public void hello() {
        System.out.println("I am an apple, with size " + getSize());

    }

}
