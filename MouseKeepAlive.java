import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Robot;
import java.util.Random;

public class MouseKeepAlive {

    // Check interval: 4 minutes
    private static final long CHECK_INTERVAL = 4 * 60 * 1000;

    // Maximum cursor movement in pixels
    private static final int MAX_OFFSET = 15;

    public static void main(String[] args) throws Exception {

        Robot robot = new Robot();
        Random random = new Random();

        Point lastPosition = MouseInfo.getPointerInfo().getLocation();

        System.out.println("Program started.");

        while (true) {

            Thread.sleep(CHECK_INTERVAL);

            Point currentPosition = MouseInfo.getPointerInfo().getLocation();

// User has moved the mouse
            if (!currentPosition.equals(lastPosition)) {
                lastPosition = currentPosition;
                System.out.println("Mouse moved by user.");
                continue;
            }

            System.out.println("No mouse movement detected for 4 minutes. Starting random movement.");

            int moves = 3 + random.nextInt(15); // Perform 3 to 17 random movements

            for (int i = 0; i < moves; i++) {

                Point beforeMove = MouseInfo.getPointerInfo().getLocation();

// Stop immediately if the user moved the mouse
                if (!beforeMove.equals(lastPosition)) {
                    System.out.println("User movement detected. Stopping random movement.");
                    lastPosition = beforeMove;
                    break;
                }

                int dx = random.nextInt(MAX_OFFSET * 2 + 1) - MAX_OFFSET;
                int dy = random.nextInt(MAX_OFFSET * 2 + 1) - MAX_OFFSET;

                robot.mouseMove(beforeMove.x + dx, beforeMove.y + dy);

                Thread.sleep(300);

                Point afterMove = MouseInfo.getPointerInfo().getLocation();

// If the cursor is not where the Robot placed it,
// assume the user has taken control
                if (Math.abs(afterMove.x - (beforeMove.x + dx)) > 1 ||
                        Math.abs(afterMove.y - (beforeMove.y + dy)) > 1) {

                    System.out.println("User movement detected. Stopping random movement.");
                    lastPosition = afterMove;
                    break;
                }

                lastPosition = afterMove;
            }
        }
    }
}
