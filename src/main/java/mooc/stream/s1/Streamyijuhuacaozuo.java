package mooc.stream.s1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Streamyijuhuacaozuo {
    public static void main(String[] args) {
        List<Transaction> transactions=new ArrayList<>();
        transactions.add(new Transaction("grocery",1,10));
        transactions.add(new Transaction("grocery",2,20));
        transactions.add(new Transaction("grocery",3,30));
        transactions.add(new Transaction("cake",2,20));

        //链式操作    加上众多的检索条件  类似于SQL   不去关心如何实现，就使用流的方法就行操作，，比如sql的order by select
        //初学者不必关心如何实现的，学会精炼的使用，是大部分工作者要去做的。
        transactions.stream().filter(transaction -> transaction.getType().equals("grocery"))
                .sorted(Comparator.comparing(Transaction::getValue).reversed())
                .map(Transaction::getId).collect(Collectors.toList())
                .forEach(System.out::println);
    }
}
