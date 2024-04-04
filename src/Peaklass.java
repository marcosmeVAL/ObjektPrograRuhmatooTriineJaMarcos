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
            File fail = new File(fnr);
            Scanner scanner = new Scanner(fail);
            while (scanner.hasNextLine()) {
                String rida = scanner.nextLine();
                String[] andmed = rida.split(";");

                String nimi = andmed[0];
                String peatusKusmahaläheb = andmed[1];
                double raha = Double.parseDouble(andmed[2]);
                String makseviis = andmed[3];

                Reisija reisija = new Reisija(nimi, peatusKusmahaläheb, raha, makseviis);
                tulemus.add(reisija);
            }

        } catch (Exception e) {
            System.out.println("Midagi laks valesti");
        }
        return tulemus;
    }
}
