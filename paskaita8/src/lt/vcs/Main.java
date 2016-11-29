package lt.vcs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import static lt.vcs.VcsUtils.*;

/**
 *
 * @author aleksandras
 */
public class Main {

    
    public static void main(String[] args) {
       
        Integer [] mass = {1,2,3,4,5};
        List<Integer> listas = new ArrayList();     // <> deimantine sintakse
        
        for(int i : mass){
        println("masyve: " + i);           // liste galima laikyti tik objektiniu duomenu tipus
        }
        listas.addAll(Arrays.asList(mass));
        listas.add(1);
        listas.add(3);
        listas.add(5);
        for(int i : listas){
        println("liste: " + i);
        }
        Set<Integer> setas = new HashSet();
        setas.addAll(listas);           // jeigu egzistuoja toks pats dalykas sete, tai sugrupuoja i viena
        for(int i : setas){
            println("sete: " + i);
        }
        
        Map<Integer, String> mapas = new HashMap();
        mapas.put(1, "vienas");
        mapas.put(2, "du");
        mapas.put(3, "trys");
        mapas.put(4, "keturi");
        mapas.put(5, "penki");
        
        for(int i = 1 ; i < 6; i ++ ){
        println("Mape: " + mapas.get(i));
        }
        
    }
    
}
