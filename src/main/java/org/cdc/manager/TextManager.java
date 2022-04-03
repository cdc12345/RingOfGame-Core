package org.cdc.manager;

/**
 * @author cdc123
 */
public class TextManager {
    /**
     * 格式化
     * @param text 文本
     * @param args 置换符
     * @return 格式化后的文本
     * @Description 接近弃用
     */
    @Deprecated
    public static String format(String text,String... args){
        String result = text;
        int appendNum = 2;
        for (int index = 0;index<args.length;index+=appendNum){
            String name = args[index];
            String value = args[index + 1];
            result = result.replaceAll("\\["+name+"]",value);
        }
        return result;
    }
}
