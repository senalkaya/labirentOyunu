import javax.swing.*;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Main {

    public Main(){
        JFrame f= new JFrame();
        f.setTitle("Smurfs Game");
        f.add(new Grafik());
        f.setSize(670,750);
        f. setDefaultCloseOperation(EXIT_ON_CLOSE);
        f.setVisible(true);
    }

    public static void main(String[] args){

           new Main();
    }
}
