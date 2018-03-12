public class CableCar extends Thread {

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
        this.group = group;
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
}
