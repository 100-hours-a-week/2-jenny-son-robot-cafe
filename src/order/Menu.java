package order;

public class Menu {
    private static int menuLen = 7;  // 메뉴 개수
    private static String[] names = {"아메리카노", "카페라떼", "바닐라라떼", "초코쉐이크", "오레오쉐이크", "딸기케이크", "치즈케이크"};  // 메뉴 이름
    private static int[] prices = {2000, 3000, 3000, 4500, 4500, 5000, 5000};  // 메뉴 가격

    // 메뉴판을 출력하는 함수
    public static void displayMenu() {
        System.out.println("⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺");
        System.out.printf("          %-10s    \n", "메 뉴");
        System.out.println("-------------------------");
        System.out.printf(" %s \n", "- 커피");
        System.out.printf("   %d. %s \n", 1, "아메리카노");
        System.out.printf("   %d. %s \n", 2, "카페라떼");
        System.out.printf("   %d. %s \n", 3, "바닐라라떼");
        System.out.println("-------------------------");
        System.out.printf(" %s \n", "- 쉐이크");
        System.out.printf("   %d. %s \n", 4, "초코쉐이크");
        System.out.printf("   %d. %s \n", 5, "오레오쉐이크");
        System.out.println("-------------------------");
        System.out.printf(" %s \n", "- 케이크");
        System.out.printf("   %d. %s \n", 6, "딸기케이크");
        System.out.printf("   %d. %s \n", 7, "치즈케이크");
        System.out.println("⎽⎽⎽⎽⎽⎽⎽⎽⎽⎽⎽⎽⎽⎽⎽⎽⎽⎽⎽⎽⎽⎽⎽⎽⎽");
        System.out.println();
    }

    public static int getMenuLen() { return menuLen; }

    public static String getName(int menuNum) { return names[menuNum-1]; }

    public static int getPrice(int menuNum) { return prices[menuNum-1]; }

}
