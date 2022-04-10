package models;

public class Rectangle {
    private Coordinate lowerLeft;
    private Coordinate upperRight;
    private boolean invalidRectangle;
    private String invalidDescription;

    // create and validate
    public Rectangle(int leftX, int leftY, int rightX, int rightY) {
        this.lowerLeft = new Coordinate(leftX, leftY);
        this.upperRight = new Coordinate(rightX, rightY);
        this.validate();
    }

    // can the coordinates actually represent a rectangle?
    // for example if the lower left x-axis is greater than the upper right's, that wouldn't make sense
    private void validate(){
        if (this.lowerLeft.getX() >= this.upperRight.getX()) {
            this.invalidRectangle = true;
            this.invalidDescription = "The lower left X coordinate shouldn't be greater than it's upper right X.";
        }
        else if(this.lowerLeft.getY() >= this.upperRight.getY()) {
            this.invalidRectangle = true;
            this.invalidDescription = "The lower left Y coordinate shouldn't be greater than it's upper right Y.";
        }
        else {
            this.invalidRectangle = false;
        }
    }

    // <editor-fold> Getters and setters
    public Coordinate getLowerLeft() {
        return lowerLeft;
    }

    public void setLowerLeft(Coordinate lowerLeft) {
        this.lowerLeft = lowerLeft;
    }

    public Coordinate getUpperRight() {
        return upperRight;
    }

    public void setUpperRight(Coordinate upperRight) {
        this.upperRight = upperRight;
    }

    public boolean isInvalidRectangle() {
        return invalidRectangle;
    }

    public void setInvalidRectangle(boolean invalidRectangle) {
        this.invalidRectangle = invalidRectangle;
    }

    public String getInvalidDescription() {
        return invalidDescription;
    }

    public void setInvalidDescription(String invalidDescription) {
        this.invalidDescription = invalidDescription;
    }

    // </editor-fold>


    @Override
    public String toString() {
        return "Rectangle{" +
                "lowerLeft=" + lowerLeft +
                ", upperRight=" + upperRight +
                ", invalidRectangle=" + invalidRectangle +
                ", invalidDescription=" + invalidDescription +
                '}';
    }
}