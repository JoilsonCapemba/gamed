package gamed;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Requisicoes {
    public static boolean requisitar(ArrayList<Obra> obras, Utente utente, String idObraRequisitada){
        if(!isSuspenso(utente) && canRequest(utente, idObraRequisitada)){
            if(retirarExemplar(obras, idObraRequisitada)){
                utente.setObrasRequisitadas(new ObraRequisitada(idObraRequisitada, LocalDate.now().toString(), LocalDate.now().toString()));
                return true;
            }
        }
        return false;
    }
    
    public static boolean isSuspenso(Utente utente){
        return utente.getSituacaoDoUtente().equals("SUSPENSO");
    } 
    
    public static boolean canRequest(Utente utente, String obraRequisitada){
        if((utente.getObrasRequisitadas() != null && utente.getObrasRequisitadas().size() < 4)){
            for(ObraRequisitada obraRequested: utente.getObrasRequisitadas()){
                if(obraRequested.getiDoOrasRequisitada().equals(obraRequisitada)) return false;
           }
        }
        return true;
    }
    
    public static boolean retirarExemplar(ArrayList<Obra> obras, String idObra){  
        for (Obra obra: obras) {
            if (obra.getNumeroDeObra().equals(idObra)) {
                obra.setNumeroDeExemplares(obra.getNumeroDeExemplares() -1);
                return true;
            }
        }
        return false;
    }
    
}
