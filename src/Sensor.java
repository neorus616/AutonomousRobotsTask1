import java.awt.*;

public class Sensor {
    private int angle;

    public Sensor(int angle) {
        this.angle = angle;
    }

    public int getAngle() {
        return angle;
    }

    public void setAngle(int angle) {
        this.angle = angle;
    }

    public double distance(Point loc, int angle) {
        //tan(this.angle + angle)*loc.x + n = loc.y
        int y = 3, d;
        for (int i = 0; i < 30; i++) {
            y = (int) (Math.tan(Math.toRadians(this.angle + angle)) * (loc.x - i) + loc.y);
            d = Structure.readMap(i, y);
            if (d == 0)
                return Math.sqrt((Math.pow(loc.x - i, 2) + Math.pow(loc.y - y, 2)));
        }
        return 3;
    }
}
