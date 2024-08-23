package Pole;
import Core.Hrac;
import Core.Konstanty;

public class DoVezeni extends Pole{
    @Override
    public void Efekt(Hrac hrac) {
        System.out.println("Stoupnul si na pole ze kterého jdeš do vězení, pole číslo:" + (hrac.Getpozice() + 1));
        hrac.skok(Konstanty.POLE_VEZENI);
        hrac.DoVezeni();
    }
}
