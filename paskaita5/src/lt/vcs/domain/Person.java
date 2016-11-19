package lt.vcs.domain;

import lt.vcs.interfaces.Identified;
import lt.vcs.interfaces.Named;


/**
 *
 * @author aleksandras
 */
public abstract class Person implements Named, Identified{           // abstract leidzia nedeti taisykles is PetLover
    
    private String name;
    private String lastName;
    private String id;
    
    public Person (String name, String lastName, String id){
        this.name = name;
        this.lastName = lastName;
        this.id = id;
        talk();                                         // 
    }
    
    protected abstract void talk();
    
    @Override
    public String toString(){                           //overriding
        return String.format("Person(name=%s, lastName=%s) object=%s", name, lastName, super.toString()); //implementing "super" to reach parent object...
    }
    
    public String toString(String txt){                 //overloading
        return txt + toString();                        // add toString without parameters      (Object)toString() -- Casting
    }
    
    public String toString(int txt){                 //overloading
        return null;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastName;
    }

    public void setLastname(String lastname) {
        this.lastName = lastname;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    @Override
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
}
