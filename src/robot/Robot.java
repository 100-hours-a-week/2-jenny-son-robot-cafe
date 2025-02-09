package robot;

import product.Beverage;

public class Robot {
    private final Beverage beverage;
    private final OnDrinkReadyCallback callback;

    public Robot(Beverage beverage, OnDrinkReadyCallback callback){
        this.beverage = beverage;
        this.callback = callback; // 추상 메서드가 구현됨
    };

    // 음료 제조하는 함수
    public void makeDrink(){
        System.out.println(Thread.currentThread().getName() + " 스레드에서 " + beverage.getName() + " 제조 중...");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) { }

        // 제조 완료 알림
        callback.onDrinkReady(beverage);
    };

}
