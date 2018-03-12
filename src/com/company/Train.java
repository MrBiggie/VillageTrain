public class Train extends Thread {

    private Group group;
    private CableCar cableCar = null;
    private Village currentLocation;
    private Village targetLocation;

    public Train(Village village1, Village village2) {
        this.group = village1.getGroup();
        this.currentLocation = village1;
        this.currentLocation = village2;
    }

    public Train(Village lastVillage, CableCar cableCar) {
        this.group = lastVillage.getGroup();
        this.currentLocation = lastVillage;
        this.targetLocation = null;
    }

    public Train(CableCar cableCar, Village firstVillage) {
        this.group = cableCar.getGroup();
        this.currentLocation = null;
        this.targetLocation = firstVillage;
    }

    public void run() {
        while (!isInterrupted() && group != null) {
            System.out.println("group in");
            try {
                if (currentLocation != null && targetLocation != null) {
                    currentLocation.leave();
                    targetLocation.enter(group);
                    group = null;
                }
                if (currentLocation == null && targetLocation != null) {
                    targetLocation.enter(group);
                    group = null;
                }
                if (currentLocation != null && targetLocation == null) {
                    currentLocation.leave();
                    group = null;
                }
                sleep(Params.JOURNEY_TIME);
            } catch (InterruptedException e) {
                this.interrupt();
            }
        }

    }
}