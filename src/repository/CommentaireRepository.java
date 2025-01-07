package repository;

import java.util.*;
import model.*;
import main.*;

public class CommentaireRepository {
	private int id = 0;
	private List<Commentaire> commentaires = new ArrayList<Commentaire>();
	
	public void creerCommentaire(String contenu, Evenement evenement) {
		var commentaire = new Commentaire();
		commentaire.setId(id);
		commentaire.setAuteur(Main.utilisateurConnecte);
		commentaire.setContenu(contenu);
		commentaire.setEvenement(evenement);
		commentaires.add(commentaire);
		id++;
	}
	
	public void modifierCommentaire(Commentaire commentaire) {
		var scanner = new Scanner(System.in);
		System.out.print("Entrez le nouveau contenu du commentaire : ");
		commentaire.setContenu(scanner.next());
	}
	
	public void supprimerCommentaire(Commentaire commentaire) {
		commentaires.remove(commentaire);
	}
	
	/**
     * Trouve un commentaire par son identifiant.
     *
     * @param id l'identifiant du commentaire
     * @return le commentaire correspondant ou null si non trouvé
     */
    public Commentaire trouverParId(int id) {
        for (Commentaire commentaire : commentaires) {
            if (commentaire.getId() == id) {
                return commentaire;
            }
        }
        return null;
    }
    
    /**
     * Retourne tous les commentaires associés à un evenement
     * @param evenement l'evenement de recherche
     * @return la liste de tous les commentaires associés à l'evenement
     */
    public List<Commentaire> trouverParEvenement(Evenement evenement) {
        List<Commentaire> commentaires = new ArrayList<Commentaire>();
        for(Commentaire commentaire : this.commentaires)
        	if(commentaire.getEvenement().equals(evenement))
        		commentaires.add(commentaire);
    	return commentaires;
    }
    
    /**
     * Retourne tous les commentaires.
     *
     * @return la liste de tous les commentaires
     */
    public List<Commentaire> trouverTous() {
        return commentaires;
    }
}
