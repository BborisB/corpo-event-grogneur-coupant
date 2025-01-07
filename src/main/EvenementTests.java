package main;

import model.Evenement;
import repository.EvenementRepository;

public class EvenementTests {

	public static void main(String[] args) {
        EvenementRepository repository = new EvenementRepository();

        // Création d'événements
        Evenement evenement1 = new Evenement();
        evenement1.setTitre("Conférence Java");
        evenement1.setDescriptif("Conférence sur les nouveautés de Java");
        evenement1.setLieu("Paris");

        Evenement evenement2 = new Evenement();
        evenement2.setTitre("Hackathon");
        evenement2.setDescriptif("Compétition de codage de 48h");
        evenement2.setLieu("Lyon");

        // Ajout des événements
        repository.creerEvenement(evenement1);
        repository.creerEvenement(evenement2);

        // Affichage de tous les événements
        System.out.println("Liste des événements :");
        for (Evenement e : repository.trouverTous()) {
            System.out.println(e.getId() + " - " + e.getTitre() + " : " + e.getDescriptif() + " (" + e.getLieu() + ")");
        }

        // Modification d'un événement
        evenement1.setDescriptif("Conférence mise à jour sur Java");
        repository.modifierEvenement(evenement1.getId(), evenement1);

        // Affichage après modification
        System.out.println("\nListe des événements après modification :");
        for (Evenement e : repository.trouverTous()) {
            System.out.println(e.getId() + " - " + e.getTitre() + " : " + e.getDescriptif() + " (" + e.getLieu() + ")");
        }

        // Suppression d'un événement
        repository.supprimerEvenement(evenement2.getId());

        // Affichage après suppression
        System.out.println("\nListe des événements après suppression :");
        for (Evenement e : repository.trouverTous()) {
            System.out.println(e.getId() + " - " + e.getTitre() + " : " + e.getDescriptif() + " (" + e.getLieu() + ")");
        }

        // Recherche d'un événement par ID
        int idRecherche = evenement1.getId();
        Evenement evenementTrouve = repository.trouverParId(idRecherche);
        if (evenementTrouve != null) {
            System.out.println("\nÉvénement trouvé : " + evenementTrouve.getId() + " - " + evenementTrouve.getTitre());
        } else {
            System.out.println("\nÉvénement avec l'ID " + idRecherche + " non trouvé.");
        }
    }

}
