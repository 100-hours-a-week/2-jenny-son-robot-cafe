import order.Kiosk;
import order.KioskStatus;
import robot.MyRunnable;
import robot.Robot;
import utils.Validator;
import product.Beverage;
import product.Product;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) {
        Kiosk kiosk = new Kiosk(); // 키오스크 객체 (주문과 결제 로직을 처리한다.)
        CompletedBeverageList completedBeverages = new CompletedBeverageList();  // 제조 완료된 음료 리스트
        ReentrantLock lock = new ReentrantLock();

        try (ExecutorService threadPool = Executors.newFixedThreadPool(2);) { // 로봇은 동시에 2개만 실행가능하다.
            while (true) {
                // 키오스크에서 주문과 결제를 진행한다.
                Product orderedProduct = kiosk.run(); // orderedProduct: 주문과 결제가 완료된 상품

                // 상품이 음료면 로봇에게 일을 시키고, 케익이면 바로 서빙한다.
                if (orderedProduct instanceof Beverage) {
                    Robot robot = new Robot((Beverage) orderedProduct, beverage -> {
                        // 음료 제조가 완료되었을 때, 키오스크가 사용 중이 아니라면 음료를 서빙한다.
                        if (KioskStatus.WAITING == kiosk.getStatus()){
                            // 음료 서빙 (출력) 중에 키오스크에서 주문할 수 없도록 하고 싶다. 
                            // 즉, 사용자가 주문 계속하시겠습니까? 1 입력해도 run 안 되도록.
                            if (lock.tryLock()) {
                                try {
                                    orderedProduct.serve();
                                } finally {
                                    lock.unlock();
                                }
                            }
                        } else { // 키오스크가 사용 중이라면 완료리스트에 음료를 추가한 후, 키오스크 주문이 끝난 후 서빙한다.
                            completedBeverages.add(beverage);
                        }
                    });
                    threadPool.execute(new MyRunnable(robot)); // 스레드에 로봇 주문 제조 할당
                } else {
                    orderedProduct.serve();
                }

                // 키오스크 주문이 끝난 후 서빙을 대기 중인 음료가 있다면 한꺼번에 출력한다.
                completedBeverages.serveAll();

                System.out.println("주문을 계속하시겠습니까? (예: 1, 아니오(종료): 0)");
                boolean input = Validator.getValidBooleanInput();
                if (!input) {
                    break;
                }
            }
            completedBeverages.serveAll();
            System.out.println("주문 시스템이 종료되었습니다.");
        }
    }
}