import java.util.ArrayList;

public class Pizza {
int id;
String name;
static int pris;
int tilberedningstid;

    public Pizza(int id, String name, int pris, int tilberedningstid) {
        this.id = id;
        this.name = name;
        this.tilberedningstid = tilberedningstid;
        this.pris = pris;
    }


    @Override
    public String toString() {
        return  "Nummer: " + id +
                ", Navn: " + name +
                ", Pris: " + pris +
                ", Tilberedningstid: " + tilberedningstid +
                "\n";
    }
}
