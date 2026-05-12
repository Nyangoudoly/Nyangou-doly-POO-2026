
package projetgsm;

/**
 *
 * @author doly
 */

public class MS implements Connectable, Appelable {

    // ========== ATTRIBUTS ==========
    protected String nom;
    protected String prenom;
    protected String motDePasse;
    protected String MSISDN;      // Numéro de téléphone
    protected String IMSI;        // Numéro de la carte SIM
    protected String[] appelsRecus; // Tableau des appels reçus
    protected int nombreAppels;     // Nombre d'appels reçus
    protected BTS btsRattachee;     // La BTS à laquelle le MS est connecté

    // ========== CONSTRUCTEUR ==========
    public MS(String nom, String prenom, String motDePasse, 
              String MSISDN, String IMSI) {
        this.nom = nom;
        this.prenom = prenom;
        this.motDePasse = motDePasse;
        this.MSISDN = MSISDN;
        this.IMSI = IMSI;
        this.appelsRecus = new String[100];
        this.nombreAppels = 0;
        this.btsRattachee = null;
    }

    // ========== METHODES CONNECTABLE ==========
    public boolean seConnecter(BTS bts) throws BTSSatureeException {
    if (bts.ajouterMS(this)) {
            this.btsRattachee = bts;
            System.out.println(nom + " " + prenom + 
                             " connecté à la BTS " + bts.getNumero());
            return true;
        } else {
            System.out.println("Connexion impossible : BTS saturée !");
            return false;
        }
    }

    public void seDeconnecter(BTS bts) {
        bts.supprimerMS(this);
        this.btsRattachee = null;
        System.out.println(nom + " " + prenom + " déconnecté !");
    }

    // ========== METHODES APPELABLE ==========
    public void appeler(MS destinataire) {
        String appel = "Appel de " + this.MSISDN + " -> " + destinataire.MSISDN;
        destinataire.recevoirAppel(appel);
        System.out.println(appel);
    }

    public void recevoirAppel(String appel) {
        if (nombreAppels < appelsRecus.length) {
            appelsRecus[nombreAppels] = appel;
            nombreAppels++;
        }
    }

    public void afficherAppelsRecus() {
        System.out.println("=== Appels reçus de " + nom + " " + prenom + " ===");
        if (nombreAppels == 0) {
            System.out.println("Aucun appel reçu.");
        } else {
            for (int i = 0; i < nombreAppels; i++) {
                System.out.println((i + 1) + ". " + appelsRecus[i]);
            }
        }
    }

    // ========== AFFICHAGE ==========
    public void afficherInfos() {
        System.out.println("==============================");
        System.out.println("Nom       : " + nom);
        System.out.println("Prénom    : " + prenom);
        System.out.println("MSISDN    : " + MSISDN);
        System.out.println("IMSI      : " + IMSI);
        System.out.println("BTS       : " + 
            (btsRattachee != null ? btsRattachee.getNumero() : "Non connecté"));
        System.out.println("==============================");
    }

    // ========== GETTERS ==========
    public String getNom()      { return nom; }
    public String getPrenom()   { return prenom; }
    public String getMSISDN()   { return MSISDN; }
    public String getIMSI()     { return IMSI; }
    public BTS getBtsRattachee(){ return btsRattachee; }
}

