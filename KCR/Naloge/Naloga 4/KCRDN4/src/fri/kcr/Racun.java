/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fri.kcr;

/**
 *
 * @author Adrian Jarc
 */

public class Racun {
    private String vrsta;
    private String stevilka;
    private double stanje;
    private double razpolozljivo;
    
    public Racun(String vrsta, String stevilka, double stanje){
        this.vrsta = vrsta;
        this.stevilka = stevilka;
        this.stanje = stanje;
        if (vrsta.equals("Domači račun")){
            this.razpolozljivo = 262.45;
        }
    }
    
    public void spremeniStanje(double kol){
        this.stanje -= kol;
    }
    
    public String vrniVrsto(){
        return this.vrsta;
    }
    
    public String vrniStevilko(){
        return this.stevilka;
    }
    
    public String vrniStanje(){
        if (this.vrsta.equalsIgnoreCase("Domači račun")){
            return this.stanje + " Razpoložljivo: " + this.razpolozljivo;
        }
        return "" + this.stanje; 
    }
}
