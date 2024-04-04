import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.Random;

public class Rong {
    private String nimi;
    private int kohtadeArv;
    private double hind;
    private List<String> peatused;
    private String mudel;
    private List<Reisija> reisijad;
    private int[] kunalahkus;
    private double teenis;

    public Rong(String nimi ,int kohtadeArv, String mudel, double hind, List<String> peatused) {
        this.nimi = nimi;
        this.kohtadeArv = kohtadeArv;
        this.peatused = peatused;
        this.mudel = mudel;
        this.hind = hind;
        this.kunalahkus = new int[peatused.size()];
        this.teenis = teenis;
        this.reisijad = new ArrayList<>();
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    public void setKohtadeArv(int kohtadeArv) {
        this.kohtadeArv = kohtadeArv;
    }

    public void setMudel(String mudel) {
        this.mudel = mudel;
    }

    public void setPeatused(List<String> peatused) {
        this.peatused = peatused;
    }

    public void setHind(double hind) {

        this.hind = hind;
    }

    public void setTeenis(double teenis) {
        this.teenis = teenis;
    }

    public void setReisijad(List<Reisija> reisijad) {
        this.reisijad = reisijad;
    }

    public double getHind() {
        return hind;
    }

    public double getTeenis() {
        return teenis;
    }

    public List<Reisija> getReisijad() {
        return reisijad;
    }

    public String getNimi() {
        return nimi;
    }

    public int getKohtadeArv() {
        return kohtadeArv;
    }

    public List<String> getPeatused() {
        return peatused;
    }

    public int[] getKunalahkus() {
        return kunalahkus;
    }

    public String getMudel() {
        return mudel;
    }

    public void RongAlustabSoitu(List<Reisija> Tulevikureisijad, List<String> peatused){ //Siit pohimotteliselt kaivituvad koik meetodid
        NimetaPeatused(peatused);

        System.out.println("Rong: " + getNimi() + " alustab oma reisi peatusest " + peatused.get(0) +
                "ja lõppetab peatuses " + peatused.get(peatused.size()-1));

        this.reisijad = PiletiOstmineVõiKotroll(Tulevikureisijad);

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
        }

        RongOnTeel(getPeatused());
        Rongsõidab(reisijad, peatused, this.kunalahkus);
        RongiReisijadLahkusidKindlatesPeatustes(peatused, this.getKunalahkus());
        return;
    }
    public List<Reisija> PiletiOstmineVõiKotroll(List<Reisija> kliendid){ //
        List<Reisija> tulemus = new ArrayList<>(); double soodus = 2.5;
        for (Reisija klient : kliendid) {
            if (klient.KuidasMaksabKaardiga(getHind(), soodus)){
                setTeenis(getTeenis() + getHind() - soodus);
                tulemus.add(klient);
                continue;

            } else if(klient.KuidasMaksabSulas(getHind())){
                setTeenis(getTeenis() + getHind());
                tulemus.add(klient);

            }
            else {
                System.out.println(klient.getNimi() + " ei saanud piletit kätte.");
            }

        }
        return tulemus;
    }

    public void RongiReisijadLahkusidKindlatesPeatustes(List<String> peatused, int[] kunalahkus) {
        System.out.println("TEre");
        for (int i = 0; i < peatused.size(); i++) {
            System.out.println("____-");
            if (kunalahkus[i] > 0){
                System.out.println("Peatuses " + peatused.get(i) + " lahkus: " + kunalahkus[i]);
            }else return;
        }
    }


    public void Rongsõidab(List<Reisija> reisijad, List<String> peatused, int[] kunalahkus) { //Siin kaib labi erinevad peatused
        int mitureisijat = 0;
        for (int i = 1; i < peatused.size(); i++) {
            System.out.println("Rong saabus peatusesse " + peatused.get(i)); // nimetab igat peatust
            try {
                Random random = new Random();
                int randomAegSekundites = random.nextInt(10) + 1; // juhusliku arvu genereerimine
                long randomAegMillis = randomAegSekundites * 1000L; // sekundid->millisekundid
                TimeUnit.MILLISECONDS.sleep(randomAegMillis); // paneb mingiks ajaks programmi ootama
            }
            catch (InterruptedException e) { System.out.println("Midagi läks valesti!"); }
            mitureisijat = 0;
            for (int j = 0; j < reisijad.size(); j++) {          // vaatab mis reisija lahkub selles peatuses
                if (peatused.get(i).equalsIgnoreCase(reisijad.get(j).getPeatusKusmahaläheb())) { //vordleb kas reisija laheb peatuses maha v mitte
                    reisijad.get(j).LahkubRongist();
                    try {
                        TimeUnit.MILLISECONDS.sleep(100);
                    }catch (InterruptedException e){}
                    reisijad.remove(j);
                    mitureisijat += 1;
                }
            }
            kunalahkus[i] = mitureisijat; // lisab mitu reisijat yhes peatuses laks maha
        }
        RongOnLõppPeatuses();  // teatab et loppenud
    }



    public void RongOnLõppPeatuses() {  // lihtsalt mainib et on joudnud lopp-peatusesse
        System.out.println("Rong " + this.getNimi() + " on jõudnud lõpppeatusesse "+this.peatused.getLast() + ".");
    }




    public void RongOnTeel(List<String> peatused){ //lihtsalt mainib et rong alustas soitu
        System.out.println("Rong on lahkunud " + this.peatused.getFirst() + " peatusest ja alunud oma reisiga");
    }



    public void NimetaPeatused(List<String> peatused){ // nimetab peatused
        System.out.println("Peatused reisil: ");
        for (int i = 1; i < peatused.size(); i++) {
            System.out.print(peatused.get(i) + " //// ");
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
            }
        }

    }


}
