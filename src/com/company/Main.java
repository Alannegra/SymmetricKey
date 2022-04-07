package com.company;

import com.company.utils.Xifrar;

import javax.crypto.BadPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.security.auth.DestroyFailedException;

public class Main {

    public static void main(String[] args) {

        String inputString = "Alan";
        byte[] byteArrray = inputString.getBytes();
        SecretKey secretKey = Xifrar.keygenKeyGeneration(256);
        String word = new String(Xifrar.decryptData(Xifrar.encryptData(byteArrray,secretKey),secretKey));
        System.out.println(word);


        String inputString2 = "Rodriguez";
        byte[] byteArrray2 = inputString2.getBytes();
        SecretKey secretKeypass = Xifrar.passwordKeyGeneration("alanrodriguez",256);
        String word2 = new String(Xifrar.decryptData(Xifrar.encryptData(byteArrray2,secretKeypass),secretKeypass));
        System.out.println(word2);


        //Metodos -----------------------------------------------
        System.out.println(secretKey.getAlgorithm() + " " +  secretKey.getFormat());
        if(!secretKey.isDestroyed()) System.out.println("No esta destruido");
        //-------------------------------------------------------

        SecretKey secretKeypassIncorrecta = Xifrar.passwordKeyGeneration("INCORRECTA",256);
        try{
            String wordIncorrect = new String(Xifrar.decryptData(Xifrar.encryptData(byteArrray2,secretKeypass),secretKeypassIncorrecta));
            System.out.println(wordIncorrect);
        }catch (Exception e ){

        }






    }
}
