import models.Rectangle;
import org.junit.Assert;
import org.junit.Test;
import service.RectangleProcessor;

public class RectangleTests {
    // verify the object is created and values map properly
    @Test
    public void testRectangleCreation() {
        Rectangle rectangle = new Rectangle(0,1,4,5);
        Assert.assertEquals("Lower left X maps", 0, rectangle.getLowerLeft().getX());
        Assert.assertEquals("Lower left Y maps", 1, rectangle.getLowerLeft().getY());
        Assert.assertEquals("Upper right X maps", 4, rectangle.getUpperRight().getX());
        Assert.assertEquals("Upper right Y maps", 5, rectangle.getUpperRight().getY());
    }

    // verify that a "non rectangle" is addressed
    @Test
    public void testNotARectangle() {
        Rectangle rectangle = new Rectangle(0,1,4,0);
        Assert.assertTrue("Non rectangle addressed", rectangle.isInvalidRectangle());
    }

    // verify "containment" of rectangles, make sure to test both cases i.e. 1 in 2 and 2 in 1
    @Test
    public void testContainment() {
        Rectangle rect1 = new Rectangle(0,0,8,6);
        Rectangle rect2 = new Rectangle(1,1,6,4);
        Assert.assertEquals(
                "Rectangle 2 containment",
                "Rectangle 2 is contained within rectangle 1.",
                RectangleProcessor.assessRectangles(rect1, rect2)
        );
        Assert.assertEquals(
                "Rectangle 1 containment",
                "Rectangle 1 is contained within rectangle 2.",
                RectangleProcessor.assessRectangles(rect2, rect1)
        );
    }

    // verify "intersecting" rectangles
    @Test
    public void testIntersection() {
        Rectangle rect1 = new Rectangle(0,0,8,8);
        Rectangle rect2 = new Rectangle(7,7,10,10);
        Assert.assertEquals(
                "Rectangle intersection",
                "The two rectangles are intersecting.",
                RectangleProcessor.assessRectangles(rect1, rect2)
        );
    }

    // verify "adjacent" rectangles
    @Test
    public void testAdjacency() {
        Rectangle rect1 = new Rectangle(0,0,8,8);
        Rectangle rect2 = new Rectangle(0,8,10,10);
        Assert.assertEquals(
                "Rectangle adjacency",
                "The two rectangles are adjacent.",
                RectangleProcessor.assessRectangles(rect1, rect2)
        );
    }


    // verify no condition met between the rectangles
    @Test
    public void testNoCondition() {
        Rectangle rect1 = new Rectangle(0,0,4,4);
        Rectangle rect2 = new Rectangle(6,6,10,10);
        Assert.assertEquals(
                "No condition met",
                "The rectangles are not overlapping, adjacent, or contained.",
                RectangleProcessor.assessRectangles(rect1, rect2)
        );
    }
}
