
package ipplanmanager;

/**
 *
 * @author doly
 */
public class RecommandationMargeAdresse implements RegleRecommandation {
    @Override
    public Recommandation analyser(VLAN vlan) {
        if (vlan.getReseauAssocie() != null) {
            int capacite = vlan.getReseauAssocie().getCapacite();
            int hotesDemandes = vlan.getReseauAssocie().getHotesDemandes();
            int marge = capacite - hotesDemandes;
            if (marge < 10) {
                return new Recommandation(
                    "Marge d'adresses insuffisante",
                    "MOYENNE",
                    "Le VLAN " + vlan.getNom() + " a une marge de seulement "
                    + marge + " hotes. Prevoyez un sous-reseau plus grand."
                );
            }
        }
        return null;
    }
}

