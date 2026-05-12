package projetgsm;



/**
 *
 * @author doly
 */

public class TestReseau {

    public static void main(String[] args) {

    System.out.println("========================================");
    System.out.println("        PROJET 2 POO : GSM              ");
    System.out.println("----------------------------------------");
    System.out.println("  Réalisé par :     NYANGOU YENOU Mariatou doly            ");
    System.out.println("  Filière     : LIRT        ");
    System.out.println("  Année       : 2025/2026              ");
    System.out.println("========================================");
        System.out.println("========================================");
        System.out.println("     SIMULATION RÉSEAU GSM              ");
        System.out.println("========================================");

        // ========== CREATION DU RESEAU ==========
        Reseau reseau = new Reseau(
                "Orange CM",    // nom
                890, 915,       // bande Uplink min/max (MHz)
                935, 960,       // bande Downlink min/max (MHz)
                "TDMA",         // type accès multiple
                50.0,           // débit max Uplink (Mbps)
                100.0,          // débit max Downlink (Mbps)
                10.0            // délai max (ms)
        );

        // ========== CREATION DES BTS ==========
        BTS bts1 = new BTS(
                1,          // numéro
                "Yaoundé",  // emplacement
                30.0,       // hauteur (m)
                "urbain",   // type milieu
                2.5,        // rayon couverture (km)
                20.0,       // puissance émission (W)
                3,          // nombre max utilisateurs
                3           // nombre de cellules
        );

        BTS bts2 = new BTS(
                2,
                "Foumban",
                25.0,
                "urbain",
                3.0,
                25.0,
                2,
                2
        );

        BTS bts3 = new BTS(
                3,
                "Bafoussam",
                20.0,
                "rural",
                5.0,
                30.0,
                2,
                1
        );

        // ========== AJOUT DES BTS AU RESEAU ==========
        System.out.println("\n--- Ajout des BTS ---");
        reseau.ajouterBTS(bts1);
        reseau.ajouterBTS(bts2);
        reseau.ajouterBTS(bts3);

        // ========== CREATION DES MS ==========
        System.out.println("\n--- Création des utilisateurs ---");

        Smartphone sm1 = new Smartphone(
                "nyangou", "doly",
                "pass123",
                "699001122",
                "IMSI001",
                "Samsung",
                "Android",
                6.5,
                128,
                true
        );

        Smartphone sm2 = new Smartphone(
                "kengne", "wilfried",
                "pass456",
                "677334455",
                "IMSI002",
                "iPhone",
                "iOS",
                6.1,
                256,
                false
        );

        Tablet tab1 = new Tablet(
                "molu", "Jeane",
                "pass789",
                "655667788",
                "IMSI003",
                "Samsung",
                10.5,
                64,
                true,
                0.5
        );

        Tablet tab2 = new Tablet(
                "mfotah", "faissal",
                "pass000",
                "688990011",
                "IMSI004",
                "Huawei",
                9.7,
                128,
                false,
                0.4
        );

        // ========== CONNEXION DES MS AUX BTS ==========
        System.out.println("\n--- Connexion des utilisateurs ---");
        try {
            sm1.seConnecter(bts1);
            sm2.seConnecter(bts1);
            tab1.seConnecter(bts2);
            tab2.seConnecter(bts3);
        } catch (BTSSatureeException e) {
            System.out.println(e.getMessage());
        }

        // ========== TEST BTS SATUREE ==========
        System.out.println("\n--- Test BTS Saturée ---");
        Smartphone sm3 = new Smartphone(
                "Bello", "Ahmed",
                "pass111",
                "699111222",
                "IMSI005",
                "Tecno",
                "Android",
                6.0,
                64,
                false
        );
        Smartphone sm4 = new Smartphone(
                "Simo", "Lea",
                "pass222",
                "677222333",
                "IMSI006",
                "Itel",
                "Android",
                5.5,
                32,
                false
        );
        try {
            sm3.seConnecter(bts2); // bts2 max = 2, déjà 1 connecté
            sm4.seConnecter(bts2); // devrait déclencher BTSSatureeException
        } catch (BTSSatureeException e) {
            System.out.println("EXCEPTION ATTRAPEE : " + e.getMessage());
        }

        // ========== AFFICHAGE DES INFOS ==========
        System.out.println("\n--- Infos des utilisateurs ---");
        sm1.afficherInfos();
        tab1.afficherInfos();

        // ========== TEST APPELS ==========
        System.out.println("\n--- Test des appels ---");
        sm1.appeler(sm2);
        tab1.appeler(tab2);
        sm2.afficherAppelsRecus();
        tab2.afficherAppelsRecus();

        // ========== LOCALISER UN UTILISATEUR ==========
        System.out.println("\n--- Localisation d'un utilisateur ---");
        try {
            reseau.localiserUtilisateur("677334455"); // sm2
            reseau.localiserUtilisateur("000000000"); // inexistant
        } catch (MSIntrouvableException e) {
            System.out.println("EXCEPTION ATTRAPEE : " + e.getMessage());
        }

        // ========== STATISTIQUES DU RESEAU ==========
        System.out.println("\n--- Statistiques du réseau ---");
        System.out.println("BTS urbaines  : " + 
                          reseau.nombreBTSParMilieu("urbain"));
        System.out.println("BTS rurales   : " + 
                          reseau.nombreBTSParMilieu("rural"));
        System.out.println("Total abonnés : " + 
                          reseau.nombreTotalAbonnes());

        // ========== PERFORMANCES DU RESEAU ==========
        System.out.println("\n--- Performances du réseau ---");
        reseau.afficherPerformances();

        // ========== AFFICHER TOUTES LES BTS ==========
        System.out.println("\n--- Toutes les BTS ---");
        reseau.afficherToutesLesBTS();

        // ========== TEST SUPPRIMER BTS ==========
        System.out.println("\n--- Suppression BTS 3 ---");
        reseau.supprimerBTS(3);
        System.out.println("Nombre de BTS restantes : " + 
                          reseau.getNombreBTS());

        // ========== TEST METHODES SPECIFIQUES ==========
        System.out.println("\n--- Méthodes spécifiques ---");
        sm1.activerMode5G();
        tab1.activerModePresentation();

        System.out.println("\n========================================");
        System.out.println("       FIN DE LA SIMULATION             ");
        System.out.println("========================================");
    }
}
