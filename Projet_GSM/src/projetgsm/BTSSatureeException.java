
package projetgsm;

/**
 *
 * @author doly
 */


public class BTSSatureeException extends Exception {

    private int numeroBTS;

    // ========== CONSTRUCTEUR ==========
    public BTSSatureeException(int numeroBTS) {
        super("Erreur : La BTS " + numeroBTS + 
              " est saturée ! Impossible d'ajouter un nouvel utilisateur.");
        this.numeroBTS = numeroBTS;
    }

    // ========== GETTER ==========
    public int getNumeroBTS() {
        return numeroBTS;
    }
}
