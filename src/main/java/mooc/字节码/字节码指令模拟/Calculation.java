package mooc.字节码.字节码指令模拟;

public class Calculation {
    private int base0 = 10;
    private int base1 = 20;
    //会进入本地变量表，但是不使用
    private int base2 = 30;

    public long calc(int toAdd){
        this.base0+=toAdd;
        //base1字段不显式调用this，测试字节码运算
        this.base0+=base1;
        return this.base0;
    }
}
