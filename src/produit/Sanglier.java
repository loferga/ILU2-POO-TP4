package produit;

import personnages.Gaulois;

public class Sanglier extends Produit {
	
	private int poids;
	private Gaulois chasseur;
	
	public Sanglier(int poids, Gaulois chasseur) {
		super("sanglier", Unite.KILOGRAMME);
		this.poids = poids;
		this.chasseur = chasseur;
	}
	
	@Override
	public String getDescription() {
		return getNom() + " de " + poids + " " + super.unite.getUnite() + " chassé par " + chasseur.getNom() + ".";
	}
	
	@Override
	public double calculerPrix(double prix) {
		return prix * poids/super.unite.getFactor();
	}
	
}