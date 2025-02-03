package products;

public class Beverage extends Product {
    Beverage () {
        super();
    }

    Beverage (String name, int price) {
        super(name, price);
    }


    // 음료를 제조하고, 제조하는 동안 로딩바를 출력하는 함수
    public void make() {
        System.out.println("제조를 시작합니다.");
        try {
            System.out.print("[");
            for (int i = 0; i < 7; i++) {
                System.out.print(">");
                Thread.sleep(300);
            }
            System.out.println("]");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void serve() {
        make();
        System.out.println("음료 제조가 완료되었습니다.");
        super.serve();
    }
}
