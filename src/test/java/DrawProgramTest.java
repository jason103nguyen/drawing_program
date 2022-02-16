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

    @Test
    public void drawLine_IsAVerticalLine() throws CanvasException {

        String[][] canvasExpected = new String[][] {
                {"-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
                {"|", "x", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|"},
                {"|", "x", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|"},
                {"|", "x", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|"},
                {"|", "x", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|"},
                {"-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"}
        };

        DrawProgram drawProgram = new DrawProgram();
        String[][] canvas = drawProgram.createFrame("C 20 4");
        canvas = drawProgram.drawLine(canvas, "L 1 1 1 4");

        Assert.assertEquals(canvasExpected.length, canvas.length);
        for (int i = 0; i < canvasExpected.length; i++) {
            Assert.assertArrayEquals(canvasExpected[i], canvas[i]);
        }

    }

    @Test
    public void drawLine_NotAStraightLine() {

        String expectedMsg = "Not a straight line";
        String actualMsg = "";
        try {
            DrawProgram drawProgram = new DrawProgram();
            String[][] canvas = drawProgram.createFrame("C 20 4");
            canvas = drawProgram.drawLine(canvas, "L 1 1 3 2");
        } catch (CanvasException exception){
            actualMsg = exception.getMessage();
        }

        Assert.assertEquals(expectedMsg, actualMsg);

    }

    @Test
    public void drawRectangle() throws CanvasException {

        String[][] canvasExpected = new String[][] {
                {"-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
                {"|", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "x", "x", "x", "x", "x", " ", " ", "|"},
                {"|", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "x", " ", " ", " ", "x", " ", " ", "|"},
                {"|", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "x", "x", "x", "x", "x", " ", " ", "|"},
                {"|", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|"},
                {"-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"}
        };

        DrawProgram drawProgram = new DrawProgram();
        String[][] canvas = drawProgram.createFrame("C 20 4");
        canvas = drawProgram.drawRectangle(canvas, "R 14 1 18 3");

        Assert.assertEquals(canvasExpected.length, canvas.length);
        for (int i = 0; i < canvasExpected.length; i++) {
            Assert.assertArrayEquals(canvasExpected[i], canvas[i]);
        }

    }

    @Test
    public void drawRectangle_HaveWidthIs6() throws CanvasException {

        String[][] canvasExpected = new String[][] {
                {"-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
                {"|", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "x", "x", "x", "x", "x", "x", " ", " ", "|"},
                {"|", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "x", " ", " ", " ", " ", "x", " ", " ", "|"},
                {"|", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "x", "x", "x", "x", "x", "x", " ", " ", "|"},
                {"|", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|"},
                {"-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"}
        };

        DrawProgram drawProgram = new DrawProgram();
        String[][] canvas = drawProgram.createFrame("C 20 4");
        canvas = drawProgram.drawRectangle(canvas, "R 13 1 18 3");

        Assert.assertEquals(canvasExpected.length, canvas.length);
        for (int i = 0; i < canvasExpected.length; i++) {
            Assert.assertArrayEquals(canvasExpected[i], canvas[i]);
        }

    }

    @Test
    public void drawRectangle_WrongCmd() {

        String expectedMsg = "Cmd must be R";
        String actualMsg = "";

        try {
            DrawProgram drawProgram = new DrawProgram();
            String[][] canvas = drawProgram.createFrame("C 20 4");
            canvas = drawProgram.drawRectangle(canvas, "X 13 1 18 3");
        } catch (CanvasException exception) {
            actualMsg = exception.getMessage();
        }

        Assert.assertEquals(expectedMsg, actualMsg);

    }

    @Test
    public void drawRectangle_WrongCmd_NotAInteger() {

        String expectedMsg = "Coordinates not a integer";
        String actualMsg = "";

        try {
            DrawProgram drawProgram = new DrawProgram();
            String[][] canvas = drawProgram.createFrame("C 20 4");
            canvas = drawProgram.drawRectangle(canvas, "R a b c d");
        } catch (CanvasException exception) {
            actualMsg = exception.getMessage();
        }

        Assert.assertEquals(expectedMsg, actualMsg);

    }

    @Test
    public void drawRectangle_WrongCmd_CoordinatesPassTheSizeOfTheFrame() {

        String expectedMsg = "Coordinates of rectangle cannot pass the size of the frame";
        String actualMsg = "";

        try {
            DrawProgram drawProgram = new DrawProgram();
            String[][] canvas = drawProgram.createFrame("C 20 4");
            canvas = drawProgram.drawRectangle(canvas, "R 14 1 30 3");
        } catch (CanvasException exception) {
            actualMsg = exception.getMessage();
        }

        Assert.assertEquals(expectedMsg, actualMsg);

    }
}
