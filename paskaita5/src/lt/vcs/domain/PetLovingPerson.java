package lt.vcs.domain;

import lt.vcs.VcsUtils;
import lt.vcs.interfaces.PetLover;

/**
 *
 * @author aleksandras
 */

public class PetLovingPerson extends Person implements PetLover{        // kai klase yra prapleciama, ji paveldi viska is hierarchijos auksciau
                                                                        //praplesti galima tik viena klase, implementuoti daug ...
  private Pet pet;
  
  public PetLovingPerson (String name, String lastName, String id){
      super(name, lastName, id);
      
  }
  
  protected void talk(){
      VcsUtils.println("PetLovingPerson is talking");
  }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }
}
