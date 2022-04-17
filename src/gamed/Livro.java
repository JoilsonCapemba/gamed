package gamed;

import java.io.Serializable;
import java.util.ArrayList;

public class Livro extends Obra implements Serializable{
    private ArrayList<String> autores;
    private String ISBN;
    
    public Livro(String numeroDeObra, int numeroDeExemplares, String titulo, float preco, String categoria, String autor, String ISBN) {
        super(numeroDeObra, numeroDeExemplares, titulo, preco, categoria);
        this.ISBN = ISBN;
        this.autores.add(autor);
    }
    
    public Livro() {
        super();
        this.ISBN = "";
        this.autores = new ArrayList();
    }

    public ArrayList<String> getAutores() {
        return autores;
    }

    public void setAutores(String autor) {
        this.autores.add(autor);
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }
    
    @Override
    public String toString(){
        return this.getNumeroDeObra()+"-Livro-"+this.getTitulo()+"-"+this.getCategoria()+"-"+this.getNumeroDeExemplares()+"-"+this.getPreco()+"-"+this.getAutores()+"-"+this.getISBN();
    }
}