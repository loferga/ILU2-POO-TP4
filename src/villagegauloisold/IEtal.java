package villagegauloisold;

import personnages.Gaulois;
import produit.IProduit;

public interface IEtal {

	boolean isEtalOccupe();

	Gaulois getVendeur();

	int getQuantite();

	IProduit getProduit();

	void occuperEtal(Gaulois vendeur, IProduit produit, int quantite);

	boolean contientProduit(IProduit produit);

	int acheterProduit(int quantiteAcheter);

	void libererEtal();
	
	Object[] etatEtal();

}