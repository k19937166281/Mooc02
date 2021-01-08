package mooc.语法糖.enumtype;

import java.util.HashMap;

/**
 * @author k1326
 */

public enum DIYEnum {

    DIYEnum1("1","1",new HashMap<String,Object>(){
        {
            put(code,1);
            put(pattern,"^\\d{16,16}-(|.jpg)$");
            put(nameLength,16);
            put(separator,"-");
        }
    }),
    DIYEnum2("2","2",new HashMap<String,Object>(){
        {
            put(code,2);
            put(pattern,"^(19|20)-\\d{17,17}-(|.jpg)$");
            put(nameLength,17);
            put(separator,"-");
        }
    }),
    Default("default","default",new HashMap<String,Object>(){
        {
            put(code,9);
            put(pattern,"");
            put(nameLength,9);
            put(separator,"-");
        }
    });


    private String name;
    private String sex;
    private HashMap<String,Object> options;

    private static final String code = "code";
    private static final String pattern = "pattern";
    private static final String nameLength = "nameLength";
    private static final String separator = "separator";

    //default 或者 private
    DIYEnum(String name, String sex, HashMap<String, Object> options) {
        this.name = name;
        this.sex = sex;
        this.options = options;
    }

    private DIYEnum getDIYEnumOrDefault(int code){
        for (DIYEnum value : DIYEnum.values()) {
            if (value.options.get("code").equals(code)){
                return value;
            }
        }
        return Default;
    }

    private DIYEnum getDIYEnum2(String name){
        return DIYEnum.valueOf(name);
    }

     private DIYEnum getDIYEnum3(String name){
        return DIYEnum.valueOf(DIYEnum.class,name);
    }

}
