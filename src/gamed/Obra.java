package gamed;

import java.io.Serializable;
import java.util.ArrayList;

public class Obra implements Serializable{

    /*Atributos*/
    private String numeroDeObra;
    private int numeroDeExemplares;
    private String titulo;
    private float preco;
    private String categoria;
    
    public static ArrayList<Obra> list_Obras = new ArrayList<>();
    
    public Obra(String numeroDeObra, int numeroDeExemplares, String titulo, float preco, String categoria) {
        this.numeroDeObra = numeroDeObra;
        this.numeroDeExemplares = numeroDeExemplares;
        this.titulo = titulo;
        this.preco = preco;
        this.categoria = categoria;
    }
   
    public Obra(){
        this.numeroDeObra = null;
        this.numeroDeExemplares = 0;
        this.titulo = null;
        this.preco = 0.0f;
        this.categoria = null;
    }

    public String getNumeroDeObra() {
        return numeroDeObra;
    }

    public void setNumeroDeObra(String numeroDeObra) {
        this.numeroDeObra = numeroDeObra;
    }

    public int getNumeroDeExemplares() {
        return numeroDeExemplares;
    }

    public void setNumeroDeExemplares(int numeroDeExemplares) {
        this.numeroDeExemplares = numeroDeExemplares;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    
    
}
