package Core;

public class Hrac {
    private long penize = Konstanty.STATROVNI_PENIZE;
    private int pozice = 0;
    private int hod = 0;
    private boolean veVezeni = false;
    private String barva;

    public Hrac(String barva) {
        this.barva = barva;
    }
    public String GetBarva() {
        return barva;
    }
    public void PridatPenize(long pocet) {
        penize += pocet;
    }
    public boolean GetVezeni() {
        return veVezeni;
    }
    public void DoVezeni() {
        veVezeni = true;
    }
    public void ZVezeni() {
        veVezeni = false;
    }
    public void OdebratPenize(long pocet) {
        penize -= pocet;

        System.out.println("bylo ti odebráno: " + pocet + " peněz");

        if (penize <= 0) {
            System.out.println("Zbankrotoval jsi, jsi  vyřazen ze hry");
            App.VyraditHrace(this);
        }
    }
    public long GetPenize() {
        return penize;
    }
    public int Getpozice() {
        return pozice;
    }
    public int GetHod() {
        return hod;
    }
    public void PenizeStart() {
        penize += Konstanty.KOLO_PENIZE;
        System.out.println("prošel si startem, dostáváš: " + Konstanty.KOLO_PENIZE);
    }
    public void posunout(int pocet) {
        if (pozice + pocet > Konstanty.POCET_POLI - 1) {
            PenizeStart();
            pozice -= Konstanty.POCET_POLI;
        }
        if (pozice + pocet < 0)
            throw new IndexOutOfBoundsException("pozice hráče menší než 0");
        hod = pocet;
        pozice += pocet;
    }
    public void skok(int pozice) {
        if (pozice > Konstanty.POCET_POLI - 1)
            throw new IndexOutOfBoundsException("skok nemůže být na pozici větší jak " + (Konstanty.POCET_POLI - 1));
        if (pozice < 0)
            throw new IndexOutOfBoundsException("skok nemůže být na pozici měnší než 0");

        if (pozice != Konstanty.POLE_VEZENI) {
            if (pozice < this.pozice) {
                PenizeStart();
            }
        }
        this.pozice = pozice;
    }
}
