package product;

public class Coffee extends Beverage{
    Size size;  // tall, grande, venti
    Temperature temperature;  // hot, cold
    boolean decaffein;

    Coffee(){
        super();
    }
    Coffee (String name, int price) {
        super(name, price);
        this.size = Size.TALL;
        this.temperature = Temperature.COLD;
        this.decaffein = false;
    }
    public Coffee(String name, int price, Size size, Temperature temperature, boolean decaffein) {
        super(name, price);
        this.size = size;
        this.temperature = temperature;
        this.decaffein = decaffein;
    }

    @Override
    public void display() {
        super.display();
        System.out.println(String.format("- 사이즈: %s | 옵션: %s | 디카페인: %s", size.name(), temperature.name(), decaffein?"예":"아니오"));
    }

    @Override
    public void serve() {
        super.serve();
        if (temperature.equals(Temperature.HOT)) {
            System.out.println("    )  (\n" +
                    "     (   ) )\n" +
                    "      ) ( (\n" +
                    "    _______)_\n" +
                    " .-'---------|  \n" +
                    "( C|/\\/\\/\\/\\/|\n" +
                    " '-./\\/\\/\\/\\/|\n" +
                    "   '_________'\n" +
                    "    '-------'");
        }
        else {
            System.out.println("\n .-'\"\"\"`-.\n" +
                    "(         )\n" +
                    "|`-.___.-'|\n" +
                    "|.-'\"\"\"`-.|\n" +
                    "|         |\n" +
                    "|`-.___.-'|\n" +
                    "|         |\n" +
                    "|. ' \" ` .|\n" +
                    "|         |\n" +
                    " `-.___.-'\n");
        }
    }
}
