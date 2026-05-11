
package ipplanmanager.service;
import ipplanmanager.model.Recommandation;
import ipplanmanager.model.VLAN;

/**
 *
 * @author 
 */
public class RecommandationWifiInvite implements RegleRecommandation {
    @Override
    public Recommandation analyser(VLAN vlan) {
        if (vlan.getNom().toUpperCase().contains("WIFI")) {
            return new Recommandation(
                    "Isolation du WiFi",
                    "ÉLEVÉE",
                    "Le VLAN " + vlan.getNom() + " doit être isolé des VLANs internes sensibles."
            );
        }
        return null;
    }
}
