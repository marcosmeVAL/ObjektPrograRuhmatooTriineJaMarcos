import java.util.List;
import java.util.concurrent.TimeUnit;

public class Rong {
    private String nimi;
    private int kohtadeArv;
    private double hind;
    private List<String> peatused;
    private String mudel;
    private List<Reisija> reisijad;
    private int[] kunalahkus;

    public Rong(String nimi ,int kohtadeArv, String mudel, double hind, List<String> peatused) {
        this.nimi = nimi;
        this.kohtadeArv = kohtadeArv;
        this.peatused = peatused;
        this.mudel = mudel;
        this.hind = hind;
        this.kunalahkus = new int[peatused.size()];
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

    public void setReisijad(List<Reisija> reisijad) {
        this.reisijad = reisijad;
    }

    public double getHind() {
        return hind;
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

    public void RongAlustabSoitu(List<Reisija> Tulevikureisijad, List<String> peatused){
        NimetaPeatused(peatused);
        this.reisijad = PiletiOstmineVõiKotroll(Tulevikureisijad);

        System.out.println("Rong: " + getNimi() + " alustab oma reisi peatusest " + peatused.getFirst() +
                "ja lõppetab peatuses " + peatused.getLast());
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
        }
        RongOnTeel(getPeatused());
        Rongsõidab(reisijad, peatused, this.kunalahkus);
        RongiReisijadLahkusid(peatused, this.getKunalahkus());
        return;
    }
    public List<Reisija> PiletiOstmineVõiKotroll(List<Reisija> kliendid){
        for (Reisija klient : kliendid) {
            if (klient.KuidasMaksab(this.getHind())) {
                reisijad.add(klient);
            }else {
                System.out.println(klient.getNimi() + " ei olnud võimalik piletit osta.");
                continue;
            }
        }

        return reisijad;
    }

    public void RongiReisijadLahkusid(List<String> peatused, int[] kunalahkus) {
        for (int i = 0; i < peatused.size(); i++) {
            if (kunalahkus[i] == 0);
        }
    }

    public void Rongsõidab(List<Reisija> reisijad, List<String> peatused, int[] kunalahkus) {
        for (int i = 1; i < peatused.size(); i++) {
            System.out.println("Rong saabus peatusesse " + peatused.get(i));
            try {
                TimeUnit.MILLISECONDS.sleep(1000);
            } catch (InterruptedException e) {
            }
            int mitureisijat = 0;
            for (int j = 0; j < reisijad.size(); j++) {
                if (peatused.get(i).equals(reisijad.get(j))) {
                    mitureisijat += 1;
                }
                reisijad.get(j).LahkubRongist(peatused.get(i));
            }kunalahkus[i] = mitureisijat;
        }
        RongOnLõppPeatuses();
    }

    public void RongOnLõppPeatuses() {
        System.out.println("Rong " + this.getNimi() + " on jõudnud lõpppeatusesse "+this.peatused.getLast() + ".");
    }

    public void RongOnTeel(List<String> peatused){
        System.out.println("Rong on lahkunud " + this.peatused.getFirst() + " peatusest ja alunud oma reisiga");
    }
    public void NimetaPeatused(List<String> peatused){
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
