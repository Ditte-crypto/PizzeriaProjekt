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
public static Menu lavPizzaListe(Pizza p){
        ArrayList<Pizza> pizzaliste = new ArrayList<>();
        Menu menu = new Menu(pizzaliste);
        return menu;
}

    @Override
    public String toString() {
        return "Pizza{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pris=" + pris +
                ", tilberedningstid=" + tilberedningstid +
                '}';
    }
}
