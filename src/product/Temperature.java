package product;

public enum Temperature {
    HOT("hot"),
    COLD("cold");  // 생성자로 COLD 상수를 만들면서 인수로 "cold"를 넣어 아래 value 변수에 저장한다.

    private final String value;  // 문자열을 enum과 연결.

    Temperature (String value) {
        this.value = value;
    }

    public String getValue () {
        return value;
    }

    // text가 Temperature 상수 중 하나와 일치하는지 확인하고, 일치하는 상수를 반환한다.
    public static Temperature fromString (String text) {
        for (Temperature temp: Temperature.values()) {
            if (temp.getValue().equalsIgnoreCase(text)) {
                return temp;
            }
        }
        throw new IllegalArgumentException("Invalid temperature: " + text);
    }

}
