package org.myspringfromwork.util;

/**
 * 字符串工具类
 * @Author darren
 * @Date 2022/11/7 9:42
 */
public class StringUtil {

    /**
     * 使字符串首字母大写
     * @param str
     * @return String
     */
    public static String capitalLettersUpperCase(String str){
        return str.toUpperCase().charAt(0) + str.substring(1);
    }

    /**
     * 编程set方法
     * @return
     */
    public static String becomeSetMethod(String attributesName){
        return "set" + capitalLettersUpperCase(attributesName);
    }


    /**
     * 类型转换
     * @param value 值
     * @param type 对应的类型
     * @return Object
     */
    public static Object typeConversion(String value, Class<?> type){
        String simpleName = type.getSimpleName();
        Object truthValue = null;
        switch (simpleName){
            case "byte":    truthValue = Byte.parseByte(value); break;
            case "short":   truthValue = Short.parseShort(value); break;
            case "int":     truthValue = Integer.parseInt(value); break;
            case "long":    truthValue = Long.parseLong(value); break;
            case "float":   truthValue = Float.parseFloat(value); break;
            case "double":  truthValue = Double.parseDouble(value); break;
            case "char":    truthValue = value.charAt(0); break;
            case "boolean": truthValue = Boolean.parseBoolean(value); break;

            case "Byte":    truthValue = Byte.valueOf(value);       break;
            case "Short":   truthValue = Short.valueOf(value);      break;
            case "Integer": truthValue = Integer.valueOf(value);    break;
            case "Long":    truthValue = Long.valueOf(value);       break;
            case "Float":   truthValue = Float.valueOf(value);      break;
            case "Double":  truthValue = Double.valueOf(value);     break;
            case "Character": truthValue = Character.valueOf(value.charAt(0)); break;
            case "Boolean": truthValue = Boolean.valueOf(value);    break;
            default:truthValue = value;
        }
        return truthValue;
    }
}
