import order.Kiosk;
import robot.MyRunnable;
import robot.Robot;
import utils.Validator;
import product.Beverage;
import product.Product;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        Kiosk kiosk = new Kiosk();
        try (ExecutorService threadPool = Executors.newFixedThreadPool(2);) { // 로봇은 동시에 2개만 실행가능하다.
            while (true) {
                // 주문과 결제를 진행한다.
                Product orderedProduct = kiosk.run(); // 주문과 결제가 완료된 상품

                // 상품이 음료면 로봇에게 일을 시키고, 케익이면 바로 서빙한다.
                if (orderedProduct instanceof Beverage) {
                    Robot robot = new Robot((Beverage) orderedProduct, Beverage::serve); // 음료 주문을 가진 로봇 객체 생성. 제조가 완료되면 음료를 서빙함.
                    threadPool.execute(new MyRunnable(robot)); // 스레드에 로봇 주문 제조 할당
                } else {
                    orderedProduct.serve();
                }

                // 스레드에서 음료 제조가 완료되면 음료를 서빙한다. 단, 키오스크가 주문/결제를 하고 있지 않을 때 서빙한다.
                // -> 제조가 완료됐다는 알림 받기. 제조가 완료된 음료는 대기열에 담아둔다.
                //    주문이 완료됐다는 알림 받기. 키오스크가 동작 안하는 상태면 대기열 확인하고 서빙한다.

                System.out.println("주문을 계속하시겠습니까? (예: 1, 아니오(종료): 0)");
                boolean input = Validator.getValidBooleanInput();
                if (!input) {
                    break;
                }
            }
            System.out.println("주문 시스템이 종료되었습니다.");
        }
    }
}