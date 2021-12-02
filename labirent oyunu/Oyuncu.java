public class Oyuncu extends Karakter {

    private int skor;

    public Oyuncu(String ad, String tur,int skor) {
        super(ad, tur);
        this.skor=skor;

    }

    public int getSkor(){


       return skor;
    }

    public void setSkor(int skor) {
        this.skor = skor;
    }
}
