package service;

import models.Rectangle;

public class RectangleProcessor {
    public static String assessRectangles(Rectangle rect1, Rectangle rect2) {
        // is rectangle 2 contained in 1...
        if (isContained(rect1, rect2)) {
            return "Rectangle 2 is contained within rectangle 1.";
        }
        // ...or is rectangle 1 contained in 2?
        else if (isContained(rect2, rect1)) {
            return "Rectangle 1 is contained within rectangle 2.";
        }

        // if not do the rectangles intersect? note adjacency does not count as intersecting (below)
        else if (isIntersecting(rect1, rect2)) {
            return "The two rectangles are intersecting.";
        }

        // if no are they adjacent to each other?
        else if (isAdjacent(rect1, rect2) || isAdjacent(rect2, rect1)) {
            return "The two rectangles are adjacent.";
        }

        // if not then no condition is satisfied
        else {
            return "The rectangles are not overlapping, adjacent, or contained.";
        }
    }

    private static boolean isContained(Rectangle rect1, Rectangle rect2) {
        return rect1.getLowerLeft().getX() < rect2.getLowerLeft().getX() &&
                rect1.getUpperRight().getX() > rect2.getUpperRight().getX() &&
                rect1.getLowerLeft().getY() < rect2.getLowerLeft().getY() &&
                rect1.getUpperRight().getY() > rect2.getUpperRight().getY();
    }

    private static boolean isIntersecting(Rectangle rect1, Rectangle rect2) {
        return rect1.getLowerLeft().getX() < rect2.getUpperRight().getX() &&
                rect2.getLowerLeft().getX() < rect1.getUpperRight().getX() &&
                rect1.getLowerLeft().getY() < rect2.getUpperRight().getY() &&
                rect2.getLowerLeft().getY() < rect1.getUpperRight().getY();
    }

    private static boolean isAdjacent(Rectangle rect1, Rectangle rect2) {
        return rect1.getUpperRight().getX() == rect2.getLowerLeft().getX() ||
                rect1.getUpperRight().getY() == rect2.getLowerLeft().getY() ||
                rect1.getLowerLeft().getX() == rect2.getUpperRight().getX() ||
                rect1.getLowerLeft().getY() == rect2.getUpperRight().getY();
    }
}