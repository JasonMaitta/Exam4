
import java.util.Random;


class Die {
    private int numSides;
    private int value;

    public Die() {
        numSides = 6;
        value = 1;
    }

    public Die(int numSides) {
        this.numSides = numSides;
        this.value = 1;
    }

    public int getNumSides() {
        return numSides;
    }

    public void setNumSides(int numSides) {
        this.numSides = numSides;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Number of sides: " + numSides + ", Value: " + value;
    }

    public void roll() {
        Random rand = new Random();
        value = rand.nextInt(numSides) + 1;
    }
}