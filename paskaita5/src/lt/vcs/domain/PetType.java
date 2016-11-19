package lt.vcs.domain;

/**
 *
 * @author aleksandras
 */
public enum PetType {
    
    FLYING("Pets that can fly"), 
    AQUA("Pets that live in water"), 
    LAND("Pets that live on land");
    
    private final String description;
    
    private PetType(String description){
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
            
}
