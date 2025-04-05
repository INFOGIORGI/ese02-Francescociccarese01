import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.util.Collections;
public class Gara {
    private ArrayList<Sciatore> sciatori;

    public Gara(){
        this.sciatori = new ArrayList<>();
        CaricaDati();
    }
    
    private void CaricaDati() {
        File file = new File("manche.txt");
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                // leggo riga
                String riga = scanner.nextLine();
                // scompongo riga
                String dati[] = riga.split(",");
                // creo oggetto sciatore
                Sciatore s = new Sciatore(dati[0], Integer.parseInt(dati[1]), Integer.parseInt(dati[2]));
                sciatori.add(s);
            }
        } catch (IOException IOE) {
            System.out.println("errore lettura");
        } finally {
            scanner.close();
        }
    }
    
    public String getVincitore(){
        Sciatore vincente = sciatori.get(0);
        for (Sciatore s : sciatori) {
            if(s.getTempoTotale() < vincente.getTempoTotale()){
                vincente = s;
            }

        }
        return vincente.getNome();
    }
    public void classifica(){
        Collections.sort(sciatori);
        for (Sciatore s : sciatori) {
            System.out.println(s);
        }
    }

}

    


