package order;

import product.Product;

public class Kiosk {
    private KioskStatus status = KioskStatus.WAITING;

    public Kiosk(){};

    public KioskStatus getStatus() { return status; }

    // 하나의 주문에 대해 주문부터 결제까지 수행하는 함수
    public Product run() {
        status = KioskStatus.RUNNING;

        printHome();
        System.out.println();

        // 주문을 받는다.
        Order order = new Order();
        Product product = order.makeOrder();

        printOneLine();

        // 주문 내역을 출력한다.
        order.displayOrder();  // product.display();
        int price = order.getPrice(); // product.getPrice();

        printOneLine();

        // 결제를 진행한다.
        Payment payment = new Payment(price);
        payment.pay();
        printTwoLine();

        status = KioskStatus.WAITING;
        return product;
    }

    private static void printOneLine() {
        System.out.println("⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺");
    }
    private static void printTwoLine() {
        System.out.println("⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺");
        System.out.println("⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺");
    }
    private static void printHome() {
        System.out.println("✱✱✱✱✱✱✱✱✱✱✱✱✱✱✱✱✱✱✱✱✱✱✱✱✱✱✱✱✱✱✱✱");
        System.out.println("     안녕하세요. 로봇 카페입니다.");
        System.out.println("✱✱✱✱✱✱✱✱✱✱✱✱✱✱✱✱✱✱✱✱✱✱✱✱✱✱✱✱✱✱✱✱");
    }
}
