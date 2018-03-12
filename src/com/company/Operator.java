public class Operator extends Thread {

    private CableCar cableCar;

    public Operator(CableCar cableCar) {
        this.cableCar = cableCar;
    }

    public void run(CableCar cableCar) {
        while (!isInterrupted()) {
            try {
                if (cableCar.isEmpty() && cableCar.Location()) {
                    cableCar.ascends();
                }
                sleep(Params.operateLapse());
                if (cableCar.isEmpty() && (!cableCar.Location())) {
                    cableCar.descends();
                }
                sleep(Params.operateLapse());
            }
            catch (InterruptedException e) {
                this.interrupt();
            }
        }
    }


}
