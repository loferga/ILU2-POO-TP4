package produit;

public class Poisson extends Produit {
	
	private String date;
	
	public Poisson(String date) {
		super("poisson", Unite.UNITE);
		this.date = date;
	}

	@Override
	public String getDescription() {
		return getNom() + " p�ch�s " + date;
	}
	
	@Override
	public double calculerPrix(double prix) {
		return prix;
	}

}
