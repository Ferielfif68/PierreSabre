
package personnages;

public class Ronin extends Humain {

    private int honneur = 1;

    public Ronin(String nom, String boissonFavorite, int argent) {
        super(nom, boissonFavorite, argent);
    }

    public void donner(Commercant beneficiaire) {
        int don = getArgent() / 10;

        perdreArgent(don);

        parler(beneficiaire.getNom() + " prend ces "
                + don + " sous.");

        beneficiaire.recevoir(don);
    }

    public void provoquer(Yakuza adversaire) {
        int force = honneur * 2;

        if (force >= adversaire.getReputation()) {
            honneur++;

            parler("Je t'ai eu petit yakusa!");

            int gain = adversaire.perdre();
            gagnerArgent(gain);

        } else {
            honneur--;

            int perte = getArgent();
            perdreArgent(perte);

            parler("J'ai perdu contre ce yakuza, mon honneur "
                    + "et ma bourse ont en pris un coup.");

            adversaire.gagner(perte);
        }
    }
}

