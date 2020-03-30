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

    }

    public double calculateTotal(Ordre ordre) {
        double total = 0.0;

        return total;
    }

    public void setStatus(String str) {

    }
}

