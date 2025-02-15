package Utilities;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Tools {


    public void robotClick(int number) {

        try {
            Robot robot =new Robot();
            for (int i = 0; i <= number; i++) {
                robot.keyPress(KeyEvent.VK_TAB);
                robot.keyRelease(KeyEvent.VK_TAB);
                wait(1);
            }
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
    }

    public void wait(int number) {

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
