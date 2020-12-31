package mooc.泛型.GP02;

public class IntervalCalculator implements Calculator<Interval<Integer>> {

    @Override
    public Interval<Integer> add(Interval<Integer> op1, Interval<Integer> op2) {
        return new Interval<Integer>(op1.getLower()+op2.getUpper(),op1.getUpper()+op2.getUpper());
    }

    public static void main(String[] args) {
        Calculator<Interval<Integer>> calculator = new IntervalCalculator();

        Interval<Integer> intervalGP2IntervalGP201 = new Interval(1,2);
        Interval<Integer> intervalGP2IntervalGP202 = new Interval(3,4);

        Interval<Integer> add = calculator.add(intervalGP2IntervalGP201, intervalGP2IntervalGP202);

        System.out.println(add.getLower()+"\t"+add.getUpper());


    }
}
