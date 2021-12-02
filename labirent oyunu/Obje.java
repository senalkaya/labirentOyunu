import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class Obje {

    private Image MantarFoto;
    private Image AltınFoto;
    private int Mx,My,Ax,Ay;


    public Obje(){

        ImageIcon img=new ImageIcon("C:\\Users\\Alperen\\IdeaProjects\\SirinlerProject\\src\\Image\\mantar.png");
        MantarFoto= img.getImage();
        ImageIcon img2= new ImageIcon("C:\\Users\\Alperen\\IdeaProjects\\SirinlerProject\\src\\Image\\gold.png");
        AltınFoto= img2.getImage();
        Mx=-1;
        My=-1;
        Ax=-1;
        Ay=-1;


    }

    public Image getMantarFoto() {
        return MantarFoto;
    }

    public Image getAltınFoto() {
        return AltınFoto;
    }

    public int getMx() {
        return Mx;
    }

    public int getMy() {
        return My;
    }

    public int getAx() {
        return Ax;
    }

    public int getAy() {
        return Ay;
    }

    public void MantarKonum(int x, int y){

            Mx=x;
            My=y;
        }

        public void AltınKonum(int x,int y){

        Ax=x;
        Ay=y;

        }





}
