import product.Beverage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CompletedBeverageList {
    private List<Beverage> completedBeverages = Collections.synchronizedList(new ArrayList<>());

    public void add(Beverage beverage) {
        completedBeverages.add(beverage);
    }

    public synchronized void serveAll() {
        for (Beverage beverage: completedBeverages) {
            beverage.serve();
        }
        completedBeverages.clear();
    }
}
