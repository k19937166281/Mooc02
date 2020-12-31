package mooc.泛型.GP03;

public abstract  class Fruit {
    private int size;
    public int time;

    public int getSize()
    {
        return size;
    }

    public Fruit(int size)
    {
        this.size = size;
    }

    public abstract void hello();
}
