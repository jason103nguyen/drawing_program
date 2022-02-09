import java.util.Scanner;
import java.util.regex.PatternSyntaxException;

public class Utils {

    public static String enterCmd() {

        Scanner keyBoard = new Scanner(System.in);
        System.out.print("Please enter command: ");

        String cmd = keyBoard.next();
        boolean isValid = validation(cmd);

        if (isValid) {
            return cmd;
        } else {
            return null;
        }

    }

    public static boolean validation(String cmd){

        boolean result = true;
        String[] parameter = null;

        try {
            parameter = cmd.split(" ");
        } catch (PatternSyntaxException exception) {
            return false;
        }

        if (parameter.length < 1) {
            return false;
        }

        switch (parameter[0]) {
            case "C":
                if (parameter.length > 3) {
                    result = false;
                }

                if (!isNumeric(parameter[1]) || !isNumeric(parameter[2])) {
                    result = false;
                }
                break;

            case "R":
            case "L":
                if (parameter.length > 5) {
                    result = false;
                }

                if (!isNumeric(parameter[1]) || !isNumeric(parameter[2])
                        || !isNumeric(parameter[3]) || !isNumeric(parameter[4])) {
                    result = false;
                }
                break;

            case "B":
                if (parameter.length > 4) {
                    result = false;
                }

                if (!isNumeric(parameter[1]) || !isNumeric(parameter[2])) {
                    result = false;
                }
                break;

            case "Q":
                if (parameter.length > 1) {
                    result = false;
                }
                break;

            default:
                result = false;
                break;
        }

        return result;
    }

    public static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }
}
