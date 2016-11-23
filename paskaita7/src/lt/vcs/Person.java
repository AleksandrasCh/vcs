package lt.vcs;

import static lt.vcs.VcsUtils.*;

/**
 *
 * @author aleksandras
 */
public class Person {
    
    private String name;
    
    
    public Person (String name){
        this.name = name;
        start();
    }
    
    public void start (){
        println("Esame start metode");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
