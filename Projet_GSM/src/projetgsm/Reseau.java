
package projetgsm;

/**
 *
 * @author doly
 */

public class Reseau {

    // ========== ATTRIBUTS ==========
    private String nom;
    private double bandeUplinkMin;    // Fréquence Uplink min (MHz)
    private double bandeUplinkMax;    // Fréquence Uplink max (MHz)
    private double bandeDownlinkMin;  // Fréquence Downlink min (MHz)
    private double bandeDownlinkMax;  // Fréquence Downlink max (MHz)
    private String typeAccesMultiple; // Ex: TDMA, FDMA, CDMA
    private double debitMaxUplink;    // en Mbps
    private double debitMaxDownlink;  // en Mbps
    private double maxDelai;          // en ms
    private BTS[] tableauBTS;         // Tableau de toutes les BTS
    private int nombreBTS;            // Nombre actuel de BTS

    // ========== CONSTRUCTEUR ==========
    public Reseau(String nom, double bandeUplinkMin, double bandeUplinkMax,
                  double bandeDownlinkMin, double bandeDownlinkMax,
                  String typeAccesMultiple, double debitMaxUplink,
                  double debitMaxDownlink, double maxDelai) {
        this.nom = nom;
        this.bandeUplinkMin = bandeUplinkMin;
        this.bandeUplinkMax = bandeUplinkMax;
        this.bandeDownlinkMin = bandeDownlinkMin;
        this.bandeDownlinkMax = bandeDownlinkMax;
        this.typeAccesMultiple = typeAccesMultiple;
        this.debitMaxUplink = debitMaxUplink;
        this.debitMaxDownlink = debitMaxDownlink;
        this.maxDelai = maxDelai;
        this.tableauBTS = new BTS[100];
        this.nombreBTS = 0;
    }

    // ========== AJOUTER UNE BTS ==========
    public boolean ajouterBTS(BTS bts) {
        if (nombreBTS >= tableauBTS.length) {
            System.out.println("Réseau plein, impossible d'ajouter la BTS !");
            return false;
        }
        // Vérifier si la BTS existe déjà
        for (int i = 0; i < nombreBTS; i++) {
            if (tableauBTS[i].getNumero() == bts.getNumero()) {
                System.out.println("BTS " + bts.getNumero() + 
                                 " existe déjà !");
                return false;
            }
        }
        tableauBTS[nombreBTS] = bts;
        nombreBTS++;
        System.out.println("BTS " + bts.getNumero() + 
                         " ajoutée au réseau " + nom);
        return true;
    }

    // ========== SUPPRIMER UNE BTS ==========
    public boolean supprimerBTS(int numero) {
        for (int i = 0; i < nombreBTS; i++) {
            if (tableauBTS[i].getNumero() == numero) {
                for (int j = i; j < nombreBTS - 1; j++) {
                    tableauBTS[j] = tableauBTS[j + 1];
                }
                tableauBTS[nombreBTS - 1] = null;
                nombreBTS--;
                System.out.println("BTS " + numero + " supprimée !");
                return true;
            }
        }
        System.out.println("BTS " + numero + " introuvable !");
        return false;
    }

    // ========== RECHERCHER UNE BTS ==========
    public BTS rechercherBTS(int numero) {
        for (int i = 0; i < nombreBTS; i++) {
            if (tableauBTS[i].getNumero() == numero) {
                return tableauBTS[i];
            }
        }
        System.out.println("BTS " + numero + " introuvable !");
        return null;
    }

    // ========== CALCULER NOMBRE DE BTS SELON CRITERE ==========
    public int nombreBTSParMilieu(String typeMilieu) {
        int count = 0;
        for (int i = 0; i < nombreBTS; i++) {
            if (tableauBTS[i].getTypeMilieu()
                             .equalsIgnoreCase(typeMilieu)) {
                count++;
            }
        }
        return count;
    }

    // ========== CALCULER NOMBRE D'ABONNES ==========
    public int nombreTotalAbonnes() {
        int total = 0;
        for (int i = 0; i < nombreBTS; i++) {
            total += tableauBTS[i].getNombreMS();
        }
        return total;
    }

    // ========== LOCALISER UTILISATEUR AVEC EXCEPTION ==========
public BTS localiserUtilisateur(String msisdn) 
                               throws MSIntrouvableException {
    for (int i = 0; i < nombreBTS; i++) {
        MS ms = tableauBTS[i].rechercherMS(msisdn);
        if (ms != null) {
            System.out.println("Utilisateur " + msisdn + 
                             " localisé à la BTS " + 
                             tableauBTS[i].getNumero() +
                             " (" + tableauBTS[i].getEmplacement() 
                             + ")");
            return tableauBTS[i];
        }
    }
    throw new MSIntrouvableException(msisdn);
}

    // ========== AFFICHER PERFORMANCES ==========
    public void afficherPerformances() {
        System.out.println("========================================");
        System.out.println("       PERFORMANCES DU RÉSEAU " + nom);
        System.out.println("========================================");
        System.out.println("Type d'accès    : " + typeAccesMultiple);
        System.out.println("Débit Uplink    : " + debitMaxUplink + " Mbps");
        System.out.println("Débit Downlink  : " + debitMaxDownlink + " Mbps");
        System.out.println("Délai max       : " + maxDelai + " ms");
        System.out.println("Bande Uplink    : " + bandeUplinkMin + 
                         " - " + bandeUplinkMax + " MHz");
        System.out.println("Bande Downlink  : " + bandeDownlinkMin + 
                         " - " + bandeDownlinkMax + " MHz");
        System.out.println("Nombre de BTS   : " + nombreBTS);
        System.out.println("Total abonnés   : " + nombreTotalAbonnes());
        System.out.println("========================================");
    }

    // ========== AFFICHER TOUTES LES BTS ==========
    public void afficherToutesLesBTS() {
        System.out.println("=== BTS du réseau " + nom + " ===");
        if (nombreBTS == 0) {
            System.out.println("Aucune BTS dans le réseau.");
        } else {
            for (int i = 0; i < nombreBTS; i++) {
                tableauBTS[i].afficherInfos();
            }
        }
    }

    // ========== GETTERS ==========
    public String getNom()          { return nom; }
    public int getNombreBTS()       { return nombreBTS; }
    public BTS[] getTableauBTS()    { return tableauBTS; }
}
