
package ipplanmanager.service;
import ipplanmanager.model.VLAN;
import ipplanmanager.model.Recommandation;

/**
 *
 * @author doly
 */
public interface RegleRecommandation {
    Recommandation analyser(VLAN vlan);
}

