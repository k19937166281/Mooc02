package mooc.泛型.GP02;

public class GenericProgrammingMethod {

    public static <T> T getMiddle(T... a){
       return a[a.length/2];
    }

    public static void main(String[] args) {
        String middle = GenericProgrammingMethod.getMiddle("asd", "dfg", "hjk");

        Object middle2 = GenericProgrammingMethod.getMiddle("asd", new StringBuffer("dfg"), new StringBuilder("hjk"));

        Integer middle3 = GenericProgrammingMethod.<Integer>getMiddle(1,1,1);

        //使用不同类型   Integer Float Long  会自动推导出共同的超类（父类）
        Number middle1 = GenericProgrammingMethod.getMiddle(1, 1L, 1.0f);
    }


}
