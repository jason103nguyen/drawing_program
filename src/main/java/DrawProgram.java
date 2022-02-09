public class DrawProgram {

    private final int OFFSET = 2;
    private String[][] frame;

    public DrawProgram() {}

    public String[][] initFrame(int width, int height) {
        this.frame = new String[height + OFFSET][width + OFFSET];
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

        return this.frame;
    }

    public void printFrame(String[][] frame) {
        int rowFrame = frame.length;
        int colFrame = frame[0].length;

        for (int row = 0; row < rowFrame ; row++) {
            for (int col = 0; col < colFrame; col++) {
                System.out.print(frame[row][col]);
            }
            System.out.println();
        }

    }

    public void draw(String cmd) {

        int length = cmd.length();
        char firstChar = cmd.charAt(0);
        String[] parameter = null;

        switch (firstChar) {
            case 'C':
                System.out.println("Should create a new canvas");
                parameter = cmd.split(" ");

                int width = Integer.valueOf(parameter[1]);
                int height = Integer.valueOf(parameter[2]);

                this.frame = initFrame(width, height);
                printFrame(this.frame);
                break;

            case 'L':
                System.out.println("Should create a new line");
                parameter = cmd.split(" ");

                int x1 = Integer.valueOf(parameter[1]);
                int y1 = Integer.valueOf(parameter[2]);
                int x2 = Integer.valueOf(parameter[3]);
                int y2 = Integer.valueOf(parameter[4]);

                Line line = new Line();
                try {
                    this.frame = line.drawLine(x1, y1, x2, y2, this.frame);
                } catch (CanvasException e) {
                    e.printStackTrace();
                }
                printFrame(this.frame);
                break;

            case 'R':
                System.out.println("Should create a new rectangle");
                parameter = cmd.split(" ");

                x1 = Integer.valueOf(parameter[1]);
                y1 = Integer.valueOf(parameter[2]);
                x2 = Integer.valueOf(parameter[3]);
                y2 = Integer.valueOf(parameter[4]);

                Rectangle rectangle = new Rectangle();
                this.frame = rectangle.drawRectangle(x1, y1, x2, y2, this.frame);
                break;

            case 'B':
                System.out.println("Should fill the entire area connected");
                break;

            case 'Q':
                System.out.println("Should quit the program.");
                break;

            default:
                System.out.println("Wrong input");
                break;
        }
    }
}
