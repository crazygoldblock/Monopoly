package Core;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

import Pole.*;

public class App {
    static Scanner sc = new Scanner(System.in);
    static Pole[] hra = new Pole[Konstanty.POCET_POLI];
    static LinkedList<Hrac> hraci = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        
        hra[0] = new Start();
        hra[1] = new Budova("Mediteranean Avenue", 60, 50);
        hra[2] = new Finance();
        hra[3] = new Budova("Baltic Avenue", 60, 50);
        hra[4] = new Pokuta("Daň z příjmu", 200);
        hra[5] = new Zeleznice(0, "Reading Railroad", 200);
        hra[6] = new Budova("Oriental Avenue", 100, 50);
        hra[7] = new Nahoda();
        hra[8] = new Budova("Vermont Avenue", 100, 50);
        hra[9] = new Budova("Connecticut Avenue", 140, 50);
        hra[10] = new Vezeni();
        hra[11] = new Budova("St. Charles Place", 150, 100);
        hra[12] = new Podnik(0, "Elektrárna", 150);
        hra[13] = new Budova("States Avenue", 140, 100);
        hra[14] = new Budova("Virginia Avenue", 160, 100);
        hra[15] = new Zeleznice(1, "Pennsylvanie Railroad", 200);
        hra[16] = new Budova("St. James Place", 200, 100);
        hra[17] = new Finance();
        hra[18] = new Budova("Tennessee Avenue", 180, 100);
        hra[19] = new Budova("New York Avenue", 180, 100);
        hra[20] = new Parkovani();
        hra[21] = new Budova("Kentucky Avenue", 200, 150);
        hra[22] = new Nahoda();
        hra[23] = new Budova("Indiana Avenue", 220, 150);
        hra[24] = new Budova("Illinois Avenue", 220, 150);
        hra[25] = new Zeleznice(2, "B.+O. Railroad", 200);
        hra[26] = new Budova("Atlantic Avenue", 240, 150);
        hra[27] = new Budova("Ventor Avenue", 260, 150);
        hra[28] = new Podnik(1, "Vodárna", 150);
        hra[29] = new Budova("Marvin Gardens", 260, 150);
        hra[30] = new DoVezeni();
        hra[31] = new Budova("Pacific Avenue", 280, 200);
        hra[32] = new Budova("North Carolina Avenue", 300, 200);
        hra[35] = new Finance();
        hra[34] = new Budova("Pennsylvania Avenue", 320, 200);
        hra[35] = new Zeleznice(3, "Shortline (Railroad)", 200);
        hra[36] = new Nahoda();
        hra[37] = new Budova("Park Place", 350, 200);
        hra[38] = new Pokuta("Daň z luxusu", 75);
        hra[39] = new Budova("Boardwalk", 400, 200);
        
        String[] barvy = {"Modrý", "Zelený", "Žlutý", "Červený", "Černý", "Bílý"};

        System.out.println("Zadej počet hráčů:");
        int pocet = GetPocetHracu();

        for (int i = 0; i < pocet; i++) {
            hraci.add(new Hrac(barvy[i]));
        }

        while(true) {
            Hrac hrac = hraci.removeFirst();
            hraci.addLast(hrac);
            System.out.println("Hraje " + hrac.GetBarva() + " hráč");
            Tah(hrac);
            
            if (hraci.size() == 1) {
                System.out.println("Hra končí vyhrává poslední hráč");
                break;
            }
        } 

    }
    static void Tah(Hrac hrac) {
        if (hrac.GetVezeni()) {
            if (Vezeni.VeVezeni(sc))
                hrac.ZVezeni();
        }
        else {
            int hod = Kostka.Hod(sc);
            if (hod == 6) {
                System.out.println("Hodil si 6ku můžeš házej ještě jednou");
                hod += Kostka.Hod(sc);
                System.out.println("Dohromady si hodil:" + hod);
            }
    
            hrac.posunout(hod);
            
            hra[hrac.Getpozice()].Efekt(hrac);
        }
    }

    public static void VyraditHrace(Hrac hrac) {
        for (PoleMajitel pole : PoleMajitel.poleMajiteleList) {
            pole.OdstranitMajitele(hrac);
        }
        hraci.remove(hrac);
    }
    public static int GetPocetHracu() {
        int i = 0;
        while(i == 0) {
            try {
                i = sc.nextInt();
                if (i < 1)
                    i = 0;
            }
            catch (InputMismatchException e) { 
                sc.next();
                i = 0;
            }
        }
        sc = new Scanner(System.in);
        if (i > Konstanty.MAX_POCET_HRACU)
            return 6;
        return i;
    }
    public static int GetChoice(String[] moznosti) {
        for (int i = 0; i < moznosti.length; i++) {
            System.out.println((i + 1) + ". " + moznosti[i]);
        }
        int i = 0;
        while(i == 0) {
            try {
                i = sc.nextInt();
                if (i < 1 || i > moznosti.length)
                    i = 0;
            }
            catch (InputMismatchException e) { 
                sc.next();
                i = 0;
            }
        }
        return i - 1;
    }
    public static boolean Confirm(String moznost) {
        System.out.println("Y/N: " + moznost);

        while(true) {
            try {
                String odp = sc.nextLine();
                if (odp.equals("Y")) 
                    return true;
                if (odp.equals("N"))
                    return false;     
            }
            catch (InputMismatchException e) { 
                sc.next();
            }
        }
    }
}
