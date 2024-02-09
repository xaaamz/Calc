package com.xamz;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.List;
import java.util.Arrays;

public class Qenty {

    private static Map<String, Integer> romanMap = new HashMap<>();

    static {
        romanMap.put("I", 1);
        romanMap.put("II", 2);
        romanMap.put("III", 3);
        romanMap.put("IV", 4);
        romanMap.put("V", 5);
        romanMap.put("VI", 6);
        romanMap.put("VII", 7);
        romanMap.put("VIII", 8);
        romanMap.put("IX", 9);
        romanMap.put("X", 10);
    }

    static List<String> arabicNumerals = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10");
    static List<String> romanNumerals = Arrays.asList("I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X");

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите выражение:");
        String sc = scanner.nextLine();
        String[] spl = sc.split(" ");
        if (arabicNumerals.contains(spl[0])) {
            int num1 = (Integer.parseInt(spl[0]));
            int num2 = (Integer.parseInt(spl[2]));
            String operator = spl[1];
            int result = calculate(num1, num2, operator);
            System.out.println("Результат: " + result);
        } else if (romanNumerals.contains(spl[0])) {
            String num1 = spl[0];
            String operator = spl[1];
            String num2 = spl[2];
            int result = calculate(romanMap.get(num1), romanMap.get(num2), operator);
            if(result < 1 ){
                throw new RuntimeException("Результат не может быть меньше 1");
            }
            System.out.println("Результат: " + intToRoman(result));
        } else  {
            throw new IllegalArgumentException("Вы ввели некорректное число");
        }
    }

    private static int calculate(int num1, int num2, String operator) {
        switch (operator) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                return num1 / num2;
            default:
                throw new IllegalArgumentException("Неверный оператор");
        }
    }

    private static String intToRoman(int num) {
        String[] romanUnits = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        String[] romanTens = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC", "C"};
        int unit = num % 10;
        int ten = num / 10;

        return romanTens[ten] + romanUnits[unit];
    }
}