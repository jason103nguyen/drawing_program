import org.junit.Assert;
import org.junit.Test;

public class DrawProgramTest {

    @Test
    void testCreateANewCanvas() {

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
}
