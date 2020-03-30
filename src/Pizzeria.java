import java.io.FileNotFoundException;

public class Pizzeria {
    static Menu menu;
    Ordreliste ordreliste;

    public static void showMenu(){
        try {
            ImportPizzasFromFile.importPizzas();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(menu);
    }

    public static void main(String[] args) {
        showMenu();
    }
}
