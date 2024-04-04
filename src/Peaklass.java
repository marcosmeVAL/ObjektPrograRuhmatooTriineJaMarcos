import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Peaklass {
    public static void main(String[] args) {
        String fnr = "reisijad.txt";
        List<Reisija> reisijad = LoeReisijaAndmed(fnr);

        String fnp = "peatused.txt";
        List<String> peatused = LoePeatusteAndmed(fnp);

        Rong rong1 = new Rong("TaaviKiire", 250, "Mudel3", 12.45, peatused);

        String luba = "ei";
        Scanner luger = new Scanner(System.in);
        while (true) {
            System.out.println("Kas rong võib reisi alustada (Jah/Ei): ");
            luba = luger.nextLine();
            if (luba.equalsIgnoreCase("jah")) {
                // siia midagi vaja teha, mis siis käib?
            } else if (luba.equalsIgnoreCase("ei")) {
                System.out.println("Programm lõpetatakse.");
                return; 
            } else {
                
                System.out.println("Vale sisend. Palun sisestage 'Jah' või 'Ei'.");
            }
        }
    }

    private static List<String> LoePeatusteAndmed(String fnp) {
        List<String> tulemus = new ArrayList<>();
        try {

        } catch (Exception e) {
            System.out.println("Midagi laks valesti");
        }
        return tulemus;
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
