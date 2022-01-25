import org.junit.Assert;
import org.junit.Test;

public class TestPasswordValidation {

    @Test
    public void CheckFunctionCheckLength() {
        Assert.assertEquals(true, PasswordValidation.checkLength("phuongnt"));
    }
}
