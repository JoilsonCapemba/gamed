package gamed;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Utente implements Serializable{
    private int numeroDeUtente;
    private String nome;
    private String E_mail;
    private String situacaoDoUtente;
    private ArrayList<ObraRequisitada> obrasRequisitadas;

    public Utente() {
        this.obrasRequisitadas = new ArrayList();
    }
    
    

    public int getNumeroDeUtente() {
        return numeroDeUtente;
    }

    public void setNumeroDeUtente(int numeroDeUtente) {
        this.numeroDeUtente = numeroDeUtente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getE_mail() {
        return E_mail;
    }

    public void setE_mail(String E_mail) {
        this.E_mail = E_mail;
    }

    public String getSituacaoDoUtente() {
        return situacaoDoUtente;
    }

    public void setSituacaoDoUtente(String situacaoDoUtente) {
        this.situacaoDoUtente = situacaoDoUtente;
    }

    public ArrayList<ObraRequisitada> getObrasRequisitadas() {
        return obrasRequisitadas;
    }

    public void setObrasRequisitadas(ObraRequisitada obrarequisitada) {
        this.obrasRequisitadas.add(obrarequisitada);
    }
    
    
    @Override
    public String toString(){
        return (this.numeroDeUtente+"-"+this.nome+"-"+this.E_mail+"-"+this.situacaoDoUtente);
    }
}