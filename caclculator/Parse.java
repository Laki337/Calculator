package caclculator;

import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.*;

public class Parse {

    private static List<String> list = new ArrayList<String>();
    private final TreeMap<Integer, String> map = new TreeMap<Integer, String>();
    public Parse() {
        list.add( "Забиваю нулевое значение");
        list.add( "I");
        list.add("II");
        list.add("III");
        list.add("IV");
        list.add("V");
        list.add("VI");
        list.add("VII");
        list.add("VIII");
        list.add("IX");
        list.add("X");

        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");
    }

    public boolean isNumeric(String str) {

        NumberFormat formatter = NumberFormat.getInstance();
        ParsePosition pos = new ParsePosition(0);
        formatter.parse(str, pos);
        return str.length() == pos.getIndex();
    }

    public String arabToRomeConvert(Integer number){
        System.out.println(number);
        int i = map.floorKey(number);
        System.out.println(i);
        if (number == i) {
            return map.get(number);
        }
        return map.get(i) + arabToRomeConvert(number - i);


    }

    public Integer romeToArabConvert(String number){
        return list.indexOf(number);

    }

    public boolean checkOperator(String op) {
        return "+".equals(op) || "-".equals(op) || "*".equals(op) || "/".equals(op);
    }
}
