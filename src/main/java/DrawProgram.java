public class DrawProgram {

    public String[][] createFrame(String cmd) throws CanvasException {

        String[] arguments = cmd.split(Const.SPACE_CHARACTER);
        int indexArgumentOfCmd = 0;
        String cmdForCreateFrame = arguments[indexArgumentOfCmd];
        if (!cmdForCreateFrame.equals(Const.CMD_CREATE_FRAME)) {
            throw new CanvasException("Wrong cmd for crate frame");
        }

        int indexArgumentOfWidth = 1;
        int indexArgumentOfHeight = 2;

        int width = 0;
        int height = 0;

        try {
            width = Integer.valueOf(arguments[indexArgumentOfWidth]);
            height = Integer.valueOf(arguments[indexArgumentOfHeight]);
        } catch (NumberFormatException exception) {
            throw new CanvasException("Size not a integer");
        }

        if (width < Const.MINIMUM_SIZE_WIDTH || height < Const.MINIMUM_SIZE_HEIGHT) {
            throw new CanvasException("Smaller than minimum size");
        }

        if (width > Const.MAXIMUM_SIZE_WIDTH || height > Const.MAXIMUM_SIZE_HEIGHT) {
            throw new CanvasException("Bigger than max size");
        }

        String[][] frame = new String[height + Const.OFFSET][width + Const.OFFSET];
        int rowFrame = frame.length;

        int firstRow = 0;
        int colFrame = frame[firstRow].length;

        for (int row = 0; row < rowFrame ; row++) {
            for (int col = 0; col < colFrame; col++) {
                if (row == 0 || row == rowFrame - 1) {
                    frame[row][col] = Const.BORDER_HORIZONTAL;
                } else if (col == 0 || col == colFrame - 1) {
                    frame[row][col] = Const.BORDER_VERTICAL;
                } else {
                    frame[row][col] = Const.SPACE_CHARACTER;
                }
            }
        }

        return frame;
    }

    public String[][] drawLine(String[][] frame, String cmd) throws CanvasException {

        String[] arguments = cmd.split(Const.SPACE_CHARACTER);
        int indexArgumentOfCmd = 0;
        int indexX1 = 1;
        int indexY1 = 2;
        int indexX2 = 3;
        int indexY2 = 4;

        String cmdDrawLine = arguments[indexArgumentOfCmd];
        if (!Const.CMD_DRAW_LINE.equals(cmdDrawLine)) {
            throw new CanvasException("Cmd should be is L");
        }

        int x1 = 0;
        int y1 = 0;
        int x2 = 0;
        int y2 = 0;

        try {
            x1 = Integer.valueOf(arguments[indexX1]);
            y1 = Integer.valueOf(arguments[indexY1]);
            x2 = Integer.valueOf(arguments[indexX2]);
            y2 = Integer.valueOf(arguments[indexY2]);
        } catch (NumberFormatException exception) {
            throw new CanvasException("Argument does not a integer");
        }

        return drawLine(frame, x1, y1, x2, y2);
    }

    public String[][] drawLine(String[][] frame, int x1, int y1, int x2, int y2) throws CanvasException {

        if (x1 <= 0 || y1 <= 0 || x2 <= 0 || y2 <= 0) {
            throw new CanvasException("Coordinates cannot be less than or equal to 0");
        }

        int firstRow = 0;
        int width = frame[firstRow].length - Const.OFFSET;
        int height = frame.length - Const.OFFSET;

        if (x1 > width || y1 > height || x2 > width || y2 > height) {
            throw new CanvasException("Coordinates cannot pass the size of the frame");
        }

        if (x1 != x2 && y1 != y2) {
            throw new CanvasException("Not a straight line");
        }

        if (y1 == y2) {
            int row = y1;

            for (int col = x1; col <= x2; col++) {
                frame[row][col] = Const.COLOR_LINE;
            }
        } else if (x1 == x2){
            int col = x1;

            for (int row = y1; row <= y2; row++) {
                frame[row][col] = Const.COLOR_LINE;
            }
        }

        return frame;
    }

    public String[][] drawRectangle(String[][] frame, String cmd) throws CanvasException {

        String[] arguments = cmd.split(Const.SPACE_CHARACTER);
        int indexArgumentOfCmd = 0;
        int indexAX_1 = 1;
        int indexAY_1 = 2;
        int indexBX_1 = 3;
        int indexBY_1 = 4;

        String cmdDrawRectangle = arguments[indexArgumentOfCmd];

        if (!Const.CMD_DRAW_RECTANGLE.equals(cmdDrawRectangle)) {
            throw new CanvasException("Cmd must be R");
        }

        int AX_1 = 0;
        int AY_1 = 0;
        int BX_1 = 0;
        int BY_1 = 0;

        try {
            AX_1 = Integer.valueOf(arguments[indexAX_1]);
            AY_1 = Integer.valueOf(arguments[indexAY_1]);
            BX_1 = Integer.valueOf(arguments[indexBX_1]);
            BY_1 = Integer.valueOf(arguments[indexBY_1]);
        } catch (NumberFormatException exception) {
            throw new CanvasException("Coordinates not a integer");
        }

        int firstRow = 0;
        int width = frame[firstRow].length - Const.OFFSET;
        int height = frame.length - Const.OFFSET;

        if (AX_1 > width || AY_1 > height || BX_1 > width || BY_1 > height) {
            throw new CanvasException("Coordinates of rectangle cannot pass the size of the frame");
        }

        if (AX_1 == BX_1 || AY_1 == BY_1) {
            throw new CanvasException("Points can not a line");
        }

        int AX_2 = BX_1;
        int AY_2 = AY_1;
        int BX_2 = AX_1;
        int BY_2 = BY_1;

        String[][] canvas = drawLine(frame, AX_1, AY_1, AX_2, AY_2);
        canvas = drawLine(canvas, BX_2, BY_2, BX_1, BY_1);
        canvas = drawLine(canvas, AX_1, AY_1, BX_2, BY_2);
        canvas = drawLine(canvas, AX_2, AY_2, BX_1, BY_1);

        return canvas;
    }
}
