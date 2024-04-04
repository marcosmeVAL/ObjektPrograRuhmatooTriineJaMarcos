public class Reisija {
    private String nimi;
    private String peatusKusmahaläheb;
    private double raha;

    public Reisija(String nimi, String peatusKusmahaläheb, double raha) {
        this.nimi = nimi;
        this.peatusKusmahaläheb = peatusKusmahaläheb;
        this.raha = raha;
    }

    public String getNimi() {
        return nimi;
    }

    public double getRaha() {
        return raha;
    }

    public String getPeatusKusmahaläheb() {
        return peatusKusmahaläheb;
    }

    public void LahkubRongist() {
        System.out.println(this.getNimi() + " lahkus rongist peatuses " + this.getPeatusKusmahaläheb()+".");
        return;
    }
    public boolean KasOnKüllaltRaha(double hind){
        if (hind > this.getRaha()){
            double paljuPuuduJääb = hind - this.getRaha();
            System.out.println(this.getNimi() + " jäi puudu " + paljuPuuduJääb + "€ piletist.");
            return false;
        }System.out.println(this.getNimi() + " sai pileti ostetud.");
        return true;
    }
    public void Istekoht(int koht){
        System.out.println(this.getNimi() + " istus kohale " + koht + ".");
        return;
    }

}