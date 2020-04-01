import java.util.ArrayList;

public class Menu {
    public static Object getPizzaliste;
    static ArrayList<Pizza> pizzaliste;

    public Menu(ArrayList<Pizza> pizzaliste) {
        Menu.pizzaliste = pizzaliste;
    }
    public Pizza getPizzaById(int id){
        Pizza retPizza = null;
        for (Pizza p: pizzaliste){
            if (p.getId() == id){
                retPizza = p;
            }
        }
            return retPizza;
    }

    /*public static Ordre getOrderById(int id){
        Ordre retordre = null;
        for (Ordre o: ordreliste) {
            if (o.getId() == id){
                retordre = o;
            }
        }
        return retordre;
    }*/

    public ArrayList<Pizza> getPizzaliste() {
        return pizzaliste;
    }

    @Override
    public String toString() {
        return "Menu: \n" + pizzaliste
                ;
    }
}
