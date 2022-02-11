public class DrawProgram {

    public String[][] draw(String cmd) throws CanvasException {

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
                    frame[row][col] = "-";
                } else if (col == 0 || col == colFrame - 1) {
                    frame[row][col] = "|";
                } else {
                    frame[row][col] = " ";
                }
            }
        }

        return frame;
    }
}