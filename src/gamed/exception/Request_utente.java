package gamed.exception;

import gamed.Utente;
import java.util.ArrayList;
import java.util.Scanner;

public class Request_utente {
    public static Scanner read = new Scanner(System.in);
    public static Utente requestUserId(ArrayList<Utente> utentes){
        System.out.println("Id do utente: ");
        String id = read.next();
        for(int i = 0; i < utentes.size(); i++){
            if(utentes.get(i).getNumeroDeUtente() == Integer.parseInt(id)) return utentes.get(i);
        }
        return null;
    }
}
