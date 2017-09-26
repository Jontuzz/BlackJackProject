package blackjackpeli;

import java.util.ArrayList;

public class PelaajanKasi {

    private ArrayList<Kortti> kortit = new ArrayList<>();
    private int pelaajanKadenSumma;

    public boolean onkoPelaajallaBlackJack() {
        if (this.kortit.size() == 2) {
            if (this.kortit.get(0).getArvo() == 1) {
                if (this.kortit.get(1).getArvo() >= 10 && this.kortit.get(1).getArvo() <= 13) {
                    System.out.println("Joo");
                    return true;
                }
            } else if (this.kortit.get(0).getArvo() >= 10 && this.kortit.get(0).getArvo() <= 13) {
                if (this.kortit.get(1).getArvo() == 1) {
                    System.out.println("Joo");
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public void otaKortti(Kortti saatuKortti) {
        kortit.add(saatuKortti);
    }

    public int selvitaSumma() {
        for (Kortti pelaajanKortti : this.kortit) {
            //kortin arvo 2-10:	käden summaan lisätään kortin numeroa vastaava arvo(2 lisätään 2, 3 lisätään 3.)
            if (pelaajanKortti.getArvo() >= 2 && pelaajanKortti.getArvo() <= 10) {
                this.pelaajanKadenSumma += pelaajanKortti.getArvo();
            }
            //kortin arvo 11-13: käden summaan lisätään 10
            if (pelaajanKortti.getArvo() >= 11 && pelaajanKortti.getArvo() <= 13) {
                this.pelaajanKadenSumma += 10;
            }
            //kortin arvo 1 (ässä):	käden summaan lisätään 11
            if (pelaajanKortti.getArvo() == 1) {
                this.pelaajanKadenSumma += 11;
            }

            //Mikäli korttien yhteissummaksi tuli yli 21, niin vähennetään summasta 10
            //Tässä tilanteessa on saatu kaksi ässää, jolloin toisen ässän tulkitaan olevan arvoltaan 1.
            if (this.pelaajanKadenSumma > 21) {
                this.pelaajanKadenSumma -= 10;
            }
        }
        return this.pelaajanKadenSumma;
    }

    public String toString() {
        return "" + this.kortit;
    }
}
