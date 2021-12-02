import javax.swing.*;
import java.awt.*;

public class Azman extends Dusman{

    private Image AzmanFoto;
    private int Kx,Ky;

    private int[][] harita = new int[15][12];
    public int[][] yol = new int[100][2];
    int ara = 0;


    public Azman(String ad, String tur) {

        super(ad, tur);
        ImageIcon img= new ImageIcon("C:\\Users\\Alperen\\IdeaProjects\\SirinlerProject\\src\\Image\\azman.png");
        AzmanFoto= img.getImage();

    }

    public Image getAzmanFoto() {
        return AzmanFoto;
    }

    public int getKx() {
        return Kx;
    }

    public int getKy() {
        return Ky;
    }

    public void setKx(int kx) {
        Kx = kx;
    }

    public void setKy(int ky) {
        Ky = ky;
    }

    public void Lokasyon2(int x, int y){

        Kx += x;
        Ky += y;


    }

    public void KısaYol(int AdimSayisi,int HedefX,int HedefY,Harita map) {
        for (int adim = 0; adim < AdimSayisi; adim++) {

            for (int x = 0; x < 15; x++) {
                for (int y = 0; y < 12; y++) {
                    harita[x][y] = 900;
                }
            }
            harita[getKx()][getKy()] = 0;
            YolHesap(getKx() - 1, getKy(), 1, 0,map);
            YolHesap(getKx() + 1, getKy(), 1, 0,map);
            YolHesap(getKx(), getKy() - 1, 1, 0,map);
            YolHesap(getKx(), getKy()+ 1, 1, 0,map);




            ara = harita[HedefX][HedefY];
            yol[ara][0] = HedefX;
            yol[ara][1] = HedefY;
            for (int i = ara - 1; i > -1; i--) {
                if (harita[yol[i + 1][0] + 1][yol[i + 1][1]] == i) {
                    yol[i][0] = yol[i + 1][0] + 1;
                    yol[i][1] = yol[i + 1][1];
                } else if (harita[yol[i + 1][0] - 1][yol[i + 1][1]] == i) {
                    yol[i][0] = yol[i + 1][0] - 1;
                    yol[i][1] = yol[i + 1][1];
                } else if (harita[yol[i + 1][0]][yol[i + 1][1] + 1] == i) {
                    yol[i][0] = yol[i + 1][0];
                    yol[i][1] = yol[i + 1][1] + 1;
                } else if (harita[yol[i + 1][0]][yol[i + 1][1] - 1] == i) {
                    yol[i][0] = yol[i + 1][0];
                    yol[i][1] = yol[i + 1][1] - 1;
                }
            }

            Lokasyon2(yol[1][0] - getKx(), yol[1][1] - getKy());


        }

    }

    public void YolHesap(int DegerX, int DegerY, int mesafe, int karakter, Harita m) {
        if ((DegerX > -1) && (DegerY > -1) && (DegerX < 14) && (DegerY < 11)) {
            if (karakter == 1 || karakter == 2) {
                if ((m.getDizi(DegerX, DegerY).equals("1"))  && (harita[DegerX][DegerY] > mesafe)) {
                    harita[DegerX][DegerY] = mesafe;
                    YolHesap(DegerX - 1, DegerY+0, mesafe + 1, karakter,m);
                    YolHesap(DegerX + 1, DegerY+0, mesafe + 1, karakter,m);
                    YolHesap(DegerX+0, DegerY - 1, mesafe + 1, karakter,m);
                    YolHesap(DegerX+0, DegerY + 1, mesafe + 1, karakter,m);
                }

            }
            if (karakter == 0) { //darth vader
                if (harita[DegerX][DegerY] > mesafe) {
                    harita[DegerX][DegerY] = mesafe;
                    YolHesap(DegerX - 1, DegerY+0, mesafe + 1, karakter,m);
                    YolHesap(DegerX + 1, DegerY+0, mesafe + 1, karakter,m);
                    YolHesap(DegerX+0, DegerY - 1, mesafe + 1, karakter,m);
                    YolHesap(DegerX+0, DegerY + 1, mesafe + 1, karakter,m);
                }

            }

        }

    }


}
