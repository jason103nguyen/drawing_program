public class PasswordValidation {

    public static boolean checkLength(String password){

        if(password.length() > 5 && password.length() < 10){
            return true;
        } else {
            return false;
        }
    }
}
