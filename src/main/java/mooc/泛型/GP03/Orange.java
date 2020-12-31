package mooc.泛型.GP03;

public class Orange extends Fruit {

    public int time;

    public Orange(int size)
    {
        super(size);
    }

    public void hello() {
        System.out.println("I am a pear, with size " + getSize());

    }

    public static void main(String[] args) {
        Orange orange = new Orange(2);

        System.out.println(orange.getSize());

    }
}
