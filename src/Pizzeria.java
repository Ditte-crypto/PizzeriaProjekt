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
        for (Ordre o : ordreliste.getOrdreliste()) {
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
        showInterface();
    }

    public void showNextOrder() {

    }

    public void updateOrder(int id) {

    }

    public void editOrder(int id) {
        Scanner in = new Scanner(System.in);
        String choice = "";
        while (!choice.equals("Q")) {
            System.out.println("Her kan du redigere i din ordre med id " + id + ". Tast pizzanummeret for at vælge en pizza.\ Tryk Q for at forlade redigerOrdreProgrammet");


        }
    }

}

    public static void menuSettings() {
        int choice = 0;

        Scanner in = new Scanner(System.in);
        while (choice != 6) {
            choice = in.nextInt();
            try {
                if (choice == 1){
                    showMenu();
                    startNewOrder();
                } else if (choice == 2) {
                    listOrders();
                    showInterface();
                } else if (choice == 3) {
                    //fjern eller tilføj pizza fra ordre
                } else if (choice == 4) {
                    //vis næste ordre
                } else if (choice == 5) {
                    //updateOrder
                } else if (choice == 6) {
                    showMenu();
                }
            } catch (IllegalArgumentException e) {
                choice = 7;
            }
        }
    }

    public static void showInterface() {
        System.out.println("******* PIZZERIA ALLA ALFONSO E MARIO *******\n"+
                "1. Start ny ordre\n" +
                "2. Vis aktive ordre\n" +
                "3. Fjern eller tilføj Pizza fra ordre\n" +
                "4. Vis næste ordre\n" +
                "5. Opdater ordre status\n" +
                "6. Vis menu\n" +
                "7. Exit");
    }

    public static void main(String[] args) {
        showInterface();
        menuSettings();
    }
}

