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
        return peatusKusmahaläheb;
    }



    public void LahkubRongist() { // teatab et reisija/ klient lahkus rongist
        System.out.println(getNimi() + " lahkus peatuses " + getPeatusKusmahaläheb());
        return;
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



    public boolean KuidasMaksabKaardiga(double hind, double soodus){   // vaatab mis viisil klient maksab
        String kaardimakse = "k"; double uushind = hind - soodus;
        if (kaardimakse.equals(this.getMakseviis().substring(0,1))){
            if (this.KasOnKüllaltRaha(uushind) == false) return false;
            System.out.println(this.getNimi() + " ostis pileti kaardiga. Pilet maksis: " + uushind);
            this.makse((uushind));
            return true;

        }else return false;
    }
    public boolean KuidasMaksabSulas(double hind){
        String s = "s";
        if (s.equalsIgnoreCase(this.getMakseviis().substring(0,1))){
            if (this.KasOnKüllaltRaha(hind) == false) return false;
            System.out.println(this.getNimi() + " ostis pileti sulas. Pilet maksis: " + hind);
            this.makse(hind);
            return true;

        } else return false;
    }

}
