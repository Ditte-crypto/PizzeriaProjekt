import java.util.ArrayList;

public class Ordre {
    static int counter = 0;
    int id;
    Status status;
    ArrayList<Pizza> pizzaer;

    public Ordre(Status status) {
        this.pizzaer = new ArrayList<Pizza>();
        this.id = counter++;
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

    public ArrayList<Pizza> getPizzaer() {
        return pizzaer;
    }
}

