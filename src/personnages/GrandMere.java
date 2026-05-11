package personnages;
import java.util.Random;

public class GrandMere extends Humain{

	private enum TypeHumain {
		COMMERCANT("un commerçant"),
		RONIN("un ronin"),
		SAMOURAI("un samouraï"),
		YAKUZA("un yakuza"),
		GRANDMERE("une grand-mère"),
		HUMAIN("un habitant");
		
		private String nom;

		private TypeHumain(String nom) {
			this.nom = nom;
		}
		
		@Override
		public String toString() {
			return nom;
		}
		
	}
	private TypeHumain[] types = TypeHumain.values();
	private Random random = new Random();
	
	public GrandMere(String nom, int quantiteArgent) {
		super(nom, "tisane", quantiteArgent);
	}
	
	private String humainHasard() {
		int rand = random.nextInt(types.length);
		return types[rand].toString();
	}
	
	@Override
	protected void memoriser(Humain homme) {
		
		if (nbConnaissance<5) {
			memoire[nbConnaissance]=homme;
			nbConnaissance++;
		}
		else {
			parler("Oh ma tête ! Je ne peux plus retenir le nom d'une personne supplémentaire !");
		}

	}
	
	public void ragoter() {
		for (int i=0; i<5; i++) {
			if (memoire[i] instanceof Traitre) {
				parler("Je sais que "+memoire[i].getNom()+" est un traître. Petit chenapan !");
			}
			else {
				parler("Je crois que "+memoire[i].getNom()+" est "+humainHasard());
			}
		}
	}

}
