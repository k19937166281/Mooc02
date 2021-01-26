package mooc.字节码.字节码指令模拟;

import java.util.Stack;
//模拟字节码操作
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
        //本地变量表
        int[] Localvariabletable = new int[3];
        //局部变量base
        Localvariabletable[0] = base;
        //局部变量toadd
        Localvariabletable[1] = toadd;
        //操作数栈
        Stack<Integer> StackOperand = new Stack();
        //压栈
        StackOperand.push(Localvariabletable[0]);
        //压栈
        StackOperand.push(Localvariabletable[1]);
        //弹出
        Integer pop0 = StackOperand.pop();
        //弹出
        Integer pop1 = StackOperand.pop();
        //操作数栈中运算
        int result = pop0+pop1;
        //压栈
        StackOperand.push(result);
        //弹出
        Integer pop3 = StackOperand.pop();
        //存入本地变量表
        Localvariabletable[2] = pop3;
        // Deque<Integer> deque = new ArrayDeque<Integer>();
    }
}
