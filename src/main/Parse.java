package main;

import java.util.HashMap;
import java.util.Map;

public class Parse {

    private final Map<String, Integer> romeArabMap = new HashMap<>();

    public Parse() {
        romeArabMap.put("I", 1);
        romeArabMap.put("II", 2);
        romeArabMap.put("III", 3);
        romeArabMap.put("IV", 4);
        romeArabMap.put("V", 5);
        romeArabMap.put("VI", 6);
        romeArabMap.put("VII", 7);
        romeArabMap.put("VIII", 8);
        romeArabMap.put("IX", 9);
        romeArabMap.put("X", 10);
    }

    public boolean IsArabNumber(String str) {
        return romeArabMap.containsValue(str);
    }

    public boolean isRomanNumber(String str) {
        return romeArabMap.containsKey(str);
    }

    public String arabToRomeConvert(Integer num){
        for ( String key : romeArabMap.keySet() ) {
            if (key.equals(num.toString())){
                return key;
            }
        }
        return null;
    }

    public Integer romeToArabConvert(String st){
            return romeArabMap.get(st);

    }

    public boolean checkOperator(String op) {
        return "+".equals(op) || "-".equals(op) || "*".equals(op) || "/".equals(op);
    }
}
