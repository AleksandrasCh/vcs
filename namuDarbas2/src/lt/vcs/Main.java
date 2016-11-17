package lt.vcs;

/**
 *
 * @author aleksandras
 */
public class Main {

    public static int cash = 350;
    
    public static void main(String[] args) {
        
        bankomatas();
        
    }
    
    public static void bankomatas(){
        
        boolean pin = pinKodas();
        
        if (pin == false){
            VcsUtils.println("Kortele uzblokuota!");
        } else {  
            VcsUtils.println("Sveiki!");
            valdymas();
        }
            
    }
    
    public static void valdymas(){
        
        String ats = "";
        boolean pabaiga = false;
        
        while (pabaiga == false){
            
        VcsUtils.println("Jeigu pageidaujate paziureti saskaitos likuti, iveskite \"likutis\"");
        VcsUtils.println("Jeigu pageidaujate issigryninti pinigu, iveskite \"pinigai\"");
        VcsUtils.println("Jeigu pageidaujate baigti darba, iveskite \"baigti\"");
        ats = VcsUtils.newScan().next();  
        
        if (ats.equals("likutis")){
            likutis();
        }   else if (ats.equals("pinigai")){
            pinigai();
        }   else if (ats.equals("baigti")){
            pabaiga = true;
        }   else {
            VcsUtils.println("Nesuprantama ivestis!");
        }
        }

    }
    
    public static void pinigai(){
        
        int pinigai = VcsUtils.inputInt("Kiek pinigu noresite nusiimti?");
        
        if (cash - pinigai >= 0){
            cash -= pinigai;
            VcsUtils.println("Isimta EUR " +pinigai);
        }   else {
            VcsUtils.println("Saskaitoje neuztenka pinigu!");
        }
        
    }
    
    public static void likutis(){
        
        System.out.println("Jusu saskaitos likutis = EUR " + cash);
    }
    
    public static boolean pinKodas(){
        
        int klaida = 0;
        boolean gerasKodas = false;
        String teisingas = "test";
   
        String pinas = VcsUtils.inputWord("Iveskite pin koda \"test\"");
        gerasKodas = pinas.equals(teisingas);
        
        if (gerasKodas == true){
            return gerasKodas;
        } else {
            klaida++;
            while (gerasKodas == false && klaida < 3){
            pinas = VcsUtils.inputWord("Iveskite pin koda \"test\""); 
            gerasKodas = pinas.equals(teisingas);
            
                if (gerasKodas == true){
                    return gerasKodas;
                } else{
                    klaida++;
                }
            }
        }
        return gerasKodas;
    }
   
}
