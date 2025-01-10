
package kalapacsvetes;

import java.util.List;
import static kalapacsvetes.Sportolo.beolvasFajlbol;


public class Kalapacsvetes {


    public static void main(String[] args) {
        String fajlNev = "C:\\Users\\kocsi\\OneDrive\\Dokumentumok\\java\\Kalapacsvetes\\build\\classes\\kalapacsvetes\\kalapacsvetes.txt";
        List<Sportolo> sportolok = beolvasFajlbol(fajlNev);

        for (Sportolo sportolo : sportolok) {
            System.out.println(sportolo);
        }
    }
    
}
