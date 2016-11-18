package lt.vcs.klases;

/**
 *
 * @author aleksandras
 */
public enum Enumas {
    
    REIKSME1("lietuviskai1", "lietuviskai1"), 
    REIKSME2("lietuviskai2", "lietuviskai2"),
    REIKSME3("lietuviskai3", "lietuviskai3");
    
    private String lt;
    private String en;
    
    private Enumas (String lt, String en){
        
        this.lt = lt;
        this.en = en;
        
    }

    public String getLt() {
        return lt;
    }

    public String getEn() {
        return en;
    }
    
    public String getDescription(String kalba){
        String result = null;
        if("lt".equals(kalba)){
            result = this.lt;
        }   else if ("en".equals(kalba)){
            result = this.en;
        }
        
        return result;
        
    }
    
}
