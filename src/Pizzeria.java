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
        Pizza.lavPizzaListe(pizza);
    }
}
