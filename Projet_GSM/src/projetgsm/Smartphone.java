
package projetgsm;

/**
 *
 * @author doly
 */

public class Smartphone extends MS {

    // ========== ATTRIBUTS SPECIFIQUES ==========
    private String marque;
    private String systemeExploitation; // Android, iOS...
    private double tailleEcran;         // en pouces
    private int capaciteStockage;       // en Go
    private boolean has5G;

    // ========== CONSTRUCTEUR ==========
    public Smartphone(String nom, String prenom, String motDePasse,
                      String MSISDN, String IMSI, String marque,
                      String systemeExploitation, double tailleEcran,
                      int capaciteStockage, boolean has5G) {
        // Appel du constructeur parent MS
        super(nom, prenom, motDePasse, MSISDN, IMSI);
        this.marque = marque;
        this.systemeExploitation = systemeExploitation;
        this.tailleEcran = tailleEcran;
        this.capaciteStockage = capaciteStockage;
        this.has5G = has5G;
    }

    // ========== POLYMORPHISME : redefinition afficherInfos ==========
    @Override
    public void afficherInfos() {
        System.out.println("==============================");
        System.out.println("       --- SMARTPHONE ---     ");
        System.out.println("Nom            : " + nom);
        System.out.println("Prénom         : " + prenom);
        System.out.println("MSISDN         : " + MSISDN);
        System.out.println("IMSI           : " + IMSI);
        System.out.println("Marque         : " + marque);
        System.out.println("Système        : " + systemeExploitation);
        System.out.println("Écran          : " + tailleEcran + " pouces");
        System.out.println("Stockage       : " + capaciteStockage + " Go");
        System.out.println("5G             : " + (has5G ? "Oui" : "Non"));
        System.out.println("BTS rattachée  : " + 
            (btsRattachee != null ? btsRattachee.getNumero() 
                                  : "Non connecté"));
        System.out.println("==============================");
    }

    // ========== POLYMORPHISME : redefinition appeler ==========
    @Override
    public void appeler(MS destinataire) {
        System.out.println("📱 Appel Smartphone...");
        String appel = "[Smartphone] Appel de " + this.MSISDN + 
                      " -> " + destinataire.getMSISDN();
        destinataire.recevoirAppel(appel);
        System.out.println(appel);
    }

    // ========== METHODE SPECIFIQUE ==========
    public void activerMode5G() {
        if (has5G) {
            System.out.println(marque + " : Mode 5G activé !");
        } else {
            System.out.println(marque + " : Cet appareil ne supporte pas la 5G !");
        }
    }

    // ========== GETTERS ==========
    public String getMarque()           { return marque; }
    public String getSystème()          { return systemeExploitation; }
    public double getTailleEcran()      { return tailleEcran; }
    public int getCapaciteStockage()    { return capaciteStockage; }
    public boolean isHas5G()            { return has5G; }
}
