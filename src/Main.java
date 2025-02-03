import features.Order;
import features.Payment;
import products.Product;

public class Main {
    public static void main(String[] args) {
        printHome();
        System.out.println();

        // 주문을 받는다.
        Order order = new Order();
        Product product = order.makeOrder();

        printLine();

        // 주문 내역을 출력한다.
        order.displayOrder();  // product.display();
        int price = order.getPrice(); // product.getPrice();

        printLine();

        // 결제를 진행한다.
        Payment payment = new Payment(price);
        payment.pay();

        printLine();

        // 준비된 메뉴를 서빙한다.
        product.serve();
    }

    private static void printLine() {
        System.out.println("⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺");
        System.out.println("⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺");
    }
    private static void printHome() {
        System.out.println("✱✱✱✱✱✱✱✱✱✱✱✱✱✱✱✱✱✱✱✱✱✱✱✱✱✱✱✱✱✱✱✱");
        System.out.println("     안녕하세요. 로봇 카페입니다.");
        System.out.println("✱✱✱✱✱✱✱✱✱✱✱✱✱✱✱✱✱✱✱✱✱✱✱✱✱✱✱✱✱✱✱✱");
    }
}