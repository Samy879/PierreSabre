package personnages;

public class Ronin extends Humain {
	private int honneur = 1;

	public Ronin(String nom, String boissonFavorite, int quantiteArgent) {
		super(nom, boissonFavorite, quantiteArgent);
	}
	
	public void donner(Commercant beneficiaire) {
		int argentDonne = (int)(0.1*getQuantiteArgent());
		parler(beneficiaire.getNom()+" prend ces "+argentDonne+" sous.");
		beneficiaire.recevoir(argentDonne);
		perdreArgent(argentDonne);
	}
}
