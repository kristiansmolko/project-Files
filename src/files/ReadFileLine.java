package files;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFileLine {
    public void copyFileWithCapital(String fileName){
        BufferedReader reader;
        try {
            FileReader fr = new FileReader(fileName);
            reader = new BufferedReader(fr);
            String line;
            while ((line=reader.readLine())!=null){
                line = line.toUpperCase();
                System.out.println(line);
            }

            fr.close();
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }
}
