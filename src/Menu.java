import java.util.ArrayList;

public class Menu {
    public static Object getPizzaliste;
    static ArrayList<Pizza> pizzaliste;

    public Menu(ArrayList<Pizza> pizzaliste) {
        Menu.pizzaliste = pizzaliste;
    }

    public static ArrayList<Pizza> getPizzaliste() {
        return pizzaliste;
    }

    @Override
    public String toString() {
        return "Menu: \n" + pizzaliste
                ;
    }
}
