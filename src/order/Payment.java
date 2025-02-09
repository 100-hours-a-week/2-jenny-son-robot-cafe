package order;

import java.util.Scanner;

public class Payment {
    int price;
    int payedPrice = 0;

    public Payment(int price) {
        System.out.println("결제를 시작합니다.");
        this.price = price;
    }

    // 사용자로부터 금액을 입력 받아 결제를 수행하는 함수
    public void pay() {
        System.out.println("결제 금액: " + price + "원");
        System.out.println("투입할 금액을 입력해주세요: ");
        Scanner sc = new Scanner(System.in);

        while (true) {
            // 사용자로부터 금액을 투입 받는다.
            while (true) {
                String input = sc.next().trim();
                int inputNum;
                // 입력이 '양의 정수'인 경우에만 입력 받는다.
                try {
                    inputNum = Integer.parseInt(input);
                    if (inputNum > 0) {
                        payedPrice += inputNum;
                        break;
                    }
                    System.out.println("잘못된 입력입니다. 양수를 입력해주세요.");
                } catch (NumberFormatException e) {
                    System.out.println("잘못된 입력입니다. 숫자를 입력해주세요.");
                }
            }

            // 입력된 금액에 대해 결제를 진행한다.
            if (payedPrice < price) {
                System.out.println(price-payedPrice + "원을 더 투입해주세요.");
            } else if (payedPrice == price) {
                System.out.println("결제가 완료되었습니다.");
                break;
            } else {
                System.out.println("결제가 완료되었습니다.");
                System.out.println(payedPrice-price + "원이 반환됩니다.");
                break;
            }
        }
    }

}
