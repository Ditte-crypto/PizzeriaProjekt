import java.time.LocalDate;
import java.util.ArrayList;

public class Ordreliste {
    static ArrayList<Ordre> ordreliste;
    LocalDate dato;

    public Ordreliste () {
        this.ordreliste = new ArrayList<>();
        this.dato = LocalDate.now();
    }

    public static Ordre getOrderById(int id){
        Ordre retordre = null;
        for (Ordre o: ordreliste) {
            if (o.getId() == id){
                retordre = o;
            }
        }
        return retordre;
    }

    public void addOrderToList(Ordre ordre) {
        ordreliste.add(ordre);
    }

    public ArrayList<Ordre> getOrdreliste() {
        return ordreliste;
    }
}
