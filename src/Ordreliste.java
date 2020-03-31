import java.time.LocalDate;
import java.util.ArrayList;

public class Ordreliste {
    ArrayList<Ordre> ordreliste;
    LocalDate dato;

    public Ordreliste () {
        this.ordreliste = new ArrayList<>();
        this.dato = LocalDate.now();
    }

    public void addOrderToList(Ordre ordre) {
        ordreliste.add(ordre);
    }

    public ArrayList<Ordre> getOrdreliste() {
        return ordreliste;
    }
}
