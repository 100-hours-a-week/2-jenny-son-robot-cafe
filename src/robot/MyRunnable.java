package robot;

public class MyRunnable implements Runnable {
    public Robot robot;

    public MyRunnable (Robot robot) {
        this.robot = robot;
    }

    @Override
    public void run() {
        robot.makeDrink();
    }
}
