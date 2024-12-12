public class Card {
    private int id;
    private double credit;
    public Card(int id, double credit) {
        this.id = id;
        this.credit = credit;
    }
    public int getId() {
        return this.id;
    }
    public double getCredit() {
        return this.credit;
    }
    public void addCredit(double credit) {
        this.credit += credit;
    }
}
