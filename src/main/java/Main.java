import models.Rectangle;
import service.RectangleProcessor;

class Main {
    public static void main(String[] args) {
        // cast the str args as ints and validate
        int[] input = getInputAsInts(args);
        // input could be validated
        if(input != null) {
            // create the rectangle objects and validate they actually represent a rectangle
            Rectangle rect1 = new Rectangle(input[0], input[1], input[2], input[3]);
            if (rect1.isInvalidRectangle()) {
                System.out.println("Rectangle 1 seems invalid : " + rect1.getInvalidDescription());
                return;
            }
            Rectangle rect2 = new Rectangle(input[4], input[5], input[6], input[7]);
            if (rect2.isInvalidRectangle()) {
                System.out.println("Rectangle 2 seems invalid : " + rect2.getInvalidDescription());
                return;
            }
            String result = RectangleProcessor.assessRectangles(rect1, rect2);
            System.out.println(result);
        }
    }

    static int[] getInputAsInts(String[] args) {
        int[] input = new int[8];
        try{
            for (int i = 0; i < 8; i++) {
                input[i] = Integer.parseInt(args[i]);
            }
        }
        catch (NumberFormatException ex) {
            System.out.println("Number format exception " + ex.getMessage());
            return null;
        }
        catch (ArrayIndexOutOfBoundsException ex){
            System.out.println("Args should be 8 integers representing the 2 rectangles' coordinates.");
            return null;
        }
        return input;
    }
}