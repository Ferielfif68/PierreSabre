
package personnages;

public class Yakuza extends Humain {

    private String clan;
    private int reputation = 0;

    public Yakuza(String nom, String boissonFavorite,
            int argent, String clan) {
        super(nom, boissonFavorite, argent);
        this.clan = clan;
    }

    public int getReputation() {
        return reputation;
    }

    public void extorquer(Commercant victime) {
        parler(victime.getNom()
                + ", si tu tiens à la vie donne moi ta bourse !");

        int sommeVolee = victime.seFaireExtorquer();

        gagnerArgent(sommeVolee);
        reputation++;

        parler("J'ai piqué les " + sommeVolee + " sous de "
                + victime.getNom() + ", ce qui me fait "
                + getArgent() + " sous dans ma poche. Hi ! Hi !");
    }

    public int perdre() {
        int sommePerdue = getArgent();

        perdreArgent(sommePerdue);
        reputation--;

        parler("J'ai perdu mon duel et mes " + sommePerdue
                + " sous, snif... J'ai déshonoré le clan de "
                + clan + ".");

        return sommePerdue;
    }

    public void gagner(int gain) {
        gagnerArgent(gain);
        reputation++;

        parler("Ce ronin pensait vraiment battre "
                + getNom() + " du clan de " + clan
                + " ? Je l'ai dépouillé de ses "
                + gain + " sous.");
    }
}
