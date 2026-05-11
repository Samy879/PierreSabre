package personnages;
import java.util.Random;
import java.util.random.*;

public class Traitre extends Samourai{

	private int niveauTraitrise = 0;
	
	public Traitre(String nomSeigneur, String nom, String boissonFavorite, int quantiteArgent) {
		super(nomSeigneur, nom, boissonFavorite, quantiteArgent);
	}
	
	@Override
	public void direBonjour() {
		super.direBonjour();
		parler("Mais je suis un traître et mon niveau de traîtrise est : "+niveauTraitrise+". Chut !");
	}
	
	public void faireLeGentil() {
		if (nbConnaissance<1) {
			parler("Je ne peux pas faire ami ami avec personne car je ne connais personne ! Snif.");
		}

		else {
			int don = (int)(getQuantiteArgent() * 1./20);
			
			int limite = Math.min(nbConnaissance, memoire.length);
			Random random = new Random();
			int rand = random.nextInt(limite);
			
			Humain ami = memoire[rand];
			parler("Il faut absolument remonter ma cote de confiance. Je vais faire ami ami avec "+ami.getNom()+".");
			parler("Bonjour l'ami ! Je voudrai vous aider en vous donnant "+don+" sous.");
			
			ami.gagnerArgent(don);
			perdreArgent(don);
			
			ami.parler("Merci "+getNom()+". Vous êtes quelqu'un de bien.");
			
			if (niveauTraitrise>1) {
				niveauTraitrise-=1;
			}
		}
		
	}
	
	public void ranconner(Commercant commercant) {
		if (niveauTraitrise<3) {
			int argentVictime = (int)(2./10*commercant.getQuantiteArgent());
			commercant.perdreArgent(argentVictime);
			gagnerArgent(argentVictime);
			niveauTraitrise+=1;
			
			parler("Si tu veux ma protection contre les Yakuzas, il va falloir payer ! Donne-moi "+ argentVictime+" sous ou gare à toi !");
			commercant.parler("Tout de suite grand "+ getNom());
			
		}
		else {
			parler("Mine je ne peux plus rançonner personne sinon un samouraï risque de me démasquer !");
		}
	}
}
