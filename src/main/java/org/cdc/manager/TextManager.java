package org.cdc.manager;

public class TextManager {
    public static String format(String text,String... args){
        String result = text;
        for (int index = 0;index<args.length;index+=2){
            String name = args[index];
            String value = args[index + 1];
            result = result.replaceAll("\\["+name+"]",value);
        }
        return result;
    }
}
