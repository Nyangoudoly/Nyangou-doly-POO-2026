package projetgsm;



/**
 *
 * @author doly
 */
public interface Connectable {
    boolean seConnecter(BTS bts) throws BTSSatureeException;
    void seDeconnecter(BTS bts);
}
    

