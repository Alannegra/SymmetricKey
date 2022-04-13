package com.company;

import com.company.utils.Xifrar;

import javax.crypto.SecretKey;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class MainTextAmagat {
    public static void main(String[] args) throws IOException {

        File file = new File("src/com/company/textamagat");
        File file2 = new File("src/com/company/clau.txt");
        FileReader fileReader = new FileReader(file);
        FileReader fileReader2 = new FileReader(file2);
        FileWriter fileWriter = new FileWriter("text.txt");
        BufferedReader bf = new BufferedReader(fileReader);
        BufferedReader bf2 = new BufferedReader(fileReader2);
        BufferedWriter bw = new BufferedWriter(fileWriter);
        String word = "";
        String word2 = "";
        String text = "";
        ArrayList<String> arrayList = new ArrayList<>();


        File f = new File("src/com/company/textamagat");
        FileReader fr = new FileReader(f);
        BufferedReader br =  new BufferedReader(fr);
        String line = br.readLine();
        while(line != null ) { //fins que no hi ha més línies a llegir
            //fer alguna cosa amb la línia llegida
            //System.out.print("lectura: " + line);
            //següent línia
            line = br.readLine();
        }

       // byte[] byteArrray2 = line.getBytes();



        Path path = Paths.get("src/com/company/textamagat");
        byte[] textenbytes = Files.readAllBytes(path);

        while((word2 = bf2.readLine()) != null){
            //System.out.println(word2);
            arrayList.add(word2);
            bw.write(word2);
        }

        for (String a: arrayList) {

            SecretKey secretKeypass = Xifrar.passwordKeyGeneration(a,128);
            try {


                String textoencrypt = new String(Xifrar.decryptData(textenbytes,secretKeypass));
                if(textoencrypt == null){
                    System.out.println(a);
                }
                System.out.println(textoencrypt);
            }catch (Exception e){

            }


        }

        br.close();
        bf.close();
        bw.close();

    }
}
