package Pole;

import Core.Hrac;

public class Start extends Pole{
    @Override
    public void Efekt(Hrac hrac) {
        System.out.println("Spoupnul si na pole startu, pole číslo: " + (hrac.Getpozice() + 1));
    }
}
