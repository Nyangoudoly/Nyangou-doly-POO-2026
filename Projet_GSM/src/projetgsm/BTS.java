
package projetgsm;

/**
 *
 * @author doly
 */

public class BTS {

    // ========== ATTRIBUTS ==========
    private int numero;
    private String emplacement;
    private double hauteur;
    private String typeMilieu;        // "urbain" ou "rural"
    private double rayonCouverture;   // en km
    private double puissanceEmission; // en Watts
    private int nombreMaxUtilisateurs;
    private MS[] utilisateurs;        // Tableau des MS connectés
    private int nombreMS;             // Nombre actuel de MS connectés
    private int nombreCellules;       // Une BTS peut gérer plusieurs cellules

    // ========== CONSTRUCTEUR ==========
    public BTS(int numero, String emplacement, double hauteur,
               String typeMilieu, double rayonCouverture,
               double puissanceEmission, int nombreMaxUtilisateurs,
               int nombreCellules) {
        this.numero = numero;
        this.emplacement = emplacement;
        this.hauteur = hauteur;
        this.typeMilieu = typeMilieu;
        this.rayonCouverture = rayonCouverture;
        this.puissanceEmission = puissanceEmission;
        this.nombreMaxUtilisateurs = nombreMaxUtilisateurs;
        this.nombreCellules = nombreCellules;
        this.utilisateurs = new MS[nombreMaxUtilisateurs];
        this.nombreMS = 0;
    }

    // ========== AJOUTER UN MS AVEC EXCEPTION ==========
public boolean ajouterMS(MS ms) throws BTSSatureeException {
    if (estSaturee()) {
        throw new BTSSatureeException(this.numero);
    }
    // Vérifier si le MS est déjà connecté
    for (int i = 0; i < nombreMS; i++) {
        if (utilisateurs[i].getMSISDN().equals(ms.getMSISDN())) {
            System.out.println("MS déjà connecté à cette BTS !");
            return false;
        }
    }
    utilisateurs[nombreMS] = ms;
    nombreMS++;
    System.out.println("MS " + ms.getMSISDN() + 
                     " ajouté à la BTS " + numero);
    return true;
}

    // ========== SUPPRIMER UN MS ==========
    public boolean supprimerMS(MS ms) {
        for (int i = 0; i < nombreMS; i++) {
            if (utilisateurs[i].getMSISDN().equals(ms.getMSISDN())) {
                // Décaler les éléments
                for (int j = i; j < nombreMS - 1; j++) {
                    utilisateurs[j] = utilisateurs[j + 1];
                }
                utilisateurs[nombreMS - 1] = null;
                nombreMS--;
                System.out.println("MS " + ms.getMSISDN() + 
                                 " supprimé de la BTS " + numero);
                return true;
            }
        }
        System.out.println("MS introuvable dans cette BTS !");
        return false;
    }

    // ========== RECHERCHER UN MS ==========
    public MS rechercherMS(String msisdn) {
        for (int i = 0; i < nombreMS; i++) {
            if (utilisateurs[i].getMSISDN().equals(msisdn)) {
                return utilisateurs[i];
            }
        }
        System.out.println("MS " + msisdn + " introuvable !");
        return null;
    }

    // ========== ETAT DE LA BTS ==========
    public boolean estSaturee() {
        return nombreMS >= nombreMaxUtilisateurs;
    }

    // ========== AFFICHAGE ==========
    public void afficherInfos() {
        System.out.println("==============================");
        System.out.println("BTS N°         : " + numero);
        System.out.println("Emplacement    : " + emplacement);
        System.out.println("Hauteur        : " + hauteur + " m");
        System.out.println("Type milieu    : " + typeMilieu);
        System.out.println("Rayon          : " + rayonCouverture + " km");
        System.out.println("Puissance      : " + puissanceEmission + " W");
        System.out.println("Cellules       : " + nombreCellules);
        System.out.println("Utilisateurs   : " + nombreMS + 
                         "/" + nombreMaxUtilisateurs);
        System.out.println("État           : " + 
                         (estSaturee() ? "SATURÉE" : "Disponible"));
        System.out.println("==============================");
    }

    public void afficherTousLesMS() {
        System.out.println("=== Utilisateurs de la BTS " + numero + " ===");
        if (nombreMS == 0) {
            System.out.println("Aucun utilisateur connecté.");
        } else {
            for (int i = 0; i < nombreMS; i++) {
                utilisateurs[i].afficherInfos();
            }
        }
    }

    // ========== GETTERS ==========
    public int getNumero()            { return numero; }
    public String getEmplacement()    { return emplacement; }
    public double getHauteur()        { return hauteur; }
    public String getTypeMilieu()     { return typeMilieu; }
    public double getRayonCouverture(){ return rayonCouverture; }
    public double getPuissance()      { return puissanceEmission; }
    public int getNombreMS()          { return nombreMS; }
    public int getNombreMax()         { return nombreMaxUtilisateurs; }
    public int getNombreCellules()    { return nombreCellules; }
    public MS[] getUtilisateurs()     { return utilisateurs; }
}

