package mooc.泛型.GP02;

public class IntegerCalculator implements Calculator<Integer>{
    @Override
    public Integer add(Integer op1, Integer op2) {
        return  op1+op2;
    }

    public static void main(String[] args) {
        IntegerCalculator integerCalculator = new IntegerCalculator();
        Integer add = integerCalculator.add(1, 2);
        System.out.println(add);

        Calculator<Integer> integerCalculator3 =new IntegerCalculator();
        Integer add1 = integerCalculator3.add(1, 2);
        System.out.println(add1);
    }
}
