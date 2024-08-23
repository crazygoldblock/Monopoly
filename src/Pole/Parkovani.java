package Pole;
import Core.Hrac;

public class Parkovani extends Pole{
    @Override
    public void Efekt(Hrac hrac) {
        System.out.println("Stoupnul si na pole parkoviště, pole číslo:" + (hrac.Getpozice() + 1));
    }
}
