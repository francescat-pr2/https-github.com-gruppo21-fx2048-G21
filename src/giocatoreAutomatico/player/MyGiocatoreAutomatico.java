package giocatoreAutomatico.player;

import giocatoreAutomatico.GiocatoreAutomatico;
import giocatoreAutomatico.Griglia;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Francesca
 * @author Nadia
 */
 
public class MyGiocatoreAutomatico implements GiocatoreAutomatico{
    //int ALTO=0; int DX=1; int BASSO=2; int SX=3;
    Griglia gr;
    

    @Override
    public int prossimaMossa(Griglia g) {
        this.gr=g;
        //viene generato random un int tra 0 e 3 
        int pros = (int) (Math.random() * 4);
        
        
        return pros;
    }
    
    
    
}
