import java.awt.*;

public class Sensor {
    private int angle;
    
    public Sensor() {
        this.angle = 0;
    }
    
    public Sensor(int angle) {
        this.angle = angle;
    }

    public int getAngle() {
        return angle;
    }

    public void setAngle(int angle) {
        this.angle = angle;
    }

    /**
     * @param loc   current location
     * @param angle angle of the drone
     * @return distance from current location, to the wall
     */
    public double distance(Point loc, int angle) {
        //tan(this.angle + angle)*loc.x + n = loc.y
        int y = 3, d;
        for (int i = 0; i < 30; i++) {
            y = (int) (Math.tan(Math.toRadians(this.angle + angle)) * (loc.x - i) + loc.y);
            d = Structure.readMap(i, y); // need to refactor to be used by MyGui
            if (d == 0) {
                return Math.sqrt((Math.pow(loc.x - i, 2) + Math.pow(loc.y - y, 2))); //use this point to draw line from the drone to the wall\void
            }
        }
        return 3;
    }

}
