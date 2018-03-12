public class CableCar extends Thread {

    private static CableCar instance;
    private CableCar(){}
    public static synchronized CableCar getInstance(){
        if(instance == null){
            instance = new CableCar();
        }
        return instance;
    }

    private Group group = null;
    //true: valley false: terminus
    private static boolean location = true;

    //empty cablecar go down to pick up group
    public void descends() {
        System.out.println("cable car descends");
        setLocation(true);
    }

    //empty cablecar go up to pick up group
    public void ascends() {
        System.out.println("cable car ascends");
        setLocation(false);
    }

    public synchronized void depart() {
        if (CableCar.location && !isEmpty()) {
            System.out.println("[" + this.group.getId() + "]" + "departs");
            setGroup(null);
            setLocation(true);
            notify();
        }
    }


    public synchronized void arrive(Group group) {
        while (!location || !isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        setGroup(group);
        setLocation(false);
        System.out.println("[" + this.group.getId() + "] " + "enters cable car to go up");
    }

    public void pickup(Group group) {
        this.group = group;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public boolean Location() {
        return location;
    }

    public void setLocation(boolean location) {
        this.location = location;
    }

    public boolean isEmpty() {
        if (this.group == null) {
            return true;
        } else {
            return false;
        }
    }

    public Group leaveCableCar() {
        Group temp = group;
        System.out.println("[" + group.getId() + "]" + " leaves the cable car");
        this.group = null;
        location = false;
        return temp;
    }

    public void enterCableCar(Group group) {
        this.group = group;
        location = false;
        System.out.println("[" + group.getId() + "]" + " enters cable car to go down");
    }


}
