import javax.swing.*;
import java.awt.*;

public class GozlukluSirin extends Oyuncu {

    private Image GozlukluFoto;
    private int gX,gY;

    public GozlukluSirin(String ad, String tur,int skor) {
        super(ad, tur,skor);
        ImageIcon img= new ImageIcon("C:\\Users\\Alperen\\IdeaProjects\\SirinlerProject\\src\\Image\\gozluklu.png");
        GozlukluFoto=img.getImage();
        gX=6;
        gY=5;


    }

    public Image getGozlukluFoto() {
        return GozlukluFoto;
    }

    public int getgX() {
        return gX;
    }

    public int getgY() {
        return gY;
    }

    public void setgX(int gX) {
        this.gX = gX;
    }

    public void setgY(int gY) {
        this.gY = gY;
    }

    public void Konum(int dx, int dy){

        gX+=dx;
        gY+=dy;

    }

}
