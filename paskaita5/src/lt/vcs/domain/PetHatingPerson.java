package lt.vcs.domain;

import lt.vcs.VcsUtils;

/**
 *
 * @author aleksandras
 */
public class PetHatingPerson extends Person {
    
    public PetHatingPerson (String name, String lastName, String id){
        super(name, lastName, id);
    }
    
    protected void talk(){
        VcsUtils.println("PetHatingPerson is talking");
    }
}
