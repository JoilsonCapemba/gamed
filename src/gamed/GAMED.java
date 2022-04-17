package gamed;

import static gamed.Menus.GerenciadorMenu.*;
import gamed.serializacao.Serializacao;
import java.util.ArrayList;

public class GAMED {

    public static void main(String[] args) {
        ArrayList<Utente> utentes = new ArrayList();
        ArrayList<Obra> obras = new ArrayList();
        
        System.out.println(utentes.size());
        int opcaoPrincipal;
        do{
            showMenuPrincipal();
            opcaoPrincipal = read.nextInt();
            
            switch(opcaoPrincipal){
            case 1:
                Serializacao serializador = new Serializacao();
                utentes = (ArrayList<Utente>) serializador.deserialize("Utentes.txt");
                obras = (ArrayList<Obra>) serializador.deserialize("Obras.txt");
                
                break;
            case 2:
                menuDeGestaoGuardar(utentes, obras);
                break;
            case 3:
                menuDeGestaoDeUtentes(utentes);
                break;
            case 4:
                menuDeGestaoDeObras(obras);
                break;
            case 5:
                menuDeGestaoDeRequisicoes(obras);
                break;
            default:
                System.out.println("Opcao invalida!");
                break;
            }
        }while(opcaoPrincipal != 6);
    }    
}
