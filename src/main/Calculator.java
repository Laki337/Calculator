package main;

import java.util.Arrays;
import java.util.List;

public class Calculator {
    private int number1;
    private int number2;

    private String operator;

    private int calc(int num1, String op, int num2) throws CalculatorException {
        int res;
        switch (op) {
            case "+":
                res = num1 + num2;
                break;
            case "-":
                res = num1 - num2;
                break;
            case "*":
                res = num1 * num2;
                break;
            case "/":
                res = num1 / num2;
                break;
            default:
                throw new CalculatorException("ОШИБКА. Некоректные данные ");
        }
        return res;
    }

    public String result(String exp) throws CalculatorException {
        boolean isRomanNumber;
        Parse parse = new Parse();

        List<String> numbers = Arrays.asList(exp.split(" "));

        if (numbers.size() != 3) {
            throw new CalculatorException("ОШИБКА. Выражение слишком длинное ");
        }

        if (parse.checkOperator(numbers.get(1))) {
            operator = numbers.get(1);
        } else {
            throw new CalculatorException("ОШИБКА." + numbers.get(1) + " некоректный оператор. Используйте  + - * / ");
        }
        if (parse.IsArabNumber(numbers.get(0)) && parse.IsArabNumber(numbers.get(2))) {
            number1 = Integer.parseInt(numbers.get(0));
            number2 = Integer.parseInt(numbers.get(2));
            isRomanNumber = false;
        } else if (parse.isRomanNumber(numbers.get(0)) && parse.isRomanNumber(numbers.get(2))) {
            number1 = parse.romeToArabConvert(numbers.get(0));
            number2 = parse.romeToArabConvert(numbers.get(2));
            isRomanNumber = true;
        } else {
            throw new CalculatorException("ОШИБКА. Числа должны быть из одной системы исчисления");
        }
        if (number1 < 0 || number1 > 11 || number2 < 0 || number2 > 11) {
            throw new CalculatorException("ОШИБКА. Число должно быть от одного до десяти включительно");
        }

        int res = calc(number1, operator, number2);

        if (isRomanNumber) {
            return parse.arabToRomeConvert(res);
        }
        return String.valueOf(res);
    }

}
