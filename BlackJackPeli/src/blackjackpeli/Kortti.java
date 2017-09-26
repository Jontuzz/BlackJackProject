package blackjackpeli;

public class Kortti {
    private int arvo;
    private String maa;
    
    public Kortti(int arvo, String maa) {
        this.arvo = arvo;
        this.maa = maa;
    }
    
    public int getArvo() {
        return this.arvo;
    }
    
    public String getMaa() {
        return this.maa;
    }
    
    public void setArvo(int uusiArvo) {
        this.arvo = uusiArvo;
    }
    
    public void setMaa(String uusimaa) {
        this.maa = uusimaa;
    }
    
    public String toString() {
        return maa + ", " + arvo;
    }
    
}
