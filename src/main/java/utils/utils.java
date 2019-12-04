package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class utils{

    public static List<String> readFile(String fileName) {
        List<String> tableau = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/main/resources/input/days/"+fileName));
            String line;
            while ((line = br.readLine()) != null) {
                
                tableau.add(line);
                 
            }
            br.close();             
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tableau;
    }

    public static void main(String[] args) {
        System.out.println(readFile("input-day-1.txt"));

    }

    // public static void main(String[] args) {
    //     System.out.println("hello world");
    // }
}