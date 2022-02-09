import javafx.geometry.VerticalDirection;

public class Line {

    public String[][] drawLine(int x1, int y1, int x2, int y2, String[][] frame) throws CanvasException {

        if (x1 <= 0 || y1 <= 0 || x2 <= 0 || y2<= 0) {
            throw new CanvasException("Coordinates cannot be less than or equal to 0");
        }

        if (x1 > frame[0].length || x2 > frame[0].length) {
            throw new CanvasException("Coordinates cannot pass the size of the frame");
        }

        if (y1 > frame.length || y2 > frame.length) {
            throw new CanvasException("Coordinates cannot pass the size of the frame");
        }

        boolean isHori = isHorizontal(x1, y1, x2, y2);
        boolean isVerti = isVertical(x1, y1, x2, y2);

        if (!isHori && !isVerti) {
            throw new CanvasException("Not a straight line");
        }

        if (isHori) {
            int row = y1;

            if (x1 <= x2) {
                for (int col = x1; col <= x2; col++) {
                    frame[row][col] = Const.COLOR_LINE;
                }
            } else {
                for (int col = x2; col <= x1; col++) {
                    frame[row][col] = Const.COLOR_LINE;
                }
            }

        }

        if (isVerti) {
            int col = x1;

            if (y1 <= y2) {
                for (int row = y1; row <= y2; row++) {
                    frame[row][col] = Const.COLOR_LINE;
                }
            } else {
                for (int row = y2; row <= y1; row++) {
                    frame[row][col] = Const.COLOR_LINE;
                }
            }

        }

        return frame;
    }

    private boolean isHorizontal(int x1, int y1, int x2, int y2) {

        if (y1 == y2) {
            return  true;
        } else {
            return  false;
        }
    }

    private boolean isVertical(int x1, int y1, int x2, int y2) {

        if (x1 == x2) {
            return  true;
        } else {
            return  false;
        }
    }
}
