public class DrawProgram {

    public String[][] draw(String cmd) {

        String[] parameter = cmd.split(" ");
        int width = Integer.valueOf(parameter[1]);
        int height = Integer.valueOf(parameter[2]);

        String[][] frame = new String[height + 2][width + 2];
        int rowFrame = frame.length;
        int colFrame = frame[0].length;

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
