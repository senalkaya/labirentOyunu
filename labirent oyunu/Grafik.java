import javax.management.StringValueExp;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import java.util.TimerTask;

public class Grafik extends JPanel implements ActionListener {

    private Timer timer;
    public Harita harita;
    public GozlukluSirin GozlukluSirin;
    public TembelSirin TembelSirin;
    public Gargamel Gargamel;
    public Azman Azman;
    public Obje Obje;
    public int sayac=0;
    private int puan=0;
    public JTextField skortext;
    public String kontrol;
    public String kontrol2;
    int abc=0;
    int cba=0;

    private String Mesaj = "KAZANDINIZ";
    private String Mesaj2="KAYBETTİNİZ";
    private Font font = new Font("Serif", Font.CENTER_BASELINE, 60);
    private Font font2= new Font("a",Font.BOLD,30);








    public Grafik(){

        setLayout(null);
        harita= new Harita();
        GozlukluSirin= new GozlukluSirin("GozlukluSirin","Oyuncu",20);
        TembelSirin= new TembelSirin("TembelSirin","Oyuncu",20);
        addKeyListener(new Hareket());
        setFocusable(true);
        timer = new Timer(10, this);
        timer.start();
        Obje= new Obje();
        MantarSure();
        AltınSure();
        skortext= new JTextField();
        skortext.setFont(font2);
        skortext.setBounds(285,650,100,50);
        skortext.setText(String.valueOf(GozlukluSirin.getSkor()));
        add(skortext);
        Gargamel= new Gargamel("Gargamel","Dusman");
        Azman= new Azman("Azman","Dusman");







    }
    public void actionPerformed(ActionEvent e) {


        repaint();
    }

    public void paint(Graphics g){

        super.paint(g);

        int a = 0;
        int b = 50;

        for (int j = 0; j < 11; j++) {

            b=0;

            for (int i = 0; i <= harita.dizi[j].length() - 1; i++) {

                if (harita.dizi[j].charAt(i) == '0') {

                    g.setColor(Color.GRAY);
                    g.fillRect(i*50, j*50, 50, 50);
                }
                else if (harita.dizi[j].charAt(i) == '1') {

                    g.drawRect(i*50, j*50, 50, 50);

                }

                for (int h = 1; h < Gargamel.ara; h++) {
                    if (Gargamel.yol[h][0] == i && Gargamel.yol[h][1] == j) {
                        g.setColor(Color.RED);
                        g.fillRect(50 * i, 50 * j, 50, 50);
                    }
                }

               for (int h = 1; h < Azman.ara; h++) {
                    if (Azman.yol[h][0] == i && Azman.yol[h][1] == j) {
                        g.setColor(Color.BLUE);
                        g.fillRect(50 * i, 50 * j, 50, 50);
                    }
                }







                b += 50;

            }
            a+=50;

        }

//GİRİŞLER

        //Gözlüklü



       if (harita.dizi[11].contains("ö")){

            g.drawImage(GozlukluSirin.getGozlukluFoto(),GozlukluSirin.getgX()*50,GozlukluSirin.getgY()*50,50,50,null);
        }

        //Tembel


        if (harita.dizi[11].contains("m")){

            g.drawImage(TembelSirin.getTembelFoto(),TembelSirin.gettX()*50,TembelSirin.gettY()*50,50,50,null);
        }




        //Gargamel

          if (harita.dizi[12].contains("g")&&harita.dizi[12].contains("A")&& abc==0){
              Gargamel.Lokasyon(3,0);
            kontrol="A";
            abc++;
        }
        if (harita.dizi[12].contains("g")&&harita.dizi[12].contains("B")&& abc==0){
            Gargamel.Lokasyon(10,0);
            kontrol="B";
            abc++;

        }
        if (harita.dizi[12].contains("g")&&harita.dizi[12].contains("C")&& abc==0){
            Gargamel.Lokasyon(0,5);
            kontrol="C";
            abc++;

        }
        if (harita.dizi[12].contains("g")&&harita.dizi[12].contains("D")&& abc==0){
            Gargamel.Lokasyon(3,10);
            kontrol="D";
            abc++;

        }



        g.drawImage(Gargamel.getGargamelFoto(),Gargamel.getGx()*50,Gargamel.getGy()*50,50,50,null);


        //Azman

        if (harita.dizi[13].contains("z")&&harita.dizi[13].contains("A")&& cba==0){
            Azman.Lokasyon2(3,0);
            kontrol2="A";
            cba++;
        }
        if (harita.dizi[13].contains("z")&&harita.dizi[13].contains("B")&& cba==0){
            Azman.Lokasyon2(10,0);
            kontrol2="B";
            cba++;

        }
        if (harita.dizi[13].contains("z")&&harita.dizi[13].contains("C")&& cba==0){
            Azman.Lokasyon2(0,5);
            kontrol2="C";
            cba++;

        }
        if (harita.dizi[13].contains("z")&&harita.dizi[13].contains("D")&& cba==0){
            Azman.Lokasyon2(3,10);
            kontrol2="D";
            cba++;

        }

        g.drawImage(Azman.getAzmanFoto(),Azman.getKx()*50,Azman.getKy()*50,50,50,null);










        //Altın Mantar
        g.drawImage(Obje.getMantarFoto(),Obje.getMx()*50,Obje.getMy()*50,50,50,null);
        g.drawImage(Obje.getAltınFoto(),Obje.getAx()*50,Obje.getAy()*50,50,50,null);

        if (GozlukluSirin.getgX()==12 && GozlukluSirin.getgY()==7 || TembelSirin.gettX()==12 && TembelSirin.gettY()==7){
            g.setColor(Color.GREEN);
            g.setFont(font);
            g.drawString(Mesaj,150,220);
            setEnabled(false);

        }

        if (GozlukluSirin.getSkor()<=0 || TembelSirin.getSkor()<=0){

            g.setColor(Color.GREEN);
            g.setFont(font);
            g.drawString(Mesaj2,150,220);
            setEnabled(false);


        }


    }







    public class Hareket extends KeyAdapter {

        public void keyPressed(KeyEvent e) {
            int keycode = e.getKeyCode();
            if (keycode == KeyEvent.VK_W) {

                if (!harita.getDizi(GozlukluSirin.getgX(), GozlukluSirin.getgY()- 1).equals("0")&&!harita.getDizi(GozlukluSirin.getgX(), GozlukluSirin.getgY()- 2).equals("0")&& GozlukluSirin.getgY() > 0 ){
                    GozlukluSirin.Konum(0, -2);
                    Gargamel.KısaYol(2,GozlukluSirin.getgX(),GozlukluSirin.getgY(),harita);
                    Azman.KısaYol(1,GozlukluSirin.getgX(),GozlukluSirin.getgY(),harita);

                }


                if(GozlukluSirin.getgX()==Obje.getAx()&&GozlukluSirin.getgY()==Obje.getAy() ||GozlukluSirin.getgX()==Obje.getAx()&&GozlukluSirin.getgY()+1==Obje.getAy() ) {

                    GozlukluSirin.setSkor(GozlukluSirin.getSkor()+5);
                    skortext.setText(String.valueOf(GozlukluSirin.getSkor()));
                    System.out.println(skortext.getText());
                    Obje.AltınKonum(-1,-1);

                }

                if(GozlukluSirin.getgX()==Obje.getMx()&&GozlukluSirin.getgY()==Obje.getMy()||GozlukluSirin.getgX()==Obje.getMx()&&GozlukluSirin.getgY()+1==Obje.getMy()) {

                    GozlukluSirin.setSkor(GozlukluSirin.getSkor()+50);
                    skortext.setText(String.valueOf(GozlukluSirin.getSkor()));
                    System.out.println(skortext.getText());
                    Obje.MantarKonum(-1,-1);

                }


                if(GozlukluSirin.getgX()==Gargamel.getGx()&&GozlukluSirin.getgY()==Gargamel.getGy()) {

                    GozlukluSirin.setSkor(GozlukluSirin.getSkor()-15);
                    skortext.setText(String.valueOf(GozlukluSirin.getSkor()));
                    System.out.println(skortext.getText());

                    if (kontrol.matches("A")) {
                        Gargamel.setGx(3);
                        Gargamel.setGy(0);
                        GozlukluSirin.setgX(6);
                        GozlukluSirin.setgY(5);
                    }

                    else if (kontrol.matches("B")) {
                        Gargamel.setGx(10);
                        Gargamel.setGy(0);
                        GozlukluSirin.setgX(6);
                        GozlukluSirin.setgY(5);
                    }
                    else if (kontrol.matches("C")) {
                        Gargamel.setGx(0);
                        Gargamel.setGy(5);
                        GozlukluSirin.setgX(6);
                        GozlukluSirin.setgY(5);
                    }
                    else if (kontrol.matches("D")) {
                        Gargamel.setGx(3);
                        Gargamel.setGy(10);
                        GozlukluSirin.setgX(6);
                        GozlukluSirin.setgY(5);
                    }
                }

                if(GozlukluSirin.getgX()==Azman.getKx()&&GozlukluSirin.getgY()==Azman.getKy()) {

                    GozlukluSirin.setSkor(GozlukluSirin.getSkor()-5);
                    skortext.setText(String.valueOf(GozlukluSirin.getSkor()));
                    System.out.println(skortext.getText());

                    if (kontrol2.matches("A")) {
                        Azman.setKx(3);
                        Azman.setKy(0);
                        GozlukluSirin.setgX(6);
                        GozlukluSirin.setgY(5);
                    }

                    else if (kontrol2.matches("B")) {
                        Azman.setKx(10);
                        Azman.setKy(0);
                        GozlukluSirin.setgX(6);
                        GozlukluSirin.setgY(5);
                    }
                    else if (kontrol2.matches("C")) {
                        Azman.setKx(0);
                        Azman.setKy(5);
                        GozlukluSirin.setgX(6);
                        GozlukluSirin.setgY(5);
                    }
                    else if (kontrol2.matches("D")) {
                        Azman.setKx(3);
                        Azman.setKy(10);
                        GozlukluSirin.setgX(6);
                        GozlukluSirin.setgY(5);
                    }
                }




            }
            if (keycode == KeyEvent.VK_D) {

                if (!harita.getDizi(GozlukluSirin.getgX()+1, GozlukluSirin.getgY()).equals("0")&&!harita.getDizi(GozlukluSirin.getgX()+2, GozlukluSirin.getgY()).equals("0")&& GozlukluSirin.getgY() < 14 ){
                    GozlukluSirin.Konum(2, 0);
                    Gargamel.KısaYol(2,GozlukluSirin.getgX(),GozlukluSirin.getgY(),harita);
                    Azman.KısaYol(1,GozlukluSirin.getgX(),GozlukluSirin.getgY(),harita);
                }

                if(GozlukluSirin.getgX()==Obje.getAx() && GozlukluSirin.getgY()==Obje.getAy()||GozlukluSirin.getgX()-1==Obje.getAx()&&GozlukluSirin.getgY()==Obje.getAy()) {

                    GozlukluSirin.setSkor(GozlukluSirin.getSkor()+5);
                    skortext.setText(String.valueOf(GozlukluSirin.getSkor()));
                    System.out.println(skortext.getText());
                    Obje.AltınKonum(-1,-1);
                }

                if(GozlukluSirin.getgX()==Obje.getMx()&&GozlukluSirin.getgY()==Obje.getMy()||GozlukluSirin.getgX()-1==Obje.getMx()&&GozlukluSirin.getgY()==Obje.getMy()) {

                    GozlukluSirin.setSkor(GozlukluSirin.getSkor()+50);
                    skortext.setText(String.valueOf(GozlukluSirin.getSkor()));
                    System.out.println(skortext.getText());
                    Obje.MantarKonum(-1,-1);

                }

                if(GozlukluSirin.getgX()==Gargamel.getGx()&&GozlukluSirin.getgY()==Gargamel.getGy()) {

                    GozlukluSirin.setSkor(GozlukluSirin.getSkor()-15);
                    skortext.setText(String.valueOf(GozlukluSirin.getSkor()));
                    System.out.println(skortext.getText());


                    if (kontrol.matches("A")) {
                        Gargamel.setGx(3);
                        Gargamel.setGy(0);
                        GozlukluSirin.setgX(6);
                        GozlukluSirin.setgY(5);
                    }

                    else if (kontrol.matches("B")) {
                        Gargamel.setGx(10);
                        Gargamel.setGy(0);
                        GozlukluSirin.setgX(6);
                        GozlukluSirin.setgY(5);
                    }
                   else if (kontrol.matches("C")) {
                        Gargamel.setGx(0);
                        Gargamel.setGy(5);
                        GozlukluSirin.setgX(6);
                        GozlukluSirin.setgY(5);
                    }
                   else if (kontrol.matches("D")) {
                        Gargamel.setGx(3);
                        Gargamel.setGy(10);
                        GozlukluSirin.setgX(6);
                        GozlukluSirin.setgY(5);
                    }
                }

                if(GozlukluSirin.getgX()==Azman.getKx()&&GozlukluSirin.getgY()==Azman.getKy()) {

                    GozlukluSirin.setSkor(GozlukluSirin.getSkor()-5);
                    skortext.setText(String.valueOf(GozlukluSirin.getSkor()));
                    System.out.println(skortext.getText());

                    if (kontrol2.matches("A")) {
                        Azman.setKx(3);
                        Azman.setKy(0);
                        GozlukluSirin.setgX(6);
                        GozlukluSirin.setgY(5);
                    }

                    else if (kontrol2.matches("B")) {
                        Azman.setKx(10);
                        Azman.setKy(0);
                        GozlukluSirin.setgX(6);
                        GozlukluSirin.setgY(5);
                    }
                    else if (kontrol2.matches("C")) {
                        Azman.setKx(0);
                        Azman.setKy(5);
                        GozlukluSirin.setgX(6);
                        GozlukluSirin.setgY(5);
                    }
                    else if (kontrol2.matches("D")) {
                        Azman.setKx(3);
                        Azman.setKy(10);
                        GozlukluSirin.setgX(6);
                        GozlukluSirin.setgY(5);
                    }
                }

            }




            if (keycode == KeyEvent.VK_S) {

                if (!harita.getDizi(GozlukluSirin.getgX(), GozlukluSirin.getgY()+1).equals("0")&&!harita.getDizi(GozlukluSirin.getgX(), GozlukluSirin.getgY()+2).equals("0")&& GozlukluSirin.getgY() < 12 ){
                    GozlukluSirin.Konum(0, 2);
                    Gargamel.KısaYol(2,GozlukluSirin.getgX(),GozlukluSirin.getgY(),harita);
                    Azman.KısaYol(1,GozlukluSirin.getgX(),GozlukluSirin.getgY(),harita);
                }


                if(GozlukluSirin.getgX()==Obje.getAx()&&GozlukluSirin.getgY()==Obje.getAy()||GozlukluSirin.getgX()==Obje.getAx()&&GozlukluSirin.getgY()-1==Obje.getAy()) {

                    GozlukluSirin.setSkor(GozlukluSirin.getSkor()+5);
                    skortext.setText(String.valueOf(GozlukluSirin.getSkor()));
                    System.out.println(skortext.getText());
                    Obje.AltınKonum(-1,-1);
                }

                if(GozlukluSirin.getgX()==Obje.getMx()&&GozlukluSirin.getgY()==Obje.getMy()||GozlukluSirin.getgX()==Obje.getMx()&&GozlukluSirin.getgY()-1==Obje.getMy()) {

                    GozlukluSirin.setSkor(GozlukluSirin.getSkor()+50);
                    skortext.setText(String.valueOf(GozlukluSirin.getSkor()));
                    System.out.println(skortext.getText());
                    Obje.MantarKonum(-1,-1);

                }

                if(GozlukluSirin.getgX()==Gargamel.getGx()&&GozlukluSirin.getgY()==Gargamel.getGy()) {

                    GozlukluSirin.setSkor(GozlukluSirin.getSkor()-15);
                    skortext.setText(String.valueOf(GozlukluSirin.getSkor()));
                    System.out.println(skortext.getText());


                    if (kontrol.matches("A")) {
                        Gargamel.setGx(3);
                        Gargamel.setGy(0);
                        GozlukluSirin.setgX(6);
                        GozlukluSirin.setgY(5);
                    }

                    else if (kontrol.matches("B")) {
                        Gargamel.setGx(10);
                        Gargamel.setGy(0);
                        GozlukluSirin.setgX(6);
                        GozlukluSirin.setgY(5);
                    }
                    else if (kontrol.matches("C")) {
                        Gargamel.setGx(0);
                        Gargamel.setGy(5);
                        GozlukluSirin.setgX(6);
                        GozlukluSirin.setgY(5);
                    }
                    else if (kontrol.matches("D")) {
                        Gargamel.setGx(3);
                        Gargamel.setGy(10);
                        GozlukluSirin.setgX(6);
                        GozlukluSirin.setgY(5);
                    }
                }

                if(GozlukluSirin.getgX()==Azman.getKx()&&GozlukluSirin.getgY()==Azman.getKy()) {

                    GozlukluSirin.setSkor(GozlukluSirin.getSkor()-5);
                    skortext.setText(String.valueOf(GozlukluSirin.getSkor()));
                    System.out.println(skortext.getText());

                    if (kontrol2.matches("A")) {
                        Azman.setKx(3);
                        Azman.setKy(0);
                        GozlukluSirin.setgX(6);
                        GozlukluSirin.setgY(5);
                    }

                    else if (kontrol2.matches("B")) {
                        Azman.setKx(10);
                        Azman.setKy(0);
                        GozlukluSirin.setgX(6);
                        GozlukluSirin.setgY(5);
                    }
                    else if (kontrol2.matches("C")) {
                        Azman.setKx(0);
                        Azman.setKy(5);
                        GozlukluSirin.setgX(6);
                        GozlukluSirin.setgY(5);
                    }
                    else if (kontrol2.matches("D")) {
                        Azman.setKx(3);
                        Azman.setKy(10);
                        GozlukluSirin.setgX(6);
                        GozlukluSirin.setgY(5);
                    }
                }

            }



            if (keycode == KeyEvent.VK_A) {

                if (!harita.getDizi(GozlukluSirin.getgX()-1, GozlukluSirin.getgY()).equals("0")&&!harita.getDizi(GozlukluSirin.getgX()-2, GozlukluSirin.getgY()).equals("0")&& GozlukluSirin.getgY() > 0  ) {
                    GozlukluSirin.Konum(-2, 0);
                    Gargamel.KısaYol(2,GozlukluSirin.getgX(),GozlukluSirin.getgY(),harita);
                    Azman.KısaYol(1,GozlukluSirin.getgX(),GozlukluSirin.getgY(),harita);
                }


                if(GozlukluSirin.getgX()==Obje.getAx()&&GozlukluSirin.getgY()==Obje.getAy()||GozlukluSirin.getgX()+1==Obje.getAx()&&GozlukluSirin.getgY()==Obje.getAy()) {

                    GozlukluSirin.setSkor(GozlukluSirin.getSkor()+5);
                    skortext.setText(String.valueOf(GozlukluSirin.getSkor()));
                    System.out.println(skortext.getText());
                    Obje.AltınKonum(-1,-1);
                }

                if(GozlukluSirin.getgX()==Obje.getMx()&&GozlukluSirin.getgY()==Obje.getMy()||GozlukluSirin.getgX()+1==Obje.getMx()&&GozlukluSirin.getgY()==Obje.getMy()) {

                    GozlukluSirin.setSkor(GozlukluSirin.getSkor()+50);
                    skortext.setText(String.valueOf(GozlukluSirin.getSkor()));
                    System.out.println(skortext.getText());
                    Obje.MantarKonum(-1,-1);

                }

                if(GozlukluSirin.getgX()==Gargamel.getGx()&&GozlukluSirin.getgY()==Gargamel.getGy()) {

                    GozlukluSirin.setSkor(GozlukluSirin.getSkor()-15);
                    skortext.setText(String.valueOf(GozlukluSirin.getSkor()));
                    System.out.println(skortext.getText());


                    if (kontrol.matches("A")) {
                        Gargamel.setGx(3);
                        Gargamel.setGy(0);
                        GozlukluSirin.setgX(6);
                        GozlukluSirin.setgY(5);
                    }

                    else if (kontrol.matches("B")) {
                        Gargamel.setGx(10);
                        Gargamel.setGy(0);
                        GozlukluSirin.setgX(6);
                        GozlukluSirin.setgY(5);
                    }
                    else if (kontrol.matches("C")) {
                        Gargamel.setGx(0);
                        Gargamel.setGy(5);
                        GozlukluSirin.setgX(6);
                        GozlukluSirin.setgY(5);
                    }
                    else if (kontrol.matches("D")) {
                        Gargamel.setGx(3);
                        Gargamel.setGy(10);
                        GozlukluSirin.setgX(6);
                        GozlukluSirin.setgY(5);
                    }
                }

                if(GozlukluSirin.getgX()==Azman.getKx()&&GozlukluSirin.getgY()==Azman.getKy()) {

                    GozlukluSirin.setSkor(GozlukluSirin.getSkor()-5);
                    skortext.setText(String.valueOf(GozlukluSirin.getSkor()));
                    System.out.println(skortext.getText());

                    if (kontrol2.matches("A")) {
                        Azman.setKx(3);
                        Azman.setKy(0);
                        GozlukluSirin.setgX(6);
                        GozlukluSirin.setgY(5);
                    }

                    else if (kontrol2.matches("B")) {
                        Azman.setKx(10);
                        Azman.setKy(0);
                        GozlukluSirin.setgX(6);
                        GozlukluSirin.setgY(5);
                    }
                    else if (kontrol2.matches("C")) {
                        Azman.setKx(0);
                        Azman.setKy(5);
                        GozlukluSirin.setgX(6);
                        GozlukluSirin.setgY(5);
                    }
                    else if (kontrol2.matches("D")) {
                        Azman.setKx(3);
                        Azman.setKy(10);
                        GozlukluSirin.setgX(6);
                        GozlukluSirin.setgY(5);
                    }
                }

            }



            //TEMBEL HAREKET




            if (keycode == KeyEvent.VK_UP) {

                if (!harita.getDizi(TembelSirin.gettX(), TembelSirin.gettY()-1).equals("0")) {
                    TembelSirin.Konum(0, -1);
                    Gargamel.KısaYol(2, TembelSirin.gettX(), TembelSirin.gettY(), harita);
                    Azman.KısaYol(1,GozlukluSirin.getgX(),GozlukluSirin.getgY(),harita);
                }
                if(TembelSirin.gettX()==Obje.getAx()&&TembelSirin.gettY()==Obje.getAy()) {

                    GozlukluSirin.setSkor(TembelSirin.getSkor()+5);
                    skortext.setText(String.valueOf(TembelSirin.getSkor()));
                    System.out.println(skortext.getText());
                    Obje.AltınKonum(-1,-1);

                }

                if(TembelSirin.gettX()==Obje.getMx()&&TembelSirin.gettY()==Obje.getMy()) {

                    TembelSirin.setSkor(TembelSirin.getSkor()+50);
                    skortext.setText(String.valueOf(TembelSirin.getSkor()));
                    System.out.println(skortext.getText());
                    Obje.MantarKonum(-1,-1);

                }


                if(TembelSirin.gettX()==Gargamel.getGx()&&TembelSirin.gettY()==Gargamel.getGy()) {

                    TembelSirin.setSkor(TembelSirin.getSkor()-15);
                    skortext.setText(String.valueOf(TembelSirin.getSkor()));
                    System.out.println(skortext.getText());

                    if (kontrol.matches("A")) {
                        Gargamel.setGx(3);
                        Gargamel.setGy(0);
                        TembelSirin.settX(6);
                        TembelSirin.settY(5);
                    }

                    else if (kontrol.matches("B")) {
                        Gargamel.setGx(10);
                        Gargamel.setGy(0);
                        TembelSirin.settX(6);
                        TembelSirin.settY(5);
                    }
                    else if (kontrol.matches("C")) {
                        Gargamel.setGx(0);
                        Gargamel.setGy(5);
                        TembelSirin.settX(6);
                        TembelSirin.settY(5);
                    }
                    else if (kontrol.matches("D")) {
                        Gargamel.setGx(3);
                        Gargamel.setGy(10);
                        TembelSirin.settX(6);
                        TembelSirin.settY(5);
                    }
                }

                if(TembelSirin.gettX()==Azman.getKx()&&TembelSirin.gettY()==Azman.getKy()) {

                    TembelSirin.setSkor(TembelSirin.getSkor()-5);
                    skortext.setText(String.valueOf(TembelSirin.getSkor()));
                    System.out.println(skortext.getText());

                    if (kontrol2.matches("A")) {
                        Azman.setKx(3);
                        Azman.setKy(0);
                        TembelSirin.settX(6);
                        TembelSirin.settY(5);
                    }

                    else if (kontrol2.matches("B")) {
                        Azman.setKx(10);
                        Azman.setKy(0);
                        TembelSirin.settX(6);
                        TembelSirin.settY(5);
                    }
                    else if (kontrol2.matches("C")) {
                        Azman.setKx(0);
                        Azman.setKy(5);
                        TembelSirin.settX(6);
                        TembelSirin.settY(5);
                    }
                    else if (kontrol2.matches("D")) {
                        Azman.setKx(3);
                        Azman.setKy(10);
                        TembelSirin.settX(6);
                        TembelSirin.settY(5);
                    }
                }

            }
            if (keycode == KeyEvent.VK_RIGHT) {

                if (!harita.getDizi(TembelSirin.gettX()+1, TembelSirin.gettY()).equals("0")) {
                    TembelSirin.Konum(1, 0);
                    Gargamel.KısaYol(2, TembelSirin.gettX(), TembelSirin.gettY(), harita);
                    Azman.KısaYol(1,GozlukluSirin.getgX(),GozlukluSirin.getgY(),harita);
                }

                if(TembelSirin.gettX()==Obje.getAx()&&TembelSirin.gettY()==Obje.getAy()) {

                    GozlukluSirin.setSkor(TembelSirin.getSkor()+5);
                    skortext.setText(String.valueOf(TembelSirin.getSkor()));
                    System.out.println(skortext.getText());
                    Obje.AltınKonum(-1,-1);

                }

                if(TembelSirin.gettX()==Obje.getMx()&&TembelSirin.gettY()==Obje.getMy()) {

                    TembelSirin.setSkor(TembelSirin.getSkor()+50);
                    skortext.setText(String.valueOf(TembelSirin.getSkor()));
                    System.out.println(skortext.getText());
                    Obje.MantarKonum(-1,-1);

                }


                if(TembelSirin.gettX()==Gargamel.getGx()&&TembelSirin.gettY()==Gargamel.getGy()) {

                    TembelSirin.setSkor(TembelSirin.getSkor()-15);
                    skortext.setText(String.valueOf(TembelSirin.getSkor()));
                    System.out.println(skortext.getText());

                    if (kontrol.matches("A")) {
                        Gargamel.setGx(3);
                        Gargamel.setGy(0);
                        TembelSirin.settX(6);
                        TembelSirin.settY(5);
                    }

                    else if (kontrol.matches("B")) {
                        Gargamel.setGx(10);
                        Gargamel.setGy(0);
                        TembelSirin.settX(6);
                        TembelSirin.settY(5);
                    }
                    else if (kontrol.matches("C")) {
                        Gargamel.setGx(0);
                        Gargamel.setGy(5);
                        TembelSirin.settX(6);
                        TembelSirin.settY(5);
                    }
                    else if (kontrol.matches("D")) {
                        Gargamel.setGx(3);
                        Gargamel.setGy(10);
                        TembelSirin.settX(6);
                        TembelSirin.settY(5);
                    }
                }

                if(TembelSirin.gettX()==Azman.getKx()&&TembelSirin.gettY()==Azman.getKy()) {

                    TembelSirin.setSkor(TembelSirin.getSkor()-5);
                    skortext.setText(String.valueOf(TembelSirin.getSkor()));
                    System.out.println(skortext.getText());

                    if (kontrol2.matches("A")) {
                        Azman.setKx(3);
                        Azman.setKy(0);
                        TembelSirin.settX(6);
                        TembelSirin.settY(5);
                    }

                    else if (kontrol2.matches("B")) {
                        Azman.setKx(10);
                        Azman.setKy(0);
                        TembelSirin.settX(6);
                        TembelSirin.settY(5);
                    }
                    else if (kontrol2.matches("C")) {
                        Azman.setKx(0);
                        Azman.setKy(5);
                        TembelSirin.settX(6);
                        TembelSirin.settY(5);
                    }
                    else if (kontrol2.matches("D")) {
                        Azman.setKx(3);
                        Azman.setKy(10);
                        TembelSirin.settX(6);
                        TembelSirin.settY(5);
                    }
                }
            }
            if (keycode == KeyEvent.VK_DOWN) {

                if (!harita.getDizi(TembelSirin.gettX(), TembelSirin.gettY()+1).equals("0")) {
                    TembelSirin.Konum(0, 1);
                    Gargamel.KısaYol(2, TembelSirin.gettX(), TembelSirin.gettY(), harita);
                    Azman.KısaYol(1,GozlukluSirin.getgX(),GozlukluSirin.getgY(),harita);
                }
                if(TembelSirin.gettX()==Obje.getAx()&&TembelSirin.gettY()==Obje.getAy()) {

                    TembelSirin.setSkor(TembelSirin.getSkor()+5);
                    skortext.setText(String.valueOf(TembelSirin.getSkor()));
                    System.out.println(skortext.getText());
                    Obje.AltınKonum(-1,-1);
                }

                if(TembelSirin.gettX()==Obje.getMx()&&TembelSirin.gettY()==Obje.getMy()) {

                    TembelSirin.setSkor(TembelSirin.getSkor()+50);
                    skortext.setText(String.valueOf(TembelSirin.getSkor()));
                    System.out.println(skortext.getText());
                    Obje.MantarKonum(-1,-1);

                }

                if(TembelSirin.gettX()==Gargamel.getGx()&&TembelSirin.gettY()==Gargamel.getGy()) {

                    TembelSirin.setSkor(TembelSirin.getSkor()-15);
                    skortext.setText(String.valueOf(TembelSirin.getSkor()));
                    System.out.println(skortext.getText());

                    if (kontrol.matches("A")) {
                        Gargamel.setGx(3);
                        Gargamel.setGy(0);
                        TembelSirin.settX(6);
                        TembelSirin.settY(5);
                    }

                    else if (kontrol.matches("B")) {
                        Gargamel.setGx(10);
                        Gargamel.setGy(0);
                        TembelSirin.settX(6);
                        TembelSirin.settY(5);
                    }
                    else if (kontrol.matches("C")) {
                        Gargamel.setGx(0);
                        Gargamel.setGy(5);
                        TembelSirin.settX(6);
                        TembelSirin.settY(5);
                    }
                    else if (kontrol.matches("D")) {
                        Gargamel.setGx(3);
                        Gargamel.setGy(10);
                        TembelSirin.settX(6);
                        TembelSirin.settY(5);
                    }
                }

                if(TembelSirin.gettX()==Azman.getKx()&&TembelSirin.gettY()==Azman.getKy()) {

                    TembelSirin.setSkor(TembelSirin.getSkor()-5);
                    skortext.setText(String.valueOf(TembelSirin.getSkor()));
                    System.out.println(skortext.getText());

                    if (kontrol2.matches("A")) {
                        Azman.setKx(3);
                        Azman.setKy(0);
                        TembelSirin.settX(6);
                        TembelSirin.settY(5);
                    }

                    else if (kontrol2.matches("B")) {
                        Azman.setKx(10);
                        Azman.setKy(0);
                        TembelSirin.settX(6);
                        TembelSirin.settY(5);
                    }
                    else if (kontrol2.matches("C")) {
                        Azman.setKx(0);
                        Azman.setKy(5);
                        TembelSirin.settX(6);
                        TembelSirin.settY(5);
                    }
                    else if (kontrol2.matches("D")) {
                        Azman.setKx(3);
                        Azman.setKy(10);
                        TembelSirin.settX(6);
                        TembelSirin.settY(5);
                    }
                }

            }
            if (keycode == KeyEvent.VK_LEFT) {

                if (!harita.getDizi(TembelSirin.gettX()-1, TembelSirin.gettY()).equals("0")) {
                    TembelSirin.Konum(-1, 0);
                    Gargamel.KısaYol(2, TembelSirin.gettX(), TembelSirin.gettY(), harita);
                    Azman.KısaYol(1,GozlukluSirin.getgX(),GozlukluSirin.getgY(),harita);
                }

                if(TembelSirin.gettX()==Obje.getAx()&&TembelSirin.gettY()==Obje.getAy()) {

                    TembelSirin.setSkor(TembelSirin.getSkor()+5);
                    skortext.setText(String.valueOf(TembelSirin.getSkor()));
                    System.out.println(skortext.getText());
                    Obje.AltınKonum(-1,-1);
                }

                if(TembelSirin.gettX()==Obje.getMx()&&TembelSirin.gettY()==Obje.getMy()) {

                    TembelSirin.setSkor(TembelSirin.getSkor()+50);
                    skortext.setText(String.valueOf(TembelSirin.getSkor()));
                    System.out.println(skortext.getText());
                    Obje.MantarKonum(-1,-1);

                }

                if(TembelSirin.gettX()==Gargamel.getGx()&&TembelSirin.gettY()==Gargamel.getGy()) {

                    TembelSirin.setSkor(TembelSirin.getSkor()-15);
                    skortext.setText(String.valueOf(TembelSirin.getSkor()));
                    System.out.println(skortext.getText());

                    if (kontrol.matches("A")) {
                        Gargamel.setGx(3);
                        Gargamel.setGy(0);
                        TembelSirin.settX(6);
                        TembelSirin.settY(5);
                    }

                    else if (kontrol.matches("B")) {
                        Gargamel.setGx(10);
                        Gargamel.setGy(0);
                        TembelSirin.settX(6);
                        TembelSirin.settY(5);
                    }
                    else if (kontrol.matches("C")) {
                        Gargamel.setGx(0);
                        Gargamel.setGy(5);
                        TembelSirin.settX(6);
                        TembelSirin.settY(5);
                    }
                    else if (kontrol.matches("D")) {
                        Gargamel.setGx(3);
                        Gargamel.setGy(10);
                        TembelSirin.settX(6);
                        TembelSirin.settY(5);
                    }
                }

                if(TembelSirin.gettX()==Azman.getKx()&&TembelSirin.gettY()==Azman.getKy()) {

                    TembelSirin.setSkor(TembelSirin.getSkor()-5);
                    skortext.setText(String.valueOf(TembelSirin.getSkor()));
                    System.out.println(skortext.getText());

                    if (kontrol2.matches("A")) {
                        Azman.setKx(3);
                        Azman.setKy(0);
                        TembelSirin.settX(6);
                        TembelSirin.settY(5);
                    }

                    else if (kontrol2.matches("B")) {
                        Azman.setKx(10);
                        Azman.setKy(0);
                        TembelSirin.settX(6);
                        TembelSirin.settY(5);
                    }
                    else if (kontrol2.matches("C")) {
                        Azman.setKx(0);
                        Azman.setKy(5);
                        TembelSirin.settX(6);
                        TembelSirin.settY(5);
                    }
                    else if (kontrol2.matches("D")) {
                        Azman.setKx(3);
                        Azman.setKy(10);
                        TembelSirin.settX(6);
                        TembelSirin.settY(5);
                    }
                }

            }



        }

        public void keyReleased(KeyEvent e) {
            // no event
        }

        public void keyTyped(KeyEvent e) {
            // no event
        }
    }






    public void MantarSure(){


        java.util.Timer tmer= new java.util.Timer();
        TimerTask gorev=new TimerTask() {
         @Override
        public void run() {

             Random rand= new Random();

             int s=rand.nextInt(10)+1;
             int d=rand.nextInt(8)+1;


             if (!harita.getDizi(s + 0, d + 0).equals("0") && sayac % 2 == 0) {
                        Obje.MantarKonum(s+0,d+0);
                    }
             else if (sayac % 2 == 1) {
                        Obje.MantarKonum(-1, -1);
                     }

                         sayac++;




         }

    };
    tmer.scheduleAtFixedRate(gorev,5000,7000);



}



public void AltınSure(){

    java.util.Timer tmer2= new java.util.Timer();
    TimerTask gorev2=new TimerTask() {
        @Override
        public void run() {

            Random rand2= new Random();

            int s=rand2.nextInt(10)+1;
            int d=rand2.nextInt(8)+1;


            if (!harita.getDizi(s + 0, d + 0).equals("0"))
                Obje.AltınKonum(s+0,d+0);
        }

    };
    tmer2.schedule(gorev2,0,5000);


}




    }





