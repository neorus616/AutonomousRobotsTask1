import java.awt.*;
import java.awt.geom.Point2D;

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

    public int distance(Point loc, int angle){
        //tan(this.angle + angle)*loc.x + n = loc.y
        double x = Math.tan(Math.toRadians(this.angle + angle))*loc.x;
        double y = Math.tan(Math.toRadians(this.angle + angle))*loc.x + loc.y;


        return Structure.readMap(loc.x, loc.y);
    }
}
