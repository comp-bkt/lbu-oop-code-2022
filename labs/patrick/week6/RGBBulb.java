package patrick.week6;

public class RGBBulb extends Bulb {

    public static final int RED = 0;
    public static final int GREEN = 1;
    public static final int BLUE = 2;

    private int currentColour = RED;

    public RGBBulb() {

    }

    public void setCurrentColour(int colour){
        this.currentColour = colour;
    }

    public int getCurrentColour() {
        return currentColour;
    }
}
