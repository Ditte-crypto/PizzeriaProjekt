import java.io.FileNotFoundException;

public class Pizzeria {
    static Menu menu;
    Ordreliste ordreliste;

    public static void showMenu(){
        Pizza pizza = null;
        try {
            pizza = ImportPizzasFromFile.importPizzas();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        menu = Pizza.lavPizzaListe(pizza);
        System.out.println(menu);
    }

    public static void main(String[] args) {
        showMenu();
    }
}
