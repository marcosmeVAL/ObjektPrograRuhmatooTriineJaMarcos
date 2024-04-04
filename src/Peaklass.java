import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Peaklass {
    public static void main(String[] args) {
        String fnr = "reisijad.txt";
        List<Reisija> reisijad = LoeReisijaAndmed(fnr);

        String luba = "ei";
        while (luba.toLowerCase().equals("ei")) {
            Scanner luger = new Scanner(System.in);
            System.out.println("Kas rong võib reisi alustada(Jah/Ei): ");
            luba = luger.nextLine();

        }while (luba.toLowerCase().equals("jah")){

        }
    }

    private static List<Reisija> LoeReisijaAndmed(String fnr) {
        List<Reisija> tulemus = new ArrayList<>();
        try {

        } catch (Exception e) {
            System.out.println("Midagi laks valesti");
        }
        return tulemus;
    }
}
