package product;

public class Shake extends Beverage {
    boolean whipping;

    Shake(){
        super();
    }
    Shake (String name, int price) {
        super(name, price);
        this.whipping = true;
    }
    public Shake(String name, int price, boolean whipping) {
        super(name, price);
        this.whipping = whipping;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("- 휘핑크림: " + (whipping?"선택":"미선택"));
    }

    public void shake() {
        System.out.println("...");
    }

    @Override
    public void serve() {
        super.serve();
        System.out.println(
                "\n        /(\n" +
                "       (\\\\)     //\n" +
                "      (~\\\\)    //\n" +
                "     (\\\\~\\\\)  //\n" +
                "     (~\\\\~\\\\)//  \n" +
                "    (\\\\~\\\\~\\\\)   \n" +
                "    \\|-|-|-|/\n" +
                "     |-|-|-|\n" +
                "      \\|-|/\n" +
                "       |||\n" +
                "      /_|_\\");
    }
}
