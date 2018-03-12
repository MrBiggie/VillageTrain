public class Village {

    private Group group;
    private int index;


    public Village(int i) {
        this.index = i;
    }

    public boolean isEmpty() {
        if (this.group == null) {
            return true;
        } else {
            return false;
        }
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public int getIndex() {
        return index;
    }

    public synchronized void leave() {
        if (this.group != null) {
            System.out.println("[" + group.getId() + "] leaves village " + index);
            this.group = null;
            notify();
        } else {
            System.out.println("no group at village " + index);
        }

    }

    public synchronized void enter(Group group) {
        while (this.group != null) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
            this.group = group;
            System.out.println("[" + group.getId() + "] enters village " + index);

        }
    }

}
