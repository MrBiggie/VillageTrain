public class Operator extends Thread {

    private CableCar cableCar;

    public Operator(CableCar cableCar) {
        this.cableCar = cableCar;
    }

    public void inspect(CableCar cableCar) {
        if (cableCar.isEmpty() && cableCar.Location()) {
            cableCar.ascends();
        }
        if (cableCar.isEmpty() && (!cableCar.Location())) {
            cableCar.descends();
        }
    }


}
