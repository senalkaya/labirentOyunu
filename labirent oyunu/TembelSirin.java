import javax.swing.*;
import java.awt.*;

public class TembelSirin extends Oyuncu{

    private Image TembelFoto;
    private int tX,tY;

    public TembelSirin(String ad, String tur,int skor) {
        super(ad, tur,skor);
        ImageIcon img=new ImageIcon("C:\\Users\\Alperen\\IdeaProjects\\SirinlerProject\\src\\Image\\lazysmurf.png");
        TembelFoto=img.getImage();
        tX=6;
        tY=5;
    }

    public Image getTembelFoto() {
        return TembelFoto;
    }

    public int gettX() {
        return tX;
    }

    public int gettY() {
        return tY;
    }

    public void settX(int tX) {
        this.tX = tX;
    }

    public void settY(int tY) {
        this.tY = tY;
    }

    public void Konum(int dx, int dy){

        tX+=dx;
        tY+=dy;
    }
}
