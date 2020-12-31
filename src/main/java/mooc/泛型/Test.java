package mooc.泛型;

import javafx.util.converter.BigIntegerStringConverter;

import java.math.BigInteger;

public class Test {
    public static void main(String[] args) {
        System.out.println("5\n" +
                "6\n" +
                "8\n" +
                "9\n" +
                "5\n" +
                "5\n" +
                "5\n" +
                "5\n" +
                "5\n" +
                "5\n" +
                "5\n" +
                "5\n" +
                "6\n" +
                "8\n" +
                "9\n" +
                "5\n" +
                "6\n" +
                "8\n" +
                "9\n" +
                "5\n" +
                "6\n" +
                "8\n" +
                "9\n" +
                "5\n" +
                "5\n" +
                "5\n" +
                "5\n" +
                "5\n" +
                "5\n" +
                "5");

        System.out.println("1999999999");
        System.out.println(Long.valueOf(new StringBuilder("1999999999").reverse().toString()));
        BigIntegerStringConverter bigIntegerStringConverter = new BigIntegerStringConverter();
        BigInteger bigInteger = bigIntegerStringConverter.fromString("1000000000000000000000000000001");

        System.out.println(bigInteger);
        System.out.println( +564);

        BigInteger bigInteger1 = new BigInteger("11111111111111111111111111111111111111111111111111111111111111111111111111111111");
        System.out.println(bigInteger1);
    }
}
