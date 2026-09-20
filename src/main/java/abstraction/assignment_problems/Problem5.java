abstract class P5_Drone {
    public abstract String fly();
}

interface P5_Trackable {
    String getLocation();
}

class P5_DeliveryDrone extends P5_Drone implements P5_Trackable {
    private String id;

    public P5_DeliveryDrone(String id) {
        this.id = id;
    }

    @Override
    public String fly() {
        return "Delivery drone " + id + " flying";
    }

    @Override
    public String getLocation() {
        return id + " at Sector 4";
    }
}

class P5_ScoutDrone extends P5_Drone {
    private String id;

    public P5_ScoutDrone(String id) {
        this.id = id;
    }

    @Override
    public String fly() {
        return "Scout drone " + id + " flying";
    }
}

class P5_GroundRobot implements P5_Trackable {
    private String id;

    public P5_GroundRobot(String id) {
        this.id = id;
    }

    @Override
    public String getLocation() {
        return id + " at Sector 4";
    }
}

public class Problem5 {
    public static String getLocationIfTrackable(Object o) {
        if (o instanceof P5_Trackable) {
            return ((P5_Trackable) o).getLocation();
        } else {
            return "Tracking not available";
        }
    }

    public static void main(String[] args) {
        P5_DeliveryDrone d = new P5_DeliveryDrone("DR-1");
        System.out.println(getLocationIfTrackable(d));

        P5_ScoutDrone s = new P5_ScoutDrone("SC-1");
        System.out.println(getLocationIfTrackable(s));

        P5_GroundRobot g = new P5_GroundRobot("GR-1");
        System.out.println(getLocationIfTrackable(g));
    }
}