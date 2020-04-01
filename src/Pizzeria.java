import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
/*+ showMenu(); void

+ listOrders(); void

+ startNewOrder(); int

+ showNextOrder(); void

+ updateOrder(int); void

 */

public class Pizzeria {
    static Menu menu;
    static Ordreliste ordreliste = new Ordreliste();

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
        for(Ordre o: ordreliste.getOrdreliste()){
            System.out.println(o);
        }
    }

    public static void startNewOrder() {

        ArrayList<Pizza> tempMenu = menu.getPizzaliste();
        Ordre newordre = new Ordre(Ordre.Status.venter);
        System.out.println("Indtast Pizzanummer, eller Q for quit \n");
        String choice = "";
        int pizza_id = 0;
        Pizza tempPizza = null;

        Scanner in = new Scanner(System.in);
        while (!choice.equals("Q")) {
            choice = in.nextLine();
            try {
                pizza_id = Integer.parseInt(choice);
                if (pizza_id < tempMenu.size() && pizza_id > 0) {
                    tempPizza = tempMenu.get(pizza_id - 1);
                    newordre.addPizza(tempPizza);
                    System.out.println(tempPizza);
                } else {
                    System.out.println("Denne pizza existere ikke");
                    startNewOrder();
                }
            } catch (IllegalArgumentException e) {
                choice = "Q";
            }
        }
        ordreliste.addOrderToList(newordre);
        UI.showInterface();
    }

    public void showNextOrder(){
        System.out.println(//tilberedningstid + timestamp);
    }

    public void updateOrder(int id){

    }


    public static void main(String[] args) {
        UI.showInterface();
        UI.menuSettings();
    }
}

