package villagegaulois;

import personnages.Gaulois;
import produit.IProduit;
import produit.Produit;

public class Etal<P extends Produit> implements IEtal {
	
	private Gaulois vendeur;
	private IProduit[] produits;
	private int nbProduit;
	private double prix;
	
	public void installerVendeur(Gaulois vendeur, P[] produits, int prix) {
		this.vendeur = vendeur;
		this.produits = new IProduit[produits.length];
		for (int i = 0; i<produits.length; i++)
			this.produits[i] = produits[i];
		this.nbProduit = produits.length;
		this.prix = prix;
	}

	@Override
	public Gaulois getVendeur() {
		return vendeur;
	}

	@Override
	public double donnerPrix() {
		return prix;
	}

	@Override
	public int contientProduit(String produit, int quantiteSouhaitee) {
		int quantiteAVendre = 0;
		if (nbProduit != 0 && this.produits[0].getNom().equals(produit)) {
			if (nbProduit >= quantiteSouhaitee)
				quantiteAVendre = quantiteSouhaitee;
			else
				quantiteAVendre = nbProduit;
		}
		return quantiteAVendre;
	}

	@Override
	public double acheterProduit(int quantiteSouhaitee) {
		double prixPaye = 0;
		for (int i = nbProduit - 1; i > nbProduit - quantiteSouhaitee - 1 || i > 1; i--)
			prixPaye += produits[i].calculerPrix(prix);
		if (nbProduit >= quantiteSouhaitee)
			nbProduit -= quantiteSouhaitee;
		else
			nbProduit = 0;
		return prixPaye;
	}

	@Override
	public String etatEtal() {
		StringBuilder chaine = new StringBuilder(vendeur.getNom());
		if (nbProduit > 0) {
			chaine.append(" vend ");
			chaine.append(nbProduit + " produits :");
			for (int i = 0; i < nbProduit; i++) {
				chaine.append("\n- " + produits[i].getDescription());
				}
			} else {
				chaine.append(" n'a plus rien à vendre.");
				}
		chaine.append("\n");
		return chaine.toString();
	}

}
