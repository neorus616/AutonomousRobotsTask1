public class Drone {
    public Sensor[] sensors = new Sensor[3];
    public double acc;
    public Gyro gyro;
    public double speed;

    public void init() {
        sensors[0].setAngle(330);
        sensors[1].setAngle(0);
        sensors[2].setAngle(30);
        gyro = new Gyro();
        speed = 0;
        acc = 0;
    }

    public void moveForward(int x) {
        acc = acc + 1;
        if (speed + acc <= 3)
            speed = speed + acc;
        else speed = 3;
    }



}
