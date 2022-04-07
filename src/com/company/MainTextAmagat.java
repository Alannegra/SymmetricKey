package com.company;

import com.company.utils.Xifrar;

import javax.crypto.SecretKey;
import java.io.*;

public class MainTextAmagat {
    public static void main(String[] args) throws IOException {

        File file = new File("src/com/company/textamagat");
        FileReader fileReader = new FileReader(file);
        FileWriter fileWriter = new FileWriter("text.txt");
        BufferedReader bf = new BufferedReader(fileReader);
        BufferedWriter bw = new BufferedWriter(fileWriter);
        String word = "";
        String text = "";
        while((word = bf.readLine()) != null){
            System.out.println(word);
            text +=word;
            bw.write(word);
        }


        byte[] byteArrray2 = text.getBytes();

        SecretKey secretKeypass = Xifrar.passwordKeyGeneration("Jude Millhon",128);
        String word2 = new String(Xifrar.decryptData(byteArrray2,secretKeypass));
        System.out.println(word2);

     bf.close();
     bw.close();
    }
}
