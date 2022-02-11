import org.junit.Assert;
import org.junit.Test;

public class DrawProgramTest {

    @Test
    public void testCreateANewCanvas() throws Exception {

        String[][] frameExpected = new String[][] {
                {"-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
                {"|", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|"},
                {"|", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|"},
                {"|", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|"},
                {"|", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|"},
                {"-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"}
        };

        DrawProgram drawProgram = new DrawProgram();
        String[][] frameActual = drawProgram.draw("C 20 4");

        Assert.assertEquals(frameExpected.length, frameActual.length);
        for (int i = 0; i < frameExpected.length; i++) {
            Assert.assertArrayEquals(frameExpected[i], frameActual[i]);
        }
    }

    @Test
    public void testCreateANewCanvas_Cmd_C_20_2() throws Exception {

        String[][] frameExpected = new String[][] {
                {"-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
                {"|", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|"},
                {"|", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|"},
                {"-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"}
        };

        DrawProgram drawProgram = new DrawProgram();
        String[][] frameActual = drawProgram.draw("C 20 2");

        Assert.assertEquals(frameExpected.length, frameActual.length);
        for (int i = 0; i < frameExpected.length; i++) {
            Assert.assertArrayEquals(frameExpected[i], frameActual[i]);
        }
    }

    @Test(expected = Exception.class)
    public void testCreateANewCanvas_WrongCmd_X_20_2() throws Exception {

        DrawProgram drawProgram = new DrawProgram();
        String[][] frameActual = drawProgram.draw("X 20 2");
    }
}
