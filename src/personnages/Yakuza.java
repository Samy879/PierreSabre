package personnages;

public class Yakuza extends Humain{

	private String clan;
	private int reputation = 0;
	
	public Yakuza(String nom, String boissonFavorite, int quantiteArgent, String clan) {
		super(nom, boissonFavorite, quantiteArgent);
		this.clan = clan;
	}
	
	public void extorquer(Commercant victime) {
		parler("Tiens, tiens, ne serait-ce pas un faible marchand qui passe par là ?");
		parler(victime.getNom()+", si tu tiens à la vie donne moi ta bourse !");
		int argentVole = victime.seFaireExtorquer();
		gagnerArgent(argentVole);
		this.reputation+=1;
		parler("J'ai piqué les "+argentVole+" sous de "+victime.getNom()+", ce qui me fait "+getQuantiteArgent()+" sous dans ma poche. Hi ! Hi !");
	}
	
	public int perdre() {
		int argent = getQuantiteArgent();
		perdreArgent(argent);
		
		if (reputation>0) {
			reputation-=1;
		}
		
		parler("J'ai perdu mon duel et mes "+argent+" sous, snif... J'ai déshonoré le clan de "+clan+".");
		
		return argent;
	}
	
	public void gagner(int gain) {
		reputation+=1;
		gagnerArgent(gain);
		
		parler("Ce ronin pensait vraiment battre "+getNom()+" du clan de "+clan+" ?\nJe l'ai dépouillé de ses "+gain+" sous.");
	}
	
	public int getReputation() {
		return reputation;
	}
}
