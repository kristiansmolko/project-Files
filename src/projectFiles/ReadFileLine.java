package projectFiles;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReadFileLine {
    public void copyFileWithCapital(String fileName){
        BufferedReader reader;
        try {
            if (new File(fileName).exists() == false){
                System.out.println("This file " + fileName + " does not exist!");
                return;
            }
            FileReader fr = new FileReader(fileName);

            File file = new File("resource/" + getFileName());
            file.createNewFile();

            FileWriter fw = new FileWriter(file);
            reader = new BufferedReader(fr);
            String line;
            while ((line=reader.readLine())!=null){
                line = line.toUpperCase();
                fw.write(line +"\n");
            }

            fr.close();
            fw.close();
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }

    private String getFileName(){
        Date today = new Date();
        DateFormat sdf = new SimpleDateFormat("HHmmss");
        String name;
        name = "b_" + sdf.format(today);
        return name;
    }
}
