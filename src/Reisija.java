public class Reisija {
    private String nimi;
    private String peatusKusmahaläheb;
    private double raha;
    private String makseviis;

    public Reisija(String nimi, String peatusKusmahaläheb, double raha, String makseviis) {
        this.nimi = nimi;
        this.peatusKusmahaläheb = peatusKusmahaläheb;
        this.raha = raha;
        this.makseviis = makseviis;
    }

    public void setRaha(double raha) {
        this.raha = raha;
    }

    public String getMakseviis() {
        return makseviis;
    }

    public String getNimi() {
        return nimi;
    }

    public double getRaha() {
        return raha;
    }

    public String getPeatusKusmahaläheb() {
        return peatusKusmahaläheb.toLowerCase();
    }

    public void LahkubRongist(String peatus) { // teatab et reisija/ klient lahkus rongist
        if (peatus.equals(this.getPeatusKusmahaläheb())){
            System.out.println(this.getNimi() + " lahkus rongist peatuses " + this.getPeatusKusmahaläheb() + ".");
            return;
        }else return;
    }
    private void makse(double hind){ // sooritab makse
        this.setRaha(this.getRaha() - hind);
        return;
    }

    public boolean KasOnKüllaltRaha(double hind){ // vaatab kas kliendil/reisijal on kyllalt raha
        if (hind > this.getRaha()){
            double paljuPuuduJääb = hind - this.getRaha();
            System.out.println(this.getNimi() + " jäi puudu " + paljuPuuduJääb + "€ piletist.");
            return false;
        }System.out.println(this.getNimi() + " sai pileti ostetud.");
        return true;
    }
    public void Istekoht(int koht){  // pole pannud veel
        System.out.println(this.getNimi() + " istus kohale " + koht + ".");
        return;
    }
    public boolean KuidasMaksab(double hind, double soodus){   // vaatab mis viisil klient maksab
        String kaardimakse = "k"; String s = "s";
        if (kaardimakse.equals(this.makseviis.toLowerCase().charAt(0))){
            if (this.KasOnKüllaltRaha(hind-soodus) == false) return false;
            System.out.println(this.getNimi() + " ostis pileti kaardiga. Pilet maksis: " + hind);
            makse((hind- soodus));
            return true;

        } else if (s.equals(this.makseviis.toLowerCase().charAt(0))) {
            if (this.KasOnKüllaltRaha(hind) == false) return false;
            System.out.println(this.getNimi() + " ostis pileti sulas. Pilet maksis: " + hind);
            makse(hind);
            return true;

        } else return false;
    }

}
