
package projetgsm;

/**
 *
 * @author doly
 */

public class MSIntrouvableException extends Exception {

    private String msisdn;

    // ========== CONSTRUCTEUR ==========
    public MSIntrouvableException(String msisdn) {
        super("Erreur : L'utilisateur avec le numéro " + msisdn + 
              " est introuvable dans le réseau !");
        this.msisdn = msisdn;
    }

    // ========== GETTER ==========
    public String getMsisdn() {
        return msisdn;
    }
}
