package product;

public class Product {
    String name;
    int price;

    public Product() {}

    Product (String name, int price) {
        this.name = name;
        this.price = price;
    }

    // 이름과 가격을 출력하는 함수
    public void display() {
        System.out.println(String.format("이름: %s, 가격: %d원", name, price));
    }

    // 가격을 반환하는 함수
    public int getPrice() { return price; }

    // 이름을 반환하는 함수
    public String getName() { return name; }

    // 메뉴 서빙하는 함수
    public void serve() {
        System.out.println("\n" + name + " 메뉴가 준비되었습니다.");
    }
}
