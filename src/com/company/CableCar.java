public class CableCar extends Thread{

    private Group group;

    //true: valley false: terminus
    private static boolean location = true;

    //empty cablecar go down to pick up group
    public void descends() {
        System.out.println("cable car descends");
        location = true;
    }

    //empty cablecar go up to pick up group
    public void ascends() {

        System.out.println("cable car ascends");
        location = false;
    }

    public void depart() {
        System.out.println("[" + this.group.getId() + "]" + "departs");
    }

    public void arrive(Group group) {
        this.group = group;
        System.out.println("[" + this.group.getId() + "] " + "enters cable car to go up");
    }

    public void pickup(Group group){
        this.group = group;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public static boolean Location() {
        return location;
    }

    public static void setLocation(boolean location) {
        CableCar.location = location;
    }

    public boolean isEmpty(){
        if(this.group == null){
            return true;
        }
        else{
            return false;
        }
    }

}
