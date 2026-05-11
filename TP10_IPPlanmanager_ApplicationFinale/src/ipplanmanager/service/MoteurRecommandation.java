
package ipplanmanager.service;
import ipplanmanager.model.Recommandation;
import ipplanmanager.model.VLAN;
import java.util.ArrayList;

/**
 *
 * @author doly
 */
public class MoteurRecommandation {
    public ArrayList<Recommandation> genererRecommandations(ArrayList<VLAN> vlans) {
        ArrayList<Recommandation> recommandations = new ArrayList<>();
        
        for (VLAN v : vlans) {
            if (v.getReseauAssocie().getCapacite() > 250) {
                recommandations.add(new Recommandation("VLAN " + v.getNom() + " est très grand."));
            }
        }
        return recommandations;
    }
}

