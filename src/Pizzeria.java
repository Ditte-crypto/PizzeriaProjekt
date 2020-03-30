import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Pizzeria {
    static Menu menu;
    Ordreliste ordreliste;

    public static void showMenu(){
        try {
            ArrayList<Pizza> pizzaliste = ImportPizzasFromFile.importPizzas();
            menu = new Menu(pizzaliste);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(menu);
    }

    public static void main(String[] args) {
        showMenu();
    }
}
