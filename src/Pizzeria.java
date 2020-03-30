public class Pizzeria {
    Menu menu;
    Ordreliste ordreliste;

    public void showMenu(Menu menu){
        Pizza pizza = ImportPizzasFromFile.importPizzas();
        Pizza.lavPizzaListe(pizza);
    }
}
