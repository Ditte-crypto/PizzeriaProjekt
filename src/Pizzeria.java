import java.io.FileNotFoundException;
import java.util.ArrayList;
/*+ showMenu(); void

+ listOrders(); void

+ startNewOrder(); int

+ showNextOrder(); void

+ updateOrder(int); void

 */

public class Pizzeria {
    static Menu menu;
    Ordreliste ordreliste;

    public static void showMenu() {
        try {
            ArrayList<Pizza> pizzaliste = ImportPizzasFromFile.importPizzas();
            menu = new Menu(pizzaliste);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(menu);
    }

    public static void listOrders() {
        //show current orders
    }

    public static void startNewOrder(int pizzanr) {
        /* 3 Hawaipizzaer
        1 Vesuvio
         */
        ArrayList<Pizza> pizzaliste = Menu.getPizzaliste();
        Pizza pizza = pizzaliste.get(pizzanr - 1);
        Ordre newordre = new Ordre(Ordre.Status.venter);


            newordre.addPizza(pizza);

    }

    public void showNextOrder(){

    }

    public void updateOrder(int id){

    }

    public static void main(String[] args) {
        showMenu();
    }
}

