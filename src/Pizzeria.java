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

    }

    public static void updateOrder(Ordre ordre){
        //ordre.id 1.status.laves
        ordre.setStatus(Ordre.Status.laves);
    }

    public void editOrder(int id) {
        Scanner in = new Scanner(System.in);
        String choice = "";
        while (!choice.equals("Q")) {
            choice = in.nextLine();
            System.out.println("Her kan du redigere i din ordre med id " + id + ". Tast pizzanummeret for at vælge en pizza. Tryk Q for at forlade redigerOrdreProgrammet");
            ArrayList<Pizza> tempMenu = menu.getPizzaliste();
            try {
                int pizza_id = in.nextInt();
                if (pizza_id < tempMenu.size() && pizza_id > 0) {
                    System.out.println("Du har valgt pizzaen med nummer "+pizza_id);
                    System.out.println("Tryk 1 for at slette pizzaen fra ordren, eller tryk 2 for at tilføje pizzaen til ordren.");
                    if (in.nextInt() == 1){
                        System.out.println("Pizza nr. "+pizza_id+" er blevet slettet fra ordren.\n Tryk Q for at forlade programmet");
                    }else if (in.nextInt() == 2){
                        System.out.println("Pizza nr. "+pizza_id+" er blevet tilføjet til ordren.\n Tryk Q for at forlade programmet");
                    }

                    }
                else {
                    System.out.println("Denne pizza eksisterer ikke");
                    editOrder(id);
                }
            } catch (IllegalArgumentException e) {
                choice = "Q";

        }
    }


    public static void main(String[] args) {
        UI.showInterface();
        UI.menuSettings();
    }
}

