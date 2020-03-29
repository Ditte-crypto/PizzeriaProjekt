import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ImportPizzasFromFile {

    int pizzaNummer;
    String pizzaNavn;
    Time tilberedningstid;
    int pris;


    public static importPizzas() throws FileNotFoundException {

        ArrayList<Pizza> importedpizzas = new ArrayList<>();

        File textFile = new File("data/pizzaliste.csv");

        Pizza tempPizza = null;

        Scanner in = new Scanner(textFile);

        while (in.hasNextLine()) {

            String line = in.nextLine();
            String [] lineArr = line.split(";");

            try {
                String [] playerArr = Arrays.copyOfRange(lineArr, 1, 3);

                if(playerArr[0].contains("D")) {
                    importedpizzas.add(tempPizza);
                } else {
                    System.out.println("hej");
                }

            } catch (Exception e) {
                System.out.println("Error in reading file" + line);
            }

        }
        in.close();

    }

    public int getPizzaNummer() {
        return pizzaNummer;
    }

    public void setPizzaNummer(int pizzaNummer) {
        this.pizzaNummer = pizzaNummer;
    }

    public String getPizzaNavn() {
        return pizzaNavn;
    }

    public void setPizzaNavn(String pizzaNavn) {
        this.pizzaNavn = pizzaNavn;
    }

    public Time getTilberedningstid() {
        return tilberedningstid;
    }

    public void setTilberedningstid(Time tilberedningstid) {
        this.tilberedningstid = tilberedningstid;
    }

    public int getPris() {
        return pris;
    }

    public void setPris(int pris) {
        this.pris = pris;
    }
}
