package personnages;

public class Samourai extends Ronin{

	private String nomSeigneur;
	
	public Samourai(String nomSeigneur, String nom, String boissonFavorite, int quantiteArgent) {
		super(nom, boissonFavorite, quantiteArgent);
		this.nomSeigneur = nomSeigneur;
	}
	
	@Override
	public void direBonjour() {
		super.direBonjour();
		parler("Je suis fier de servir le seigner "+nomSeigneur+".");
	}
	
	public void boire(String boisson) {
		parler("Qu'est-ce que je vais choisir comme boisson ? Tiens je vais prendre du "+boisson+".");
	}

}
