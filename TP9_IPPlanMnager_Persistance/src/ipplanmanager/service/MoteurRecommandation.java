
package ipplanmanager.service;
import ipplanmanager.model.VLAN;
import ipplanmanager.model.Recommandation;
import java.util.ArrayList;

/**
 *
 * @author doly
 */
public class MoteurRecommandation {
    private ArrayList<RegleRecommandation> regles;
    
    public MoteurRecommandation() {
        regles = new ArrayList<>();
    }

public void ajouterRegle(RegleRecommandation regle) {
    regles.add(regle);
}

public ArrayList<Recommandation> analyserVLANs(ArrayList<VLAN> vlans) {
    ArrayList<Recommandation> recommandations = new ArrayList<>();
    for (VLAN vlan : vlans) {
        for (RegleRecommandation regle : regles) {
            Recommandation recommandation = regle.analyser(vlan);
            if (recommandation != null) {
                recommandations.add(recommandation);
            }
        }
    }
    return recommandations;
}

public void afficherRecommandations(ArrayList<Recommandation> recommandations) {
    if (recommandations.isEmpty()) {
        System.out.println("Aucune recommandation particulière.");
        return;
    }
    for (Recommandation recommandation : recommandations) {
        recommandation.afficher();
    }
}
}