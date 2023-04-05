package scenarioTest;

import personnages.Gaulois;
import produit.Poisson;
import produit.Sanglier;
import villagegaulois.Etal;
import villagegaulois.IEtal;

public class ScenarioTest {
	
	public static void main(String[] args) {
		Gaulois ordralfabetix = new Gaulois("Ordralfaetix", 9);
		Gaulois obelix = new Gaulois("Obélix", 20);
		Gaulois asterix = new Gaulois("Asterix", 6);
		
		Sanglier sanglier1 = new Sanglier(2000, obelix);
		Sanglier sanglier2 = new Sanglier(1500, obelix);
		Sanglier sanglier3 = new Sanglier(1000, asterix);
		Sanglier sanglier4 = new Sanglier(500, asterix);
		
		Sanglier[] sangliersObelix = {sanglier1, sanglier2};
		Sanglier[] sangliersAsterix = {sanglier3, sanglier4};
		
		Poisson poisson1 = new Poisson("lundi");
		Poisson[] poissons = {poisson1};
		
		IEtal[] marche = new IEtal[3];
		Etal<Sanglier> etalObelix = new Etal<>();
		Etal<Sanglier> etalAsterix = new Etal<>();
		Etal<Poisson> etalOrdralfabetix = new Etal<>();
		
		marche[0] = etalObelix;
		marche[1] = etalAsterix;
		marche[2] = etalOrdralfabetix;
		
		etalObelix.installerVendeur(obelix, sangliersObelix, 8);
		etalAsterix.installerVendeur(asterix, sangliersAsterix, 10);
		etalOrdralfabetix.installerVendeur(ordralfabetix, poissons, 7);
	}
	
}
