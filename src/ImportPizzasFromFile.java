import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ImportPizzasFromFile {

    public static ArrayList<Pizza> importTeams() throws FileNotFoundException {

        ArrayList<Pizza> importedteams = new ArrayList<>();

        File textFile = new File("data/pizzafile.csv");

        Pizza tempPizza = null;

        Scanner in = new Scanner(textFile);

        while (in.hasNextLine()) {

            String line = in.nextLine();
            String [] lineArr = line.split(",");

            try {
                String [] playerArr = Arrays.copyOfRange(lineArr, 1, 2);

                if(playerArr[0].contains("D")) {
                    importedteams.add(tempPizza);
                } else {
                    System.out.println("hej");
                }

            } catch (Exception e) {
                System.out.println("Error in reading file" + line);
            }

        }
        in.close();
        return importedteams;

    }
}
