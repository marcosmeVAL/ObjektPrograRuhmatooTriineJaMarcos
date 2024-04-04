import java.util.ArrayList;
import java.util.List;

public class Rong {
    private String nimi;
    private int kohtadeArv;
    private double hind;
    private List<String> peatused;
    private String mudel;
    private List<Reisija> reisijad;

    public Rong(String nimi, int kohtadeArv, String mudel, double hind, List<String> peatused) {
        this.nimi = nimi;
        this.kohtadeArv = kohtadeArv;
        this.peatused = peatused;
        this.mudel = mudel;
        this.reisijad = new ArrayList<Reisija>();
        this.hind = hind;
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

    public String getMudel() {
        return mudel;
    }




}
