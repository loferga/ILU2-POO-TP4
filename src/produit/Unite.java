package produit;

public enum Unite {
	
	LITRE("l", 1), CENTILITRE("cl", 100), MILLILITRE("ml", 1000), GRAMME("g", 1000000), KILOGRAMME("kg", 1000), UNITE("pièce", 1);
	
	private String unite;
	private int factor;
	
	private Unite(String unite, int factor) {
		this.unite = unite;
		this.factor = factor;
	}
	
	public String getUnite() {
		return unite;
	}
	
	public int getFactor() {
		return factor;
	}
	
}