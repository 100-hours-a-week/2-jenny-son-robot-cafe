package product;

public enum Size {
    TALL("tall"),
    GRANDE("grande"),
    VENTI("venti");

    public final String value;

    Size (String value) {
        this.value = value;
    }

    // 아래 getValue 함수와 fromString 함수를 Temperature에도 정의했는데, 두 enum을 추상화해서 중복을 줄일 수 있는지?
    public String getValue() {
        return value;
    }

    // text가 Size 상수 중 하나와 일치하는지 확인하고, 일치하는 상수를 반환한다.
    public static Size fromString (String text) {
        for (Size size: Size.values()) {
            if (size.getValue().equalsIgnoreCase(text)) {
                return size;
            }
        }
        throw new IllegalArgumentException("Invalid size: " + text);
    }
}
