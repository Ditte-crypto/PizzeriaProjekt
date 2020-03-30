import java.io.FileNotFoundException;

public class Pizzeria {
    Menu menu;
    Ordreliste ordreliste;

    public void showMenu(Menu menu){
        Pizza pizza = null;
        try {
            pizza = ImportPizzasFromFile.importPizzas();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        menu = Pizza.lavPizzaListe(pizza);
    }

    public static void main(String[] args) {
        System.out.println(menu);
    }
}
