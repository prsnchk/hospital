package com.solvd.hospital.text;



import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;

public class Texter {
    public static void main(String[] args) throws IOException {
        File file = new File("src/main/resources/LeonardodaVinci.txt");
        String content = FileUtils.readFileToString(file, "UTF-8");

        int leonardoCount = 0;
        int daCount = 0;
        int vinciCount = 0;

        String[] splitted = StringUtils.split(content);
        for (int i = 0; i < splitted.length; i++) {
            if(splitted[i].contains("Leonardo")) {
                leonardoCount = leonardoCount+1;
            }
            if(splitted[i].contains("da")) {
                daCount = daCount+1;
            }
            if(splitted[i].contains("Vinci")) {
                vinciCount = vinciCount+1;
            }
        }

        String result = "Leonardo: " + leonardoCount + "\n" + "da: "+ daCount + "\n" + "Vinci: " + vinciCount;
        System.out.println(result);
        File fileOut = new File("src/main/resources/result.txt");
        FileUtils.writeStringToFile(fileOut, result);



    }
}
