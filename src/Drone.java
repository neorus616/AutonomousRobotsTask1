import java.awt.Point;
import java.util.Vector;

public class Drone {
    public static final double MAX_ACC = 2;  // meter / sec^2
    public static final double MAX_SPEED = 3; //meter / sec
    public static final double DT = 1.0 / 50; // ms ==> 50Hz
    private Vector<Sensor> sensors;
    private double acc;
    private Gyro gyro;
    private double speed;
    public Point location;
    double x,y;

    public Drone() {
        sensors = new Vector<Sensor>();
    }

    public void init() {
        sensors.add(new Sensor(330));
        sensors.add(new Sensor(0));
        sensors.add(new Sensor(30));
        gyro = new Gyro();
        speed = 0;
        acc = 0;
        location= new Point(90,80);
    }

    public void acceleration() {
        acc = acc + 1;
        if (acc >= MAX_ACC)
            acc = MAX_ACC;
        if (speed + acc <= MAX_SPEED)
            speed = speed + acc;
        else speed = MAX_SPEED;
        
    }

    public void moveLeft() {
        gyro.setAngle(gyro.getAngle() - 2);
    }

    public void moveRight() {
        gyro.setAngle(gyro.getAngle() + 2);
    }

    public void deceleration() {
        acc = acc - 1;
        if (acc < -MAX_ACC)
            acc = -MAX_ACC;
        if (speed + acc >= -MAX_SPEED)
            speed = speed + acc;
        else speed = -MAX_SPEED;
    }
    
    public void fly() {
//    	System.out.println(gyro.getAngle());
    	 x =( Math.sin(Math.toRadians(gyro.getAngle()))*10 + location.x);
    	 y =( Math.cos(Math.toRadians(gyro.getAngle()))*10 + location.y);
    	location.setLocation(x, y);
    	
    }
    


}
