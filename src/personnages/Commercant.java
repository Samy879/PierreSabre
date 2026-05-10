package personnages;

public class Commercant extends Humain{

	public Commercant(String nom, int quantiteArgent) {
		super(nom, "thé", quantiteArgent);
	}
	
	public int seFaireExtorquer() {
		int argentPerdu = getQuantiteArgent();
		perdreArgent(argentPerdu);
		parler("J'ai tout perdu! Le monde est trop injuste...");
		return argentPerdu;
	}
	
	public void recevoir(int argent) {
		gagnerArgent(argent);
		parler(argent+" sous ! Je te remercie généreux donateur !");
	}
}
