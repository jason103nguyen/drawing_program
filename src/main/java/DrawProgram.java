public class DrawProgram {

    public String[][] draw(String cmd) {

        String[] arguments = cmd.split(" ");

        int indexArgumentOfWidth = 1;
        int indexArgumentOfHeight = 2;
        int width = Integer.valueOf(arguments[indexArgumentOfWidth]);
        int height = Integer.valueOf(arguments[indexArgumentOfHeight]);

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
