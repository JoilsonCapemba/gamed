package gamed;
import java.util.ArrayList;

public class Categoria {
    private String nomeDaCategoria;
    private ArrayList<Obra> listaDeObrasDaCategoria;

    public Categoria() {
        this.nomeDaCategoria = "";
        this.listaDeObrasDaCategoria = null;
    }
    
    public Categoria(String nomeDaCategoria, ArrayList<Obra> listaDeObrasDaCategoria){
        this.nomeDaCategoria = nomeDaCategoria;
        this.listaDeObrasDaCategoria = listaDeObrasDaCategoria;
    }

    public String getNomeDaCategoria() {
        return nomeDaCategoria;
    }

    public void setNomeDaCategoria(String nomeDaCategoria) {
        this.nomeDaCategoria = nomeDaCategoria;
    }

    public ArrayList<Obra> getListaDeObrasDaCategoria() {
        return listaDeObrasDaCategoria;
    }

    public void setListaDeObrasDaCategoria(Obra obra) {
        this.listaDeObrasDaCategoria.add(obra);
    }
   
   
}
