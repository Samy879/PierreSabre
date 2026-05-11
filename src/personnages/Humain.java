package personnages;

public class Humain {
	private String nom;
	private String boissonFavorite;
	private int quantiteArgent;
	protected int nbConnaissance;
	protected Humain[] memoire = new Humain[30];
	
	public Humain(String nom, String boissonFavorite, int quantiteArgent) {
		this.nom = nom;
		this.boissonFavorite = boissonFavorite;
		this.quantiteArgent = quantiteArgent;
	}

	public int getQuantiteArgent() {
		return quantiteArgent;
	}

	public String getNom() {
		return nom;
	}
	
	protected void parler(String texte) {
		System.out.println("("+nom+") - "+texte);
	}
	
	public void direBonjour() {
		parler("Bonjour ! Je m'appelle "+nom+" et j'aime boire du "+boissonFavorite+".");
	}
	
	public void boire() {
		parler("Mmmm, un bon verre de "+boissonFavorite+" ! GLOUPS !");
	}
	
	protected void perdreArgent(int perte) {
		this.quantiteArgent-=perte;
	}
	
	protected void gagnerArgent(int gain) {
		this.quantiteArgent+=gain;
	}
	
	public void acheter(String bien, int prix) {
		if (prix<=quantiteArgent) {
			parler("J'ai "+quantiteArgent+" sous en poche. Je vais pouvoir m'offrir "+bien+" à "+prix+" sous.");
			perdreArgent(prix);
		}
		else {
			parler("Je n'ai plus que "+quantiteArgent+" sous en poche. Je ne peux même pas m'offrir "+bien+" à "+prix+" sous.");
		}
	}

	private void memoriser(Humain homme) {
		
		memoire[nbConnaissance%(memoire.length)]=homme;
		nbConnaissance++;

	}
	
	private void repondre(Humain homme) {
		direBonjour();
		memoriser(homme);
	}
	
	public void faireConnaissanceAvec(Humain autreHumain) {
		direBonjour();
		
		autreHumain.repondre(this);
		memoriser(autreHumain);
		
	}
	
	public void listerConnaissance() {
		String texte = "Je ne connais personne...";
		
		int limite = Math.min(nbConnaissance, memoire.length);
		if (nbConnaissance>0) {
			texte = "Je connais beaucoup de monde dont : ";
			for(int i=0; i<limite; i++) {
				
				texte+=memoire[i].getNom();
				if (i<limite-1) {
					texte+=", ";
				}
			}
		}
		
		parler(texte);
		
	}
	
}
