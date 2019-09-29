import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.Random;

public class RobotAction {

    public static final int[] numArr = {0x30, 0x31, 0x32, 0x33, 0x34, 0x35, 0x36, 0x37, 0x38, 0x39};

    public static void StartWork(Robot robot, Random random) {
        PressF11(robot,random);
        moveUp(robot,random);
        moveUp(robot,random);
        PressEnter(robot, random);
        PressEnter(robot, random);
        moveLeft(robot, random);
        PressEnter(robot, random);
        System.out.println("work started");
    }

    public static void MissionWork(Robot robot, Random random) {
        Long startTime = System.currentTimeMillis();
        Long passedMillis;
        while (true) {
            passedMillis = System.currentTimeMillis() - startTime;
            if (passedMillis / 1000 > 200) {
                break;
            }
            randomPressNum(robot, random);
        }
        System.out.println("mission running finished");
    }

    public static void FinishWork(Robot robot, Random random) throws InterruptedException {
        PressEnter(robot, random);
        moveLeft(robot, random);
        PressEnter(robot, random);
        robot.delay(5 * 1000);
        PressEnter(robot, random);
        PressEnter(robot, random);
        System.out.println("mission finished");
    }


    public static void moveLeft(Robot robot, Random random) {
        robot.keyPress(KeyEvent.VK_KP_LEFT);
        robot.keyRelease(KeyEvent.VK_KP_LEFT);
        robot.delay(Math.abs(random.nextInt()) % 100 + 500);
    }

    public static void moveRight(Robot robot, Random random) {
        robot.keyPress(KeyEvent.VK_KP_RIGHT);
        robot.keyRelease(KeyEvent.VK_KP_RIGHT);
        robot.delay(Math.abs(random.nextInt()) % 100 + 500);
    }

    public static void moveUp(Robot robot, Random random) {
        robot.keyPress(KeyEvent.VK_KP_UP);
        robot.keyRelease(KeyEvent.VK_KP_UP);
        robot.delay(Math.abs(random.nextInt()) % 100 + 500);
    }

    public static void moveDown(Robot robot, Random random) {
        robot.keyPress(KeyEvent.VK_KP_DOWN);
        robot.keyRelease(KeyEvent.VK_KP_DOWN);
        robot.delay(Math.abs(random.nextInt()) % 100 + 500);
    }

    public static void PressEnter(Robot robot, Random random) {
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.delay(Math.abs(random.nextInt()) % 2000 + 1000);
    }


    public static void PressF11(Robot robot, Random random) {
        robot.keyPress(KeyEvent.VK_F11);
        robot.keyRelease(KeyEvent.VK_F11);
        robot.delay(Math.abs(random.nextInt()) % 1000 + 1000);
    }

    public static void randomPressNum(Robot robot, Random random) {
        int randomNum = numArr[random.nextInt(10)];
        robot.keyPress(randomNum);
        robot.keyRelease(randomNum);
        robot.delay(Math.abs(random.nextInt()) % 100 + 500);
    }

    public static void moveMouse(Robot robot) {
        robot.mouseMove(50, 750);
    }

    public static void clickMouse(Robot robot, Random random) {
        //单击右键
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        robot.delay(Math.abs(random.nextInt()) % 100 + 1000);
    }
}
