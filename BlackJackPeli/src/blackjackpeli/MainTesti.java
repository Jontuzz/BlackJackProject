/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjackpeli;

/**
 *
 * @author s1601378
 */
public class MainTesti {
    public static void main(String[] args) {
        
        //kortin arvo 2-10:käden summaan lisätään kortin numeroa vastaava arvo(2 lisätään 2, 3 lisätään 3.)
        PelaajanKasi pelaajanKasi = new PelaajanKasi();
        pelaajanKasi.otaKortti(new Kortti(2, "Ruutu"));
        pelaajanKasi.otaKortti(new Kortti(5, "Risti"));
        System.out.println(pelaajanKasi.selvitaSumma()); //TOIMII 2 + 5 = 7
        System.out.println("-----------------------------");
        PelaajanKasi pelaaja11TO13 = new PelaajanKasi();
        System.out.println("-----------------------------");
        
        
        
        pelaaja11TO13.otaKortti(new Kortti(11, "Hertta"));
        pelaaja11TO13.otaKortti(new Kortti(13, "Pata"));
        System.out.println(pelaaja11TO13.selvitaSumma()); //TOIMII 11 = 10 ja 13 = 10; 10 + 10 = 20
        
        System.out.println("-----------------------------");
        PelaajanKasi assa = new PelaajanKasi();
        System.out.println("-----------------------------");
        assa.otaKortti(new Kortti(1, "Ruutu"));
        //assa.otaKortti(new Kortti(5, "Ruutu"));
        System.out.println(assa.selvitaSumma()); //1 = 11;
    }
}
