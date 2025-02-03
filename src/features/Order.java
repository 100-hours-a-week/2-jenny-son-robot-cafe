package features;

import products.*;

import java.util.Scanner;

public class Order {
    int menuLen = 7;  // 메뉴 개수
    String[] names = {"아메리카노", "카페라떼", "바닐라라떼", "초코쉐이크", "오레오쉐이크", "딸기케이크", "치즈케이크"};  // 메뉴 이름
    int[] prices = {2000, 3000, 3000, 4500, 4500, 5000, 5000};  // 메뉴 가격
    Product product;  // 주문 받을 객체

    private Scanner sc;

    public Order() {
        this.sc = new Scanner(System.in);
        System.out.println("주문을 시작합니다.");
    }

    // 메뉴판을 출력하는 함수
    private void displayMenu() {
        System.out.println("⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺");
        System.out.printf("          %-10s    \n", "메 뉴");
        System.out.println("-------------------------");
        System.out.printf(" %s \n", "- 커피");
        System.out.printf("   %d. %s \n", 1, "아메리카노");
        System.out.printf("   %d. %s \n", 2, "카페라떼");
        System.out.printf("   %d. %s \n", 3, "바닐라라떼");
        System.out.println("-------------------------");
        System.out.printf(" %s \n", "- 쉐이크");
        System.out.printf("   %d. %s \n", 4, "초코쉐이크");
        System.out.printf("   %d. %s \n", 5, "오레오쉐이크");
        System.out.println("-------------------------");
        System.out.printf(" %s \n", "- 케이크");
        System.out.printf("   %d. %s \n", 6, "딸기케이크");
        System.out.printf("   %d. %s \n", 7, "치즈케이크");
        System.out.println("⎽⎽⎽⎽⎽⎽⎽⎽⎽⎽⎽⎽⎽⎽⎽⎽⎽⎽⎽⎽⎽⎽⎽⎽⎽");
        System.out.println();
    }

    // 사용자에게 한 가지 메뉴를 주문 받아 객체로 반환하는 함수
    public Product makeOrder() {
        // 메뉴판을 보여준다.
        displayMenu();

        // 사용자로부터 메뉴를 입력 받는다.
        int menuNum = getMenuNumber();

        // 입력 받은 메뉴에 대해 추가 옵션을 입력 받아 주문을 처리한다.
        switch (menuNum) {
            case 1:
            case 2:
            case 3:
                // 사용자로부터 커피 옵션을 선택 받아 Coffee 객체를 생성한다.
                Size size = getSizeOption();
                Temperature temp = getTempOption();
                boolean decaffein = getDecafOption();

                product = new Coffee(names[menuNum - 1], prices[menuNum - 1], size, temp, decaffein);
                break;
            case 4:
            case 5:
                // 사용자로부터 쉐이크 옵션을 선택 받아 Shake 객체를 생성한다.
                boolean whipping = getWhippingOption();
                product = new Shake(names[menuNum - 1], prices[menuNum - 1], whipping);
                break;
            case 6:
            case 7:
                // Cake 객체를 생성한다.
                product = new Cake(names[menuNum - 1], prices[menuNum - 1]);
                break;
            default:
                product = new Product();
                break;
        }
        return product;
    }

    // 주문이 완료된 내용을 출력하는 함수
    public void displayOrder() {
        System.out.println("선택하신 메뉴는 다음과 같습니다.");
        product.display();
    }

    // 총 금액을 출력하는 함수
    public int getPrice() {
        return product.getPrice();
    }

    // 사용자로부터 주문할 메뉴 번호를 입력 받는 함수
    private int getMenuNumber() {
        System.out.println("메뉴를 선택해주세요. (메뉴 번호 입력)");
        while (true) {
            String input = sc.next().trim();
            try {
                int inputNum = Integer.parseInt(input);
                if (inputNum >= 1 & inputNum <= menuLen) {
                    return inputNum;
                }
                System.out.println("잘못된 입력입니다. 메뉴판에 있는 번호를 입력해주세요.");
            } catch (NumberFormatException e) {
                System.out.println("잘못된 입력입니다. 숫자를 입력해주세요.");
            }
        }
    }

    // 사용자로부터 음료 사이즈를 입력 받는 함수
    private Size getSizeOption() {
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

    // 사용자로부터 음료 온도를 입력 받는 함수
    private Temperature getTempOption() {
        System.out.println("온도를 선택해주세요. (hot/cold)");  // 0, 1 숫자로 입력받는게 더 좋은건지?
        while (true) {
            String input = sc.next().trim();
            try {
                return Temperature.fromString(input);
            } catch (IllegalArgumentException e) {
                System.out.println("잘못된 입력입니다. 다시 입력해주세요. (hot/cold)");
            }
        }
    }

    // 사용자로부터 디카페인 여부를 입력 받는 함수
    private boolean getDecafOption() {
        System.out.println("디카페인 여부를 선택해주세요. (예: 0, 아니오: 1)");
        while (true) {
            String input = sc.next().trim();
            if (input.equals("0") || input.equals("1")) {
                return input.equals("0");
            }
            System.out.println("잘못된 입력입니다. 다시 입력해주세요. (예: 0, 아니오: 1)");
        }
    }

    // 사용자로부터 휘핑크림 여부를 입력 받는 함수
    private boolean getWhippingOption() {
        System.out.println("휘핑크림을 추가하시겠습니까? (예: 0, 아니오: 1)");
        while (true) {
            String input = sc.next().trim();
            if (input.equals("0") || input.equals("1")) {
                return input.equals("0");
            }
            System.out.println("잘못된 입력입니다. 다시 입력해주세요. (예: 0, 아니오: 1)");
        }
    }
}


