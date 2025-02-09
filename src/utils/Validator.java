package utils;

import product.Size;
import product.Temperature;

import java.util.Scanner;

public class Validator {
    private static Scanner sc = new Scanner(System.in);

    public static int getValidIntegerInput (int min, int max) {
        while (true) {
            String input = sc.next().trim();
            try {
                int inputNum = Integer.parseInt(input);
                if (inputNum >= min & inputNum <= max) {
                    return inputNum;
                }
                System.out.println("잘못된 입력입니다. 유효한 숫자를 입력해주세요.");
            } catch (NumberFormatException e) {
                System.out.println("잘못된 입력입니다. 정수를 입력해주세요.");
            }
        }
    }

    public static boolean getValidBooleanInput () {
        while (true) {
            String input = sc.next().trim();
            if (input.equals("1") || input.equals("0")) {
                return input.equals("1");
            }
            System.out.println("잘못된 입력입니다. 다시 입력해주세요. (예: 1, 아니오: 0)");
        }
    }

    public static Temperature getValidTemperatureInput() {
        System.out.println("온도를 선택해주세요. (hot/cold)");
        while (true) {
            String input = sc.next().trim();
            try {
                return Temperature.fromString(input);
            } catch (IllegalArgumentException e) {
                System.out.println("잘못된 입력입니다. 다시 입력해주세요. (hot/cold)");
            }
        }
    }

    public static Size getValidSizeInput() {
        System.out.println("사이즈를 선택해주세요. (tall/grande/venti)");
        while (true) {
            String input = sc.next().trim();
            try {
                return Size.fromString(input);
            } catch (IllegalArgumentException e) {
                System.out.println("잘못된 입력입니다. 다시 입력해주세요. (tall/grande/venti)");
            }
        }
    }
}
