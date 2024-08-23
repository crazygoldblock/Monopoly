package Core;

import java.util.ArrayList;
import java.util.List;

import Pole.Pole;

public class PoleMajitel extends Pole{
    protected Hrac majitel = null;
    public static List<PoleMajitel> poleMajiteleList = new ArrayList<>();
    
    protected void SetMajitel(Hrac hrac) {
        if (majitel == null)
            majitel = hrac;
        else 
            throw new NullPointerException("Nastavení majitele i když už je nastavený");
    }
    public void OdstranitMajitele(Hrac hrac) {
        if (majitel == hrac) {
            majitel = null;
        }
    } 
    public PoleMajitel() {
        poleMajiteleList.add(this);
    }
}
