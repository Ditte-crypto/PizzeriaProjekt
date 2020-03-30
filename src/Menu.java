import java.util.ArrayList;

public class Menu {
    ArrayList<Pizza> pizzaliste;

    public Menu(ArrayList<Pizza> pizzaliste) {
        this.pizzaliste = pizzaliste;
    }

    @Override
    public String toString() {
        return "Menu: \n" + pizzaliste
                ;
    }
}
