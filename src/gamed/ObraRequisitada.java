package gamed;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class ObraRequisitada implements Serializable{
    private String iDoOrasRequisitada;
    private String dataSaida;
    private String devolucao;

    public ObraRequisitada(String iDoOrasRequisitada, String dataSaida, String devolucao) {
        this.iDoOrasRequisitada = iDoOrasRequisitada;
        this.dataSaida = dataSaida;
        this.devolucao = devolucao;
    }

    public String getiDoOrasRequisitada() {
        return iDoOrasRequisitada;
    }

    public void setiDoOrasRequisitada(String iDoOrasRequisitada) {
        this.iDoOrasRequisitada = iDoOrasRequisitada;
    }

    public String getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(String dataSaida) {
        this.dataSaida = dataSaida;
    }

    public String getDevolucao() {
        return devolucao;
    }

    public void setDevolucao(String devolucao) {
        this.devolucao = devolucao;
    }
 
}
