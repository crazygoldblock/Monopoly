package Pole;
import Core.App;
import Core.Hrac;
import Core.PoleMajitel;

public class Podnik extends PoleMajitel{
    private static Hrac[] hraci = new Hrac[2];

    private int poradi;
    private String jmeno;
    private int cena;

    public Podnik(int poradi, String jmeno, int cena) {
        super();
        this.poradi = poradi;
        this.cena = cena;
        this.jmeno = jmeno;
    }
    private void Koupit(Hrac hrac) {
        hraci[poradi] = hrac;
        SetMajitel(hrac);
    }
    private int GetPokuta(int hod) {
        int pocet = 0;
        for (Hrac hrac : hraci) {
            if (hrac == majitel)
                pocet++;
        }
        if (pocet == 1) {
            return hod * 4;
        }
        if (pocet == 2) {
            return hod * 10;
        }
        throw new IndexOutOfBoundsException("Podnik nemá 1 ani 2 majitele");
    }
    @Override
    public void OdstranitMajitele(Hrac hrac) {
        if (majitel == hrac) {
            majitel = null;
            hraci[poradi] = null;
        }
    }

    @Override
    public void Efekt(Hrac hrac) {
        System.out.println("spoupnul si na podnik: " + jmeno + ", pole číslo: " + (hrac.Getpozice() + 1));

        if (majitel != null) {
            if (majitel != null) {
                majitel.PridatPenize(GetPokuta(hrac.GetHod()));
                hrac.OdebratPenize(GetPokuta(hrac.GetHod()));   
            }
        }
        else {
            if (hrac.GetPenize() > cena) {
                if ( App.Confirm("Chceš koupit tento podnik za " + cena +"?") ) {
                    Koupit(hrac);
                    hrac.OdebratPenize(cena);
                    System.out.println("Podnik zakoupen");
                }
            }
        }
    }
}
