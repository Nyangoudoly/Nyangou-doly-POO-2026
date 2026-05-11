
package ipplanmanager.repository;

import ipplanmanager.model.ResultatVLSM;
import ipplanmanager.model.VLAN;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
/**
 *
 * @author doly
 */
public class FichierPlanRepository {
    public void sauvegarderPlanCSV(ArrayList<ResultatVLSM> resultats, String cheminFichier) throws IOException {
        try (FileWriter writer = new FileWriter(cheminFichier)) {
            writer.write("Nom;AdresseReseau;CIDR;Masque;Capacite\n");
            for (ResultatVLSM r : resultats) {
                writer.write(r.getNomBesoin() + ";" 
                        + r.getAdresseReseau() + ";" 
                        + r.getCidr() + ";" 
                        + r.getMasqueDecimal() + ";" 
                        + r.getCapacite() + "\n");
            }
        }
    }

    public void sauvegarderVLANsCSV(ArrayList<VLAN> vlans, String cheminFichier) throws IOException {
        try (FileWriter writer = new FileWriter(cheminFichier)) {
            writer.write("ID;Nom;ReseauAssocie\n");
            for (VLAN v : vlans) {
                String adresse = (v.getReseauAssocie() != null) ? v.getReseauAssocie().getAdresseReseau() : "N/A";
                writer.write(v.getId() + ";" + v.getNom() + ";" + adresse + "\n");
            }
        }
    }
}







