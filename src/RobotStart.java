import java.awt.*;
import java.util.Random;

public class RobotStart {

    public static void main(String[] args) throws AWTException, InterruptedException {
        Robot robot = new Robot();
        robot.delay(10000);
        Random random = new Random();
        int count=0;
        while (true) {
            RobotAction.StartWork(robot,random);
            robot.delay(3000);
            RobotAction.MissionWork(robot,random);
            robot.delay(1000);
            RobotAction.FinishWork(robot,random);
            count++;
            System.out.println(count);
        }
    }
}
