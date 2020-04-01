import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

public class Ordre {
    static int counter = 1;
    int id;
    Status status;
    ArrayList<Pizza> pizzaer;
    Date date;
    Timestamp ts;

    public Ordre(Status status) {
        this.pizzaer = new ArrayList<Pizza>();
        this.id = counter++;
        this.status = status;
        this.date = new Date();
        this.ts = new Timestamp(date.getTime());
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

    @Override
    public String toString() {
        return "Ordre{" +
                "id=" + id +
                ", status=" + status +
                ", pizzaer=" + pizzaer +
                ", Timestamp=" + ts +
                '}';
    }

    public enum Status {
        venter, laves, faerdig, afhentet, afbestilt
    }

    public ArrayList<Pizza> getPizzaer() {
        return pizzaer;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }
}

