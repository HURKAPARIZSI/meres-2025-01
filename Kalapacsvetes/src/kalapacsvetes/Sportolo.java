
package kalapacsvetes;

import java.io.*;
import java.util.*;



public class Sportolo {
    private int helyezes;
    private double eredmeny;
    private String nev;
    private String orszagkod;
    private String helyszin;
    private String datum;

    public Sportolo(int helyezes, double eredmeny, String nev, String orszagkod, String helyszin, String datum) {
        this.helyezes = helyezes;
        this.eredmeny = eredmeny;
        this.nev = nev;
        this.orszagkod = orszagkod;
        this.helyszin = helyszin;
        this.datum = datum;
    }

    public static List<Sportolo> beolvasFajlbol(String fajlNev) {
        List<Sportolo> sportolok = new ArrayList<>();
        RandomAccessFile fajl;
 
        try{
            fajl = new RandomAccessFile(fajlNev,"r");
            String sor;
            fajl.readLine();

            while ((sor = fajl.readLine()) != null) {
                String[] adatok = sor.split(";");
                if (adatok.length == 6) {
                    try {
                        // Helyezés és eredmény biztonságos parse-olása
                        int helyezes = Integer.parseInt(adatok[0].trim());
                        double eredmeny = 0.0;
                        try {
                            eredmeny = Double.parseDouble(adatok[1].replace(",", ".").trim());
                        } catch (NumberFormatException e) {
                            System.out.println("Hiba az eredmény konvertálása közben: " + adatok[1]);
                        }

                        String nev = adatok[2].trim();
                        String orszagkod = adatok[3].trim();
                        String helyszin = adatok[4].trim();
                        String datum = adatok[5].trim();

                        Sportolo sportolo = new Sportolo(helyezes, eredmeny, nev, orszagkod, helyszin, datum);
                        sportolok.add(sportolo);

                    } catch (NumberFormatException e) {
                        System.out.println("Hiba a helyezés konvertálása közben: " + adatok[0]);
                    }
                }
            }
            fajl.close();
        }
          
        
        catch( IOException e ){
            System.out.println("HIBA");
        }
        return sportolok;
    }
}