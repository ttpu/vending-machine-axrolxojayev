public class Column {
    private int column;
    private String beverageName;
    private int cans;

    public Column(int column, String beverageName, int cans) {
        this.column = column;
        this.beverageName = beverageName;
        this.cans = cans;
    }

    public String getBeverageName() {
        return this.beverageName;
    }

    public int getCans() {
        return this.cans;
    }

    public int getColumn() {
        return this.column;
    }

    public void refill(String beverageName, int cans) {
        this.beverageName = beverageName;
        this.cans = cans;
    }

    public void sell() {
        if (cans > 0) {
            cans--;
        }
    }
}
