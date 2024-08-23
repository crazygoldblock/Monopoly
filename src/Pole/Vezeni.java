package Pole;

import java.util.Scanner;

import Core.Hrac;
import Core.Kostka;

public class Vezeni extends Pole{
    @Override
    public void Efekt(Hrac hrac) {
        System.out.println("Stoupnul si na pole vězení, pole číslo:" + (hrac.Getpozice() + 1));
        hrac.DoVezeni();
    }
    public static boolean VeVezeni(Scanner sc) {
        System.out.println("Házíš 2krát kostkou pokud padne 6ka tak pokračuješ ve hře");
        int hod = Kostka.Hod(sc);
        if (hod == 6) {
            System.out.println("Další kolo můžeš pokračovat ve hře");
            return true;
        }
        hod = Kostka.Hod(sc);
        if (hod == 6) {
            System.out.println("Další kolo můžeš pokračovat ve hře");
            return true;
        }
        return false;
    }
}
