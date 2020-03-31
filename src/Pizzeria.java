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
        System.out.println(Ordre.getPizzaer());
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
                }
            } catch (IllegalArgumentException e) {
                choice = "Q";
            }
        }
        ordreliste.addOrdreToList(newordre);
    }

    public void showNextOrder(){

    }

    public void updateOrder(int id){

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("******* PIZZERIA ALLA ALFONSO E MARIO *******\n"+
                            "1. Start ny ordre\n" +
                            "2. Vis Pizza ordre\n" +
                            "3. Vis næste ordre\n" +
                            "4. Opdater ordre\n" +
                            "5. Vis menu\n" +
                            "6. Exit");

        int choice = in.nextInt();

        if (choice == 1){
            showMenu();
            startNewOrder();
        } else if (choice == 2) {
            listOrders();
        } else if (choice == 3) {
            //showNextOrder
        } else if (choice == 4) {
            //updateOrder
        } else if (choice == 5) {
            showMenu();
        }
    }
}

