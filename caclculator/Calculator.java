package caclculator;

import caclculator.Action.*;

import java.util.Arrays;
import java.util.List;

public class Calculator {
    private int number1;
    private int number2;

    private String operator;

    private int calc(int num1, String op, int num2) throws CalculatorException {
        Action action;
        int res;
        switch (op) {
            case "+":
                action = new Addition();
                res = action.invoke(num1, num2);
                break;
            case "-":
                action = new Subtraction();
                res = action.invoke(num1, num2);
                break;
            case "*":
                action = new Multiplication();
                res = action.invoke(num1, num2);
                break;
            case "/":
                action = new Division();
                res = action.invoke(num1, num2);
                break;
            default:
                throw new CalculatorException("ОШИБКА. Некоректные данные ");
        }
        return res;
    }

    public String result(String exp) throws CalculatorException {
        boolean isRoman = false;
        Parse parse = new Parse();

        List<String> numbers = Arrays.asList(exp.split(" "));

        if (numbers.size() > 3) {
            throw new CalculatorException("ОШИБКА. Формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        }

        if (numbers.size() < 3 ){
            throw new CalculatorException("ОШИБКА. Cтрока не является математической операцией");
        }

        if (parse.checkOperator(numbers.get(1))) {
            operator = numbers.get(1);
        } else {
            throw new CalculatorException("ОШИБКА." + numbers.get(1) + " некоректный оператор. Используйте  + - * / ");
        }
        if (parse.isNumeric(numbers.get(0)) != parse.isNumeric(numbers.get(2))) {
            throw new CalculatorException("ОШБИКА. Используются одновременно разные системы счисления");
        }

        try {
            number1 = Integer.parseInt(numbers.get(0));
            number2 = Integer.parseInt(numbers.get(2));
        } catch (Exception e) {
            try {
                number1 = parse.romeToArabConvert(numbers.get(0));
                number2 = parse.romeToArabConvert(numbers.get(2));
                isRoman = true;
            } catch (Exception e1) {
                throw new CalculatorException("ОШИБКА. Формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");

            }
        }

        if (number1 < 0 || number1 > 10 || number2 < 0 || number2 > 10) {
            throw new CalculatorException("ОШИБКА. Число должно быть от одного до десяти включительно");
        }
        int res = calc(number1, operator, number2);
        if (isRoman) {
            if (res < 1) {
                throw new CalculatorException("В римской системе нет отрицательных чисел");
            }
            return parse.arabToRomeConvert((res));
        }
        return String.valueOf(res);
    }

}
