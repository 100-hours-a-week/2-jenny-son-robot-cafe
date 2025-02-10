package order;

import product.*;
import utils.Validator;

public class ProductFactory {
    public static Product createProduct (int menuNum) {
        String name = Menu.getName(menuNum);
        int price = Menu.getPrice(menuNum);

        switch (menuNum) {
            case 1:
            case 2:
            case 3:
                // 사용자로부터 커피 옵션을 선택 받아 Coffee 객체를 생성한다.
                Size size = Validator.getValidSizeInput();
                Temperature temp = Validator.getValidTemperatureInput();
                System.out.println("디카페인 여부를 선택해주세요. (예: 1, 아니오: 0)");
                boolean decaffein = Validator.getValidBooleanInput();

                // 사이즈업하는 경우 가격 추가
                if (Size.TALL != size) {
                    price += (Size.GRANDE == size)?1000:1500;
                }

                return new Coffee(name, price, size, temp, decaffein);
            case 4:
            case 5:
                // 사용자로부터 쉐이크 옵션을 선택 받아 Shake 객체를 생성한다.
                System.out.println("휘핑크림을 추가하시겠습니까? (예: 1, 아니오: 0)");
                boolean whipping = Validator.getValidBooleanInput();
                return new Shake(name, price, whipping);
            case 6:
            case 7:
                // Cake 객체를 생성한다.
                return new Cake(name, price);
            default:
                return new Product();
        }
    }
}
