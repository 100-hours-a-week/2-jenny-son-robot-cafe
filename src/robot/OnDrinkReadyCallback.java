package robot;

import product.Beverage;

public interface OnDrinkReadyCallback {
    void onDrinkReady(Beverage beverage);
}
