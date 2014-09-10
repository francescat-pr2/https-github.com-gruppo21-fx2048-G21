
 
package giocatoreAutomatico.player;

import game2048.GameManager;
import game2048.Location;
import giocatoreAutomatico.Griglia;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Francesca
 * @author Nadia
 */
public class MyGriglia implements Griglia{
    
    
    Map mapGriglia;
    Map myGrid;
    int chiavi;
    private final Location key;
    private Integer value;
    
    private int DEFAULT_CAPACITY = 16;
    
    public MyGriglia(){
        this.key=new Location(0,0);
        
        this.mapGriglia = new HashMap<Location,Integer>(16);
                
       
       //inizializza griglia a -1 per tutte le caselle 
       for(int i=0;i<4;i++){
           for(int j=0;j<4;j++){
               mapGriglia.put(new Location(i,j),-1);
               
           }
       } 
        
    
    }
    
    //restituisce la griglia inizializzata dal main
    public Griglia getGriglia(){
        return this;
    }
    
    
    


    @Override
    public boolean isEmpty() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean containsKey(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean containsValue(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

        //restituisce il valore associato alla chiave passata come parametro
    @Override
    public Integer get(Object o) {
       
        return (Integer)mapGriglia.get(o);
        
        
        
        //return 1;
    }

    @Override
    public Integer put(Location k, Integer v) {
       
        Iterator itKey=mapGriglia.keySet().iterator();
        
                
        mapGriglia.put(k, v);
        return v;
    
         
       
    }

    @Override
    public Integer remove(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void putAll(Map<? extends Location, ? extends Integer> map) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set<Location> keySet() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<Integer> values() {
        return mapGriglia.values();
        
    }

    @Override
    public Set<Entry<Location, Integer>> entrySet() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int size() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
