package Pole;
import java.util.Random;

import Core.Hrac;
import Core.Konstanty;

public class Finance extends Pole{
    @Override
    public void Efekt(Hrac hrac) {
        System.out.println("spoupnul si na pole finance, pole číslo: " + (hrac.Getpozice() + 1));
        Random rand = new Random();
        int penize = (rand.nextInt(7) + 1) * Konstanty.NASOBEK_CEN;
        int r = rand.nextInt(2);

        if (r == 0) {
            System.out.println("Dostáváš " + penize + " peněz");
            hrac.PridatPenize(penize);
        }
        else {
            System.out.println("Strácíš " + penize + " peněz");
            hrac.OdebratPenize(penize);
        }
    }
}
