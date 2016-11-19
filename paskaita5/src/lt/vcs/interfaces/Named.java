package lt.vcs.interfaces;

/**
 *
 * @author aleksandras
 */
public interface Named {
    
    public String getName();            // tai yra tik interfaceo taisykle, negali "metodai", kurie is tiesu yra taisykles tureti kuno
                                        // visi interfaceai kaip ir visi metodai juose yra "abstract"
                                        // taigi prideju abstract prie klases, ji tampa nepasiekiama is isores per konstruktoriu
    
}
