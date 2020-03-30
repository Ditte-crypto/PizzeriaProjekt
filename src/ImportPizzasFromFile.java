import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ImportPizzasFromFile {


    public static void importPizzas() throws FileNotFoundException {

        File textFile = new File("data/pizzaliste.csv");

        Pizza tempPizza = null;

        Scanner in = new Scanner(textFile);

        while (in.hasNextLine()) {

            String line = in.nextLine();
            String [] lineArr = line.split(";");
            Pizza nyPizza = new Pizza(Integer.parseInt(lineArr[0]), lineArr[1], Integer.parseInt(lineArr[2]), Integer.parseInt(lineArr[3]));


        }
        in.close();


    }
}
/* public class ImporterBibliotekerFraFil {
    public static void importerBiblioteker(String filnavn) throws FileNotFoundException {
        File fil = new File(filnavn);
        Scanner in = new Scanner(fil);
        String[] lineArr = null;
        while (in.hasNextLine()){
            //scan en linje
            String line = in.nextLine();
            //del linjen op i et array
            lineArr=line.split(",");
            //send array med til et biblioteksobjekt og lav et nyt bibliotek.
            Bibliotek nytBiblo = new Bibliotek(lineArr);
            System.out.println(nytBiblo);
        }
    }
}
*/
