package repository;

import model.Evenement;

import java.util.ArrayList;
import java.util.List;

public class EvenementRepository {
    private List<Evenement> evenements = new ArrayList<>();
    private int compteur = 1;

    /**
     * Crée un nouvel événement, lui attribue un ID unique et l'ajoute à la liste.
     *
     * @param evenement l'événement à ajouter
     */
    public void creerEvenement(Evenement evenement) {
        evenement.setId(compteur++);
        evenements.add(evenement);
    }

    /**
     * Modifie un événement existant.
     *
     * @param id l'identifiant de l'événement à modifier
     * @param evenement l'événement avec les nouvelles données
     */
    public void modifierEvenement(int id, Evenement evenement) {
        for (int i = 0; i < evenements.size(); i++) {
            if (evenements.get(i).getId() == id) {
                evenement.setId(id); // Conserver l'ID existant
                evenements.set(i, evenement);
                break;
            }
        }
    }

    /**
     * Supprime un événement de la liste.
     *
     * @param id l'identifiant de l'événement à supprimer
     */
    public void supprimerEvenement(int id) {
        evenements.removeIf(evenement -> evenement.getId() == id);
    }

    /**
     * Trouve un événement par son identifiant.
     *
     * @param id l'identifiant de l'événement
     * @return l'événement correspondant ou null si non trouvé
     */
    public Evenement trouverParId(int id) {
        for (Evenement evenement : evenements) {
            if (evenement.getId() == id) {
                return evenement;
            }
        }
        return null;
    }

    /**
     * Retourne tous les événements.
     *
     * @return la liste de tous les événements
     */
    public List<Evenement> trouverTous() {
        return evenements;
    }

    /**
     * Retourne la liste des événements.
     *
     * @return la liste des événements
     */
    public List<Evenement> getEvenements() {
        return evenements;
    }

    /**
     * Définit la liste des événements.
     *
     * @param evenements la nouvelle liste des événements
     */
    public void setEvenements(List<Evenement> evenements) {
        this.evenements = evenements;
    }
}
