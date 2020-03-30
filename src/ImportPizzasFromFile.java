import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ImportPizzasFromFile {


    public Pizza importPizzas() throws FileNotFoundException {

        File textFile = new File("data/pizzaliste.csv");

        Pizza tempPizza = null;

        Scanner in = new Scanner(textFile);

        while (in.hasNextLine()) {

            String line = in.nextLine();
            String [] lineArr = line.split(";");

            try {
                tempPizza = new Pizza(Integer.parseInt(lineArr[0]), lineArr[1], Integer.parseInt(lineArr[2]), Integer.parseInt(lineArr[3]));

            } catch (Exception e) {
                System.out.println("Error in reading file" + line);
            }

        }
        in.close();
        return tempPizza;

    }
}
