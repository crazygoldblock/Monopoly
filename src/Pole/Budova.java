package Pole;
import java.util.Arrays;

import Core.App;
import Core.Konstanty;
import Core.PoleMajitel;
import Core.Hrac;

public class Budova extends PoleMajitel{
    private int cena;
    private int cenaVylepseni;
    private String jmeno;
    private int pocetVylepseni;

    public Budova(String jmeno, int cena, int cenaVylepseni) {
        super();
        this.jmeno = jmeno;
        this.cena = cena;
        this.cenaVylepseni = cenaVylepseni;
    }

    private void Koupit(Hrac hrac) {
        SetMajitel(hrac);
    }
    private int GetPokuta() {
        return  Math.round((cenaVylepseni * pocetVylepseni + cena) * Konstanty.FAKTOR_POKUTY);
    }
    private int GetDostupneVylepseni() {
        return Konstanty.MAX_POCET_VYLEPSENI - pocetVylepseni;
    }
    private int GetCenaVylespseni(int pocet) {
        if (pocet > GetDostupneVylepseni())
            pocet = GetDostupneVylepseni();
        return cenaVylepseni * pocet;
    }
    private int Vylepsit(int pocet) {
        if (pocet > GetDostupneVylepseni())
            pocet = GetDostupneVylepseni();

        pocetVylepseni += pocet;
        return pocet;
    }

    @Override
    public void Efekt(Hrac hrac) {
        System.out.println("stoupnul si na budovu: " + jmeno + ", pole číslo: " + (hrac.Getpozice() + 1));

        if (majitel == null) {
            if (hrac.GetPenize() > cena && App.Confirm("Chceš koupit tuto budovu za " + cena +"?")) {
                Koupit(hrac);
                hrac.OdebratPenize(cena);
                System.out.println("Budova zakoupena");
            }
            return;
        }

        if (majitel != hrac) {
            majitel.PridatPenize(GetPokuta());
            hrac.OdebratPenize(GetPokuta());
            return;
        }
            
        if (GetDostupneVylepseni() == 0) {
            return;
        }

        if ( App.Confirm("Chceš vylepšit tuto budovu?") ) {
            String[] moznosti = new String[]{
                "Koupit jedno vylepšení za " + GetCenaVylespseni(1),
                "Koupit dvě vylepšení za " + GetCenaVylespseni(2),
                "Koupit tři vylepšení za " + GetCenaVylespseni(3),
                "Koupit čtyři vylepšení za " + GetCenaVylespseni(4)
            };
            int moznost = App.GetChoice(Arrays.copyOfRange(moznosti, 0, GetDostupneVylepseni()));
            if (hrac.GetPenize() > GetCenaVylespseni(moznost + 1)) {
                hrac.OdebratPenize(GetCenaVylespseni(moznost + 1));
                Vylepsit(moznost + 1);
            }
        }
    }
}
