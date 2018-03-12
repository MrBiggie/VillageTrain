public class Operator extends Thread {

    private CableCar cableCar;

    public Operator(CableCar cableCar) {
        this.cableCar = cableCar;
    }

    public void run() {
        while (!isInterrupted()) {
            try {
                if (CableCar.getInstance().isEmpty() && CableCar.getInstance().Location()) {
                    CableCar.getInstance().ascends();
                }
                sleep(Params.operateLapse());
                if (CableCar.getInstance().isEmpty() && (!CableCar.getInstance().Location())) {
                    CableCar.getInstance().descends();
                }
                sleep(Params.operateLapse());
            }
            catch (InterruptedException e) {
                this.interrupt();
            }
        }
    }


}
