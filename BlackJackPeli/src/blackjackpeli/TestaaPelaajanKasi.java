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
public class TestaaPelaajanKasi {
    public static void main(String[] args) {
        
        PelaajanKasi pelaajanKasi = new PelaajanKasi();
        
        //kortin arvo 2-10:	käden summaan lisätään kortin numeroa vastaava arvo(2 lisätään 2, 3 lisätään 3.)
        pelaajanKasi.otaKortti(new Kortti(2, "Pata"));
        pelaajanKasi.otaKortti(new Kortti(7, "Risti"));
        System.out.println(pelaajanKasi.selvitaSumma()); //TOIMII = 2+7=9
        
        System.out.println();
        
        //kortin arvo 11-13:	käden summaan lisätään 10
        PelaajanKasi kadenSumma10TO13 = new PelaajanKasi();
        kadenSumma10TO13.otaKortti(new Kortti(11, "Ruutu"));
        kadenSumma10TO13.otaKortti(new Kortti(12, "Hertta"));
        
        System.out.println(kadenSumma10TO13.selvitaSumma()); //TOIMIII korttien summa = 20
        
        System.out.println();
        
        PelaajanKasi assa = new PelaajanKasi();
        assa.otaKortti(new Kortti(5, "Pata"));
        assa.otaKortti(new Kortti(1, "Risti"));
        System.out.println(assa.selvitaSumma()); //TOIMII 1 = 11 + 5 = 16
        
        
        PelaajanKasi jee = new PelaajanKasi();
        jee.otaKortti(new Kortti(5, "Ruutu"));//pitäisi lisätä 5
        jee.otaKortti(new Kortti(11, "Pata"));//pitäisi lisätä 11
        
        System.out.println("Jee: " + jee.selvitaSumma());
        
        
    }
}
