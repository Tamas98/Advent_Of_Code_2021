package advent.of.code.second.domain;

/**
 * TODO docme.
 */
public class Submarine {

    private String name;
    private int positionY;
    private int positionX;
    private int aim;

    public Submarine() {
        name = "Noname";
        positionX = 0;
        positionY = 0;
        aim = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getAim() {
        return aim;
    }

    public void setAim(int aim) {
        this.aim = aim;
    }
}
