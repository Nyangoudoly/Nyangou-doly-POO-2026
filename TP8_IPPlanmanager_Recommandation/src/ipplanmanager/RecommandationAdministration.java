
package ipplanmanager;

/**
 *
 * @author doly
 */
public class RecommandationAdministration implements RegleRecommandation {
    @Override
    public Recommandation analyser(VLAN vlan) {
        if (vlan.getNom().toUpperCase().contains("ADMIN")) {
            return new Recommandation(
                    "Restriction du VLAN Administration",
                    "ELEVEE",
                    "Le VLAN " + vlan.getNom() + " doit etre accessible aux administrateurs reseau uniquement."
            );
        }
        return null;
    }   
}
