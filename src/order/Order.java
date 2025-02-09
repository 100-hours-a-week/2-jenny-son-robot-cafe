package order;

import product.Product;
import utils.Validator;

public class Order {
    Product product;  // 주문 받을 객체

    public Order() {
        System.out.println("주문을 시작합니다.");
    }

    // 사용자에게 한 가지 메뉴를 주문 받아 객체로 반환하는 함수
    public Product makeOrder() {
        // 메뉴판을 보여준다.
        Menu.displayMenu();

        // 사용자로부터 메뉴를 입력 받는다.
        System.out.println("메뉴를 선택해주세요. (메뉴 번호 입력)");
        int menuNum = Validator.getValidIntegerInput(1, Menu.getMenuLen());

        // 입력 받은 메뉴에 대해 추가 옵션을 입력 받아 주문을 처리한다.
        product = ProductFactory.createProduct(menuNum);
        return product;
    }

    // 주문이 완료된 내용을 출력하는 함수
    public void displayOrder() {
        System.out.println("선택하신 메뉴는 다음과 같습니다.");
        product.display();
    }

    // 주문이 완료된 총 금액을 반환하는 함수
    public int getPrice() {
        return product.getPrice();
    }
}


