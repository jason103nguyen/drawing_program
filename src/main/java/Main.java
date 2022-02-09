public class Main {
    public static void main(String[] args) {

        System.out.println("WELCOME TO CANVAS PROGRAM");
        String cmd = Utils.enterCmd();

        DrawProgram drawProgram = new DrawProgram();
        drawProgram.draw(cmd);

    }
}