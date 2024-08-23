package Pole;
import java.util.Random;

import Core.Hrac;
import Core.Konstanty;

public class Nahoda extends Pole{
    @Override
    public void Efekt(Hrac hrac) {
        System.out.println("spoupnul si na pole šance, pole číslo: " + hrac.Getpozice() + 1);
        Random rand = new Random();
        int ste = rand.nextInt(7);

        switch(ste) {
            case 0:
                System.out.println("Jdeš na pole startu");
                hrac.skok(Konstanty.POLE_STARTU);
            break;
            case 1:
                System.out.println("Jdeš na poslední pole");
                hrac.skok(Konstanty.POCET_POLI - 1);
            break;
            case 2:
                System.out.println("Jdeš zpátky o tři pole");
                hrac.posunout(-3);
            break;
            case 3:
                System.out.println("Jdeš do vězení");
                hrac.skok(Konstanty.POLE_VEZENI);
            break;
            case 4:
                System.out.println("Zaplatíš pokutu " + 1 * Konstanty.NASOBEK_CEN);
                hrac.OdebratPenize(1 * Konstanty.NASOBEK_CEN);
            break;
            case 5:
                System.out.println("Dostáváš " + 3 * Konstanty.NASOBEK_CEN);
                hrac.PridatPenize(3 * Konstanty.NASOBEK_CEN);
            break;
            case 6:
                System.out.println("Dostáváš " + 2 * Konstanty.NASOBEK_CEN);
                hrac.PridatPenize(2 * Konstanty.NASOBEK_CEN);
            break;
          }
    }
}
