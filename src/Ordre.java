import java.util.ArrayList;

public class Ordre {
    int id;
    ArrayList<Pizza> pizzaer;
    String status;

    public Ordre(int id, String status) {
        this.id = id++;
        this.status = status;
    }

    public void addPizza(Pizza pizza) {
        pizzaer.add(pizza);
    }

    public double calculateTotal(Ordre ordre) {
        double total = 0.0;
        for (Pizza p : pizzaer){
            total = total +Pizza.pris;
        }
        return total;
    }

    public enum Status {
        venter, laves, faerdig, afhentet, afbestilt, none
    }

    private Status statusexempel = Status.none;
}

