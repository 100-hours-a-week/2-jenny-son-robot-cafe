package product;

public class Beverage extends Product {
    Beverage () {
        super();
    }

    Beverage (String name, int price) {
        super(name, price);
    }


    @Override
    public void serve() {
        System.out.println("음료 제조가 완료되었습니다.");
        super.serve();
    }
}
