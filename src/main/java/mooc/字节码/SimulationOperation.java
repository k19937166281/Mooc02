package mooc.字节码;

import java.util.Stack;

public class SimulationOperation {
    public static void main(String[] args) {
        //Stack类表示对象的后进先出（LIFO）堆栈。 它通过五个操作扩展了Vector类，
        //这些操作允许将矢量视为堆栈。 提供了通常的推入和弹出操作，以及一种窥视堆栈顶部项目的方法，
        //一种用于测试堆栈是否为空的方法以及一种用于在堆栈中搜索项目并发现其距离的方法。从顶部开始。
        //push>pop>peek>empty>search
        //begin
        //iload_0    // push the int in local variable 0 onto the stack
        //iload_1             // push the int in local variable 1 onto the stack
        //iadd       // pop two ints, add them, push result
        //istore_2            // pop int, store into local variable 2
        //end
        int base = 10;
        int toadd = 5;
        int[] Localvariabletable = new int[3];
        Localvariabletable[0] = base;
        Localvariabletable[1] = toadd;
        Stack<Integer> StackOperand = new Stack();
        StackOperand.push(Localvariabletable[0]);
        StackOperand.push(Localvariabletable[1]);

        Integer pop0 = StackOperand.pop();
        Integer pop1 = StackOperand.pop();
        int result = pop0+pop1;
        StackOperand.push(result);
        Integer pop3 = StackOperand.pop();
        Localvariabletable[2] = pop3;
        // Deque<Integer> deque = new ArrayDeque<Integer>();
    }
}
