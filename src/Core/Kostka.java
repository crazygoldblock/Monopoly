package Core;
import java.util.Random;
import java.util.Scanner;

public class Kostka {
    public static int Hod(Scanner sc) {
        Random rand = new Random();
        int hod = rand.nextInt(6) + 1;
        System.out.println("na kostce si hodil: " + hod);
        sc.nextLine();
        return hod;
    }
}
