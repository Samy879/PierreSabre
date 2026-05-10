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
	
	public void provoquer(Yakuza adversaire) {
		parler("Je t'ai retrouvé vermine, tu vas payer pour ce que tu as fait à ce pauvre marchand!");
		int force = 2*honneur;
		int reputation = adversaire.getReputation();
		if (force>=reputation) {
			honneur+=1;
			parler("Je t'ai eu petit yakuza!");
			gagnerArgent(adversaire.perdre());
		}
		else {
			parler("J'ai perdu contre ce yakuza, mon honneur et ma bourse ont en pris un coup.");
			if (honneur>0) {
				honneur-=1;
			}
			int argent = getQuantiteArgent();
			adversaire.gagner(argent);
			perdreArgent(argent);
		}
	}
	
}
