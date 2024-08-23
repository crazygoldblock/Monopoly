package Pole;
import Core.App;
import Core.Hrac;
import Core.PoleMajitel;

public class Zeleznice extends PoleMajitel{
    private static Hrac[] hraci = new Hrac[4];

    private int poradi;
    private String jmeno;
    private int cena;

    public Zeleznice(int poradi, String jmeno, int cena) {
        super();
        this.poradi = poradi;
        this.cena = cena;
        this.jmeno = jmeno;
    }
    private void Koupit(Hrac hrac) {
        hraci[poradi] = hrac;
        SetMajitel(hrac);
    }
    private long GetPokuta() {
        int pocet = 0;
        for (Hrac hrac : hraci) {
            if (hrac == majitel)
                pocet++;
        }
        return Math.round(Math.pow(2, pocet - 1) * 25); 
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
        System.out.println("spoupnul si na železnici: " + jmeno + ", pole číslo: " + (hrac.Getpozice() + 1));

        if (majitel != null) {
            if (majitel != hrac) {
                majitel.PridatPenize(GetPokuta());
                hrac.OdebratPenize(GetPokuta());   
            }
        }
        else {
            if (hrac.GetPenize() > cena) {
                if ( App.Confirm("Chceš koupit tuto železnici za " + cena +"?") ) {
                    Koupit(hrac);
                    hrac.OdebratPenize(cena);
                    System.out.println("Železnice zakoupena");
                }
            }
        }
    }

}
