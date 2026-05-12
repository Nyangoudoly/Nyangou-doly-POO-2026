
package projetgsm;

/**
 *
 * @author doly
 */

public class Tablet extends MS {

    // ========== ATTRIBUTS SPECIFIQUES ==========
    private String marque;
    private double tailleEcran;      // en pouces
    private int capaciteStockage;    // en Go
    private boolean aClavierPhysique;
    private double poidsKg;          // en kg

    // ========== CONSTRUCTEUR ==========
    public Tablet(String nom, String prenom, String motDePasse,
                  String MSISDN, String IMSI, String marque,
                  double tailleEcran, int capaciteStockage,
                  boolean aClavierPhysique, double poidsKg) {
        // Appel du constructeur parent MS
        super(nom, prenom, motDePasse, MSISDN, IMSI);
        this.marque = marque;
        this.tailleEcran = tailleEcran;
        this.capaciteStockage = capaciteStockage;
        this.aClavierPhysique = aClavierPhysique;
        this.poidsKg = poidsKg;
    }

    // ========== POLYMORPHISME : redefinition afficherInfos ==========
    @Override
    public void afficherInfos() {
        System.out.println("==============================");
        System.out.println("         --- TABLET ---       ");
        System.out.println("Nom            : " + nom);
        System.out.println("Prénom         : " + prenom);
        System.out.println("MSISDN         : " + MSISDN);
        System.out.println("IMSI           : " + IMSI);
        System.out.println("Marque         : " + marque);
        System.out.println("Écran          : " + tailleEcran + " pouces");
        System.out.println("Stockage       : " + capaciteStockage + " Go");
        System.out.println("Clavier        : " + 
            (aClavierPhysique ? "Oui" : "Non"));
        System.out.println("Poids          : " + poidsKg + " kg");
        System.out.println("BTS rattachée  : " + 
            (btsRattachee != null ? btsRattachee.getNumero() 
                                  : "Non connecté"));
        System.out.println("==============================");
    }

    // ========== POLYMORPHISME : redefinition appeler ==========
    @Override
    public void appeler(MS destinataire) {
        System.out.println("📟 Appel Tablet via VoIP...");
        String appel = "[Tablet] Appel de " + this.MSISDN + 
                      " -> " + destinataire.getMSISDN();
        destinataire.recevoirAppel(appel);
        System.out.println(appel);
    }

    // ========== METHODE SPECIFIQUE ==========
    public void activerModePresentation() {
        System.out.println(marque + " : Mode présentation activé ! " +
                          "Écran " + tailleEcran + " pouces.");
    }

    // ========== GETTERS ==========
    public String getMarque()           { return marque; }
    public double getTailleEcran()      { return tailleEcran; }
    public int getCapaciteStockage()    { return capaciteStockage; }
    public boolean isAClavierPhysique() { return aClavierPhysique; }
    public double getPoidsKg()          { return poidsKg; }
}
