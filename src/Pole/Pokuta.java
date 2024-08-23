package Pole;
import Core.Hrac;

public class Pokuta extends Pole{
    private int pokuta;
    private String text;

    public Pokuta(String text, int pokuta) {
        this.text = text;
        this.pokuta = pokuta;
    }

    @Override
    public void Efekt(Hrac hrac) {
        System.out.println(text);
        hrac.OdebratPenize(pokuta);
    }
}
