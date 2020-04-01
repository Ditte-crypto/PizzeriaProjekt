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
                    System.out.println("Denne pizza existerer ikke");
                    startNewOrder();
                }
            } catch (IllegalArgumentException e) {
                choice = "Q";
            }
        }
        ordreliste.addOrderToList(newordre);
        UI.showInterface();
    }

    public static void updateOrder() {
        //TODO: Få fat i ordre id, og brug det tal til at hente ordre frem fra en liste
        Scanner in = new Scanner(System.in);
        System.out.println("Hvilken ordre vil du gerne ændre på?");
        int choice = in.nextInt();

        Ordre ordrevalg = Ordreliste.getOrderById(choice);

        choice = 0;

        System.out.println("Hvad vil du ændre din ordre til?"
                            + "\n1. " + Ordre.Status.laves +
                            "\n2. " + Ordre.Status.faerdig +
                            "\n3. " + Ordre.Status.afhentet +
                            "\n4. " + Ordre.Status.afbestilt +
                            "\n5. Exit");


        while (choice != 5) {
            choice = in.nextInt();
            try {
                if (choice == 1){
                    ordrevalg.setStatus(Ordre.Status.laves);
                } else if (choice == 2) {
                    ordrevalg.setStatus(Ordre.Status.faerdig);
                } else if (choice == 3) {
                    ordrevalg.setStatus(Ordre.Status.afhentet);
                } else if (choice == 4) {
                    ordrevalg.setStatus(Ordre.Status.afbestilt);
                }
            } catch (IllegalArgumentException e) {
                choice = 5;
            }
        }
    }

    public static void editOrder() {
        Scanner in = new Scanner(System.in);

        String choice = "";
        while (!choice.equals("Q")) {

            //System.out.println("Her kan du redigere i din ordre med id " + id + ". Tast pizzanummeret for at vælge en pizza. Tryk Q for at forlade redigerOrdreProgrammet");
            ArrayList<Pizza> tempMenu = menu.getPizzaliste();
            try {
                System.out.println("Hvilken ordre vil du gerne ændre på? Skriv ordrenummeret. Tryk Q for quit");
                choice = in.nextLine();
                Ordre ordrevalg = Ordreliste.getOrderById(Integer.parseInt(choice));

                System.out.println("Hvilken pizza skal tilføjes eller fjernes fra ordren? Tast pizza id: ");
                int pizza_id = in.nextInt();

                if (pizza_id < tempMenu.size() && pizza_id > 0) {
                    System.out.println("Du har valgt pizzaen med nummer " + pizza_id);
                    System.out.println("Tryk 1 for at slette pizzaen fra ordren, eller tryk 2 for at tilføje pizzaen til ordren.");
                    choice = in.nextLine();
                    if (choice.equals(1)) {
                        Pizza pizza = menu.getPizzaById(pizza_id);
                        ordrevalg.removePizza(pizza);
                        System.out.println("Pizza nr. " + pizza_id + " er blevet slettet fra ordren.\n Tryk Q for at forlade programmet");
                    } else if (choice.equals(2)) {
                        Pizza pizza = menu.getPizzaById(pizza_id);
                        ordrevalg.addPizza(pizza);
                        System.out.println("Pizza nr. " + pizza_id + " er blevet tilføjet til ordren.\n Tryk Q for at forlade programmet");
                    } else {
                        System.out.println("Denne pizza eksisterer ikke");
                        editOrder();
                    }
                }
            } catch (IllegalArgumentException e) {
                choice = "Q";

            }
        }
        }




        public static void main (String[]args){
            UI.showInterface();
            UI.menuSettings();
        }
    }

