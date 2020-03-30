import java.util.ArrayList;

public class Pizza {
int id;
String name;
int pris;
int tilberedningstid;

    public Pizza(int id, String name, int pris, int tilberedningstid) {
        this.id = id;
        this.name = name;
        this.tilberedningstid = tilberedningstid;
        this.pris = pris;
    }
public static void lavPizzaListe(Pizza tempPizza){
        ArrayList<Pizza> pizzaliste = new ArrayList<>();
        pizzaliste.add(tempPizza);
        Menu menu = new Menu(pizzaliste);
}
}
