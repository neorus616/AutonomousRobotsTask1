public class Drone {
    public static final double MAX_ACC = 2;  // meter / sec^2
    public static final double MAX_SPEED = 3; //meter / sec
    public static final double DT = 1.0 / 50; // ms ==> 50Hz
    private Sensor[] sensors;
    private double acc;
    private Gyro gyro;
    private double speed;

    public Drone() {
        sensors = new Sensor[3];
    }

    public void init() {
        sensors[0].setAngle(330);
        sensors[1].setAngle(0);
        sensors[2].setAngle(30);
        gyro = new Gyro();
        speed = 0;
        acc = 0;
    }

    public void moveForward() {
        acc = acc + 1;
        if (acc >= MAX_ACC)
            acc = MAX_ACC;
        if (speed + acc <= MAX_SPEED)
            speed = speed + acc;
        else speed = MAX_SPEED;
    }

    public void moveLeft() {
        gyro.setAngle(gyro.getAngle() - 1);
    }

    public void moveRight() {
        gyro.setAngle(gyro.getAngle() + 1);
    }

    public void moveBacward() {
        acc = acc - 1;
        if (acc < -MAX_ACC)
            acc = -MAX_ACC;
        if (speed + acc >= -MAX_SPEED)
            speed = speed + acc;
        else speed = -MAX_SPEED;
    }


}
