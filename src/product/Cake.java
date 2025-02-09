package product;

public class Cake extends Product {
    Cake() {
        super();
    }

    public Cake(String name, int price) {
        super(name, price);
    }

    @Override
    public void serve() {
        super.serve();
        System.out.println("\n          ___\n" +
                "        .'   '-._\n" +
                "       /    _.-`|\n" +
                "      / _.-'    |\n" +
                "      |       .-`\n" +
                "      |   _.-'\n" +
                "      '--`" +
                "⢸⡇⣀⣀⣠⡤⠶⠶⠛⠋⠋⠀⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠈⠉⠉⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
    }


}
