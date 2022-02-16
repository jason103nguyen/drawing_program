import org.junit.Assert;
import org.junit.Test;

public class DrawProgramTest {

    @Test
    public void testCreateANewCanvas() throws CanvasException {

        String[][] frameExpected = new String[][] {
                {"-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
                {"|", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|"},
                {"|", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|"},
                {"|", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|"},
                {"|", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|"},
                {"-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"}
        };

        DrawProgram drawProgram = new DrawProgram();
        String[][] frameActual = drawProgram.createFrame("C 20 4");

        Assert.assertEquals(frameExpected.length, frameActual.length);
        for (int i = 0; i < frameExpected.length; i++) {
            Assert.assertArrayEquals(frameExpected[i], frameActual[i]);
        }
    }

    @Test
    public void testCreateANewCanvas_Cmd_C_20_2() throws CanvasException {

        String[][] frameExpected = new String[][] {
                {"-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
                {"|", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|"},
                {"|", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|"},
                {"-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"}
        };

        DrawProgram drawProgram = new DrawProgram();
        String[][] frameActual = drawProgram.createFrame("C 20 2");

        Assert.assertEquals(frameExpected.length, frameActual.length);
        for (int i = 0; i < frameExpected.length; i++) {
            Assert.assertArrayEquals(frameExpected[i], frameActual[i]);
        }
    }

    @Test(expected = CanvasException.class)
    public void testCreateANewCanvas_WrongCmd_X_20_2() throws CanvasException {

        DrawProgram drawProgram = new DrawProgram();
        String[][] frameActual = drawProgram.createFrame("X 20 2");
    }

    @Test(expected = CanvasException.class)
    public void testCreateANewCanvas_WrongSize_SmallerThanMinimumSize_C_0_0() throws CanvasException {

        DrawProgram drawProgram = new DrawProgram();
        String[][] frameActual = drawProgram.createFrame("C 0 0");
    }

    @Test(expected = CanvasException.class)
    public void testCreateANewCanvas_WrongSize_BiggerThanMaxSize_C_50_50() throws CanvasException {

        DrawProgram drawProgram = new DrawProgram();
        String[][] frameActual = drawProgram.createFrame("C 100 100");
    }

    @Test(expected = CanvasException.class)
    public void testCreateANewCanvas_WrongSize_NotAInteger_C_w_h() throws CanvasException {

        DrawProgram drawProgram = new DrawProgram();
        String[][] frameActual = drawProgram.createFrame("C w h");
    }

    @Test
    public void drawLineTest() throws CanvasException {

        String[][] canvasExpected = new String[][] {
                {"-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
                {"|", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|"},
                {"|", "x", "x", "x", "x", "x", "x", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|"},
                {"|", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|"},
                {"|", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|"},
                {"-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"}
        };

        DrawProgram drawProgram = new DrawProgram();
        String[][] canvas = drawProgram.createFrame("C 20 4");
        canvas = drawProgram.drawLine(canvas, "L 1 2 6 2");

        Assert.assertEquals(canvasExpected.length, canvas.length);
        for (int i = 0; i < canvasExpected.length; i++) {
            Assert.assertArrayEquals(canvasExpected[i], canvas[i]);
        }
    }

    @Test
    public void drawLine_WidthIs5() throws CanvasException {

        String[][] canvasExpected = new String[][] {
                {"-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
                {"|", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|"},
                {"|", " ", "x", "x", "x", "x", "x", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|"},
                {"|", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|"},
                {"|", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|"},
                {"-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"}
        };

        DrawProgram drawProgram = new DrawProgram();
        String[][] canvas = drawProgram.createFrame("C 20 4");
        canvas = drawProgram.drawLine(canvas, "L 2 2 6 2");

        Assert.assertEquals(canvasExpected.length, canvas.length);
        for (int i = 0; i < canvasExpected.length; i++) {
            Assert.assertArrayEquals(canvasExpected[i], canvas[i]);
        }
    }

    @Test
    public void drawLine_WrongCmd() {

        try {
            DrawProgram drawProgram = new DrawProgram();
            String[][] canvas = drawProgram.createFrame("C 20 4");
            canvas = drawProgram.drawLine(canvas, "X 2 2 6 2");
        }
        catch (CanvasException exception) {
            String expectedMsg = "Cmd should be is L";
            Assert.assertEquals(expectedMsg, exception.getMessage());
        }

    }

    @Test
    public void drawLine_WrongArgument_NotAInteger() {

        try {
            DrawProgram drawProgram = new DrawProgram();
            String[][] canvas = drawProgram.createFrame("C 20 4");
            canvas = drawProgram.drawLine(canvas, "L a b c d");
        }
        catch (CanvasException exception) {
            String expectedMsg = "Argument does not a integer";
            Assert.assertEquals(expectedMsg, exception.getMessage());
        }

    }

    @Test
    public void drawLine_WrongArgument_CoordinatesLessThanOrEqualZero() {

        String expectedMsg = "Coordinates cannot be less than or equal to 0";
        String actualMsg = "";

        try {
            DrawProgram drawProgram = new DrawProgram();
            String[][] canvas = drawProgram.createFrame("C 20 4");
            canvas = drawProgram.drawLine(canvas, "L 1 0 6 0");
        } catch (CanvasException exception) {
            actualMsg = exception.getMessage();
        }

        Assert.assertEquals(expectedMsg, actualMsg);

    }

    @Test
    public void drawLine_WrongArgument_CoordinatesCannotPassTheSizeOfTheFrame() {

        String expectedMsg = "Coordinates cannot pass the size of the frame";
        String actualMsg = "";

        try {
            DrawProgram drawProgram = new DrawProgram();
            String[][] canvas = drawProgram.createFrame("C 20 4");
            canvas = drawProgram.drawLine(canvas, "L 1 2 21 2");
        } catch (CanvasException exception) {
            actualMsg = exception.getMessage();
        }

        Assert.assertEquals(expectedMsg, actualMsg);

    }
}
