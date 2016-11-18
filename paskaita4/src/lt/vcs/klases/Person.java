package lt.vcs.klases;

import java.util.Date;

/**
 *
 * @author aleksandras
 */
public class Person {
    
    private String name;
    private String lastName;
    private String id;
    private Date birthDate;
    
    
    public Person(String name, String lastName, String id, Date birthDate){
        this.name = name;
        this.lastName = lastName;
        this.id = id;
        this.birthDate = birthDate;
    }
    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

        public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
    
}
