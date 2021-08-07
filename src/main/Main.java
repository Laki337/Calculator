package main;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        try{
            System.out.println("Калькулятор для выражений вида: \"Число1 Операция Число2\", через пробел. Допускаются числа от 1 до 10 или от I до X включительно. Операции: + - * /");
            System.out.print("Введите выражение вида : ");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String calc = reader.readLine();

            Calculator calculator = new Calculator();
            String result = calculator.result(calc);
            System.out.println("Ответ: " + result);
        }
        catch(Exception e){

        }

    }
}
