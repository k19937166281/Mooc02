package mooc.lamda.l2;
//系统自带的函数时接口注解，用于编译器检查，如果你想把一个接口标记为函数式接口，推荐使用上它
@FunctionalInterface//自定义 一个函数式接口，，这个注解可以不写,,
public interface StringChecker {
    public boolean test(String s);
}
