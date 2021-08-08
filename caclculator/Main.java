package caclculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        try{
            System.out.println("Введите выражение вида : \"Число1 Операция Число2\"");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String calc = reader.readLine();

            Calculator calculator = new Calculator();
            String result = calculator.result(calc);
            System.out.println("Ответ: " + result);
        }
        catch(CalculatorException | IOException e){
            System.out.println(e.getStackTrace().toString());
        }

    }
}
