package tutorials.tutorial_3;

import tutorials.tutorial_12.*;

/**
 * @overview A test application for vehicles.
 * 
 * @author dmle
 */
public class VehicleApp {

    public static void main(String[] args) {
        // create objects
        Vehicle v1 = new Bus("b1", 3.0, 3.0, 10.0, 1, 1, "4C1784");
        Vehicle v2 = new Car("c1", 1.5, 1.5, 2.5, 1, 1, "5C894");
        // use objects
//        v1.setRegisterationNumber("asd2sa65d1ss51");
//        v2.setRegisterationNumber("asd2sa65d1ss51");
        System.out.println("Vehicle " + v1.getName()
                + ", weight: " + v1.calcTotalWeight());
        System.out.println("Vehicle " + v2.getName()
                + ", weight: " + v2.calcTotalWeight());
    }
}
