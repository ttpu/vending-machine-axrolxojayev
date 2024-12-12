import java.util.ArrayList;

public class VendingMachine {
    ArrayList<Beverage> beverages = new ArrayList<Beverage>();
    ArrayList<Card> cards = new ArrayList<Card>();
    ArrayList<Column> columns = new ArrayList<Column>();

    public VendingMachine() {

    }

    public void addBeverage(String name, double price) {
        beverages.add(new Beverage(name, price));
    }

    public double getPrice(String beverageName) {
        for (Beverage beverage : beverages) {
            if (beverage.getName().equals(beverageName)) {
                return beverage.getPrice();
            }
        }
        return -1.0;
    }

    public void rechargeCard(int cardId, double credit) {
        boolean isCardAvailable = false;
        for (Card card : cards) {
            if (card.getId() == cardId) {
                isCardAvailable = true;
                card.addCredit(credit);
            }
        }
        if (!isCardAvailable) {
            cards.add(new Card(cardId, credit));
        }
    }

    public double getCredit(int cardId) {
        for (Card card : cards) {
            if (card.getId() == cardId) {
                return card.getCredit();
            }
        }
        return -1.0;
    }

    public void refillColumn(int column, String beverageName, int cans) {
        boolean isColumnAvailable = false;
        for (Column col : columns) {
            if (col.getColumn() == column) {
                isColumnAvailable = true;
                if (col.getBeverageName().equals(beverageName)) {
                    col.refill(beverageName, cans);
                } else {
                    System.out.println("Column already contains a different beverage");
                }
            }
        }
        if (!isColumnAvailable) {
            columns.add(new Column(column, beverageName, cans));
        }
    }


    public int availableCans(String beverageName) {
        int totalCans = 0;
        for (Column column : columns) {
            if (column.getBeverageName().equals(beverageName)) {
                totalCans += column.getCans();
            }
        }
        return totalCans;
    }

    public int sell(String beverageName, int cardId) {
        for (Column column : columns) {
            if (column.getBeverageName().equals(beverageName)) {
                for (Card card : cards) {
                    if (card.getId() == cardId) {
                        double price = getPrice(beverageName);
                        if (price == 1.0) {
                            System.out.println("Beverage not available");
                            return 0;
                        }
                        if (card.getCredit() >= price) {
                            card.addCredit(-price);
                            column.sell();
                            return 1;
                        } else {
                            System.out.println("Insufficient credit");
                            return 0;
                        }
                    }
                }
            }
        }
        return 0;
    }
}
