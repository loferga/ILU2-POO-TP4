package scenarioTest;

import java.util.Arrays;

import personnages.Gaulois;
import produit.Poisson;
import produit.Produit;
import produit.Sanglier;
import villagegaulois.Etal;
import villagegaulois.IEtal;
import villagegaulois.IVillage;
import villagegauloisold.DepenseMarchand;

public class Scenario {

	public static void main(String[] args) {
		
		IVillage village = new IVillage() {
			
			private IEtal[] marche = new IEtal[20];
			private int nbEtal;
			
			@Override
			public <P extends Produit> boolean installerVendeur(villagegaulois.Etal<P> etal, Gaulois vendeur, P[] produit, int prix) {
				etal.installerVendeur(vendeur, produit, prix);
				marche[nbEtal++] = etal;
				return true;
			}
			
			@Override
			public DepenseMarchand[] acheterProduit(String produit, int quantiteSouhaitee) {
				int qttSouhaitee = quantiteSouhaitee;
				DepenseMarchand[] dm = new DepenseMarchand[marche.length];
				int nbDepenses = 0;
				int nbVendu;
				for (int i = 0; i<nbEtal && qttSouhaitee > 0; i++) {
					IEtal etal = marche[i];
					nbVendu = etal.contientProduit(produit, qttSouhaitee);
					if (nbVendu > 0) {
						dm[nbDepenses++] = new DepenseMarchand(etal.getVendeur(), nbVendu, produit, etal.acheterProduit(nbVendu));
						qttSouhaitee -= nbVendu;
					}
				}
				return Arrays.copyOfRange(dm, 0, nbDepenses);
			}
			
			@Override
			public String toString() {
				StringBuilder str = new StringBuilder();
				for (int i = 0; i<nbEtal; i++) {
					IEtal etal = marche[i];
					str.append(etal.etatEtal());
					str.append('\n');
				}
				return str.toString();
			}
			
		};
		
		Gaulois ordralfabetix = new Gaulois("Ordralfabétix", 9);
		Gaulois obelix = new Gaulois("Obélix", 20);
		Gaulois asterix = new Gaulois("Astérix", 6);
		
		Etal<Sanglier> etalSanglierObelix = new Etal<>();
		Etal<Sanglier> etalSanglierAsterix = new Etal<>();
		Etal<Poisson> etalPoisson = new Etal<>();
		
		Sanglier sanglier1 = new Sanglier(2000, obelix);
		Sanglier sanglier2 = new Sanglier(1500, obelix);
		Sanglier sanglier3 = new Sanglier(1000, asterix);
		Sanglier sanglier4 = new Sanglier(500, asterix);
		
		Sanglier[] sangliersObelix = { sanglier1, sanglier2 };
		Sanglier[] sangliersAsterix = { sanglier3, sanglier4 };
		
		Poisson poisson1 = new Poisson("lundi");
		Poisson[] poissons = { poisson1 };
		
		village.installerVendeur(etalSanglierAsterix, asterix, sangliersAsterix, 10);
		village.installerVendeur(etalSanglierObelix, obelix, sangliersObelix, 8);
		village.installerVendeur(etalPoisson, ordralfabetix, poissons, 5);

		System.out.println(village);

		DepenseMarchand[] depense = village.acheterProduit("sanglier", 3);

		for (int i = 0; i < depense.length && depense[i] != null; i++) {
			System.out.println(depense[i]);
		}

		System.out.println(village);

	}

}
