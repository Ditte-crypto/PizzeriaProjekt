import java.util.Scanner;

public class UI {

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

    public static void menuSettings() {
        int choice = 0;

        Scanner in = new Scanner(System.in);
        while (choice != 7) {
            choice = in.nextInt();
            try {
                if (choice == 1){
                    Pizzeria.showMenu();
                    Pizzeria.startNewOrder();
                } else if (choice == 2) {
                    Pizzeria.listOrders();
                    showInterface();
                } else if (choice == 3) {
                    Pizzeria.editOrder();
                    //fjern eller tilføj pizza fra ordre
                } else if (choice == 4) {
                    //vis næste ordre
                } else if (choice == 5) {
                    Pizzeria.updateOrder();
                } else if (choice == 6) {
                    Pizzeria.showMenu();
                }
            } catch (IllegalArgumentException e) {
                choice = 7;
            }
        }
    }
}
