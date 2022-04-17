package gamed;

import java.io.Serializable;

public class DVD extends Obra implements Serializable{
    
    private String realizador;
    private int DNDAC;

    public DVD(String numeroDeObra, int numeroDeExemplares, String titulo, float preco, String categoria, String realizador, int DNDAC) {
        super(numeroDeObra, numeroDeExemplares, titulo, preco, categoria);
        this.realizador = realizador;
        this.DNDAC = DNDAC;
    }
    
    public DVD() {
        this.realizador = "";
        this.DNDAC = 0;
    }
    
    /*Metodos Assessores*/
    public String getRealizador() {
        return realizador;
    }

    public void setRealizador(String realizador) {
        this.realizador = realizador;
    }

    public int getDNDAC() {
        return DNDAC;
    }

    public void setDNDAC(int DNDAC) {
        this.DNDAC = DNDAC;
    }
    
    @Override
    public String toString(){
        return this.getNumeroDeObra()+"-DVD-"+"-"+this.getTitulo()+"-"+this.getCategoria()+"-"+this.getNumeroDeExemplares()+"-"+this.getPreco()+"-"+this.realizador+"-"+this.DNDAC;
    }
}
