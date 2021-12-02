import java.io.*;

public class Harita {

    public  String[] dizi = new String[16];

    public Harita(){


        File file = new File("C:\\Users\\Alperen\\Desktop\\harita.txt");
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String satir = null;
        try {
            satir = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        int i = 0;

        while (satir != null) {
            dizi[i]= satir;
            System.out.println(dizi[i]);
            try {
                satir = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

            i++;
        }

    }
    public String getDizi(int x, int y) {
        String index = dizi[y].substring(x, x + 1);
        return index;

    }

}

