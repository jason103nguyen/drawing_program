import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class TestLine {

    @Test
    public void CheckDrawLine() throws CanvasException {
        DrawProgram drawProgram = new DrawProgram();
        String[][] frameActual = drawProgram.initFrame(20, 4);
        Line line = new Line();
        frameActual = line.drawLine(1, 2, 6, 2, frameActual);

        String[][] frameExpected = new String[][] {
                {"-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
                {"|", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|"},
                {"|", "x", "x", "x", "x", "x", "x", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|"},
                {"|", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|"},
                {"|", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|"},
                {"-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"}
        };

        Assert.assertEquals(frameExpected.length, frameActual.length);
        for (int i = 0; i < frameExpected.length; i++) {
            Assert.assertArrayEquals(frameExpected[i], frameActual[i]);
        }
    }

    @Test(expected = CanvasException.class)
    public void CheckDrawLine_InvalidCoordinates() throws CanvasException {
        DrawProgram drawProgram = new DrawProgram();
        String[][] frameActual = drawProgram.initFrame(20, 4);
        Line line = new Line();
        frameActual = line.drawLine(1, 2, 25, 2, frameActual);
    }

    @Test(expected = CanvasException.class)
    public void CheckDrawLine_NotaStraightLine() throws CanvasException {
        DrawProgram drawProgram = new DrawProgram();
        String[][] frameActual = drawProgram.initFrame(20, 4);
        Line line = new Line();
        frameActual = line.drawLine(1, 1, 3, 3, frameActual);
    }

    @Test
    public void CheckDrawLine_ReverseTwoPointsTogether() throws CanvasException {
        DrawProgram drawProgram = new DrawProgram();
        String[][] frameActual = drawProgram.initFrame(20, 4);
        Line line = new Line();
        frameActual = line.drawLine(6, 2,1, 2, frameActual);

        String[][] frameExpected = new String[][] {
                {"-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
                {"|", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|"},
                {"|", "x", "x", "x", "x", "x", "x", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|"},
                {"|", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|"},
                {"|", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|"},
                {"-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"}
        };

        Assert.assertEquals(frameExpected.length, frameActual.length);
        for (int i = 0; i < frameExpected.length; i++) {
            Assert.assertArrayEquals(frameExpected[i], frameActual[i]);
        }
    }

    @Test
    public void CheckDrawLine_TwoPointsInCommon() throws CanvasException {
        DrawProgram drawProgram = new DrawProgram();
        String[][] frameActual = drawProgram.initFrame(20, 4);
        Line line = new Line();
        frameActual = line.drawLine(1, 1,1, 1, frameActual);

        String[][] frameExpected = new String[][] {
                {"-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
                {"|", "x", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|"},
                {"|", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|"},
                {"|", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|"},
                {"|", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|"},
                {"-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"}
        };

        Assert.assertEquals(frameExpected.length, frameActual.length);
        for (int i = 0; i < frameExpected.length; i++) {
            Assert.assertArrayEquals(frameExpected[i], frameActual[i]);
        }
    }
}
