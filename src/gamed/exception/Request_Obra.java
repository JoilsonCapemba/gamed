package gamed.exception;

import static gamed.Menus.GerenciadorMenu.read;
import gamed.Obra;
import java.util.ArrayList;
import java.util.Date;

public class Request_Obra {

    public static ArrayList<Integer> ids = new ArrayList<>();

    public static String requestTitle() {
        System.out.println("TITULO DA OBRA: ");
        if (read.nextLine().equals("")) {
            return read.nextLine();
        }
        return read.nextLine();
    }

    public static float requestPrice() {
        System.out.println("PREÇO DA OBRA: ");
        return read.nextFloat();
    }

    public static String requestTipo() {
        System.out.println("TIPO DE OBRA: ");
        return read.nextLine();
    }

    public static int requestNumeroDeExemplares() {
        System.out.println("TOTAL DE EXEMPLARES: ");
        return read.nextInt();
    }

    public static String requestAutor() {
        System.out.println("AUTOR: ");
        if(read.nextLine().equals("")){
            return read.nextLine();
        }
        return read.nextLine();
    }

    public static String requestRealizador() {
        System.out.println("REALIZADOR: ");
        return read.nextLine().equals("") ? read.nextLine() : read.nextLine();
    }

    public static String requestISBN() {
        System.out.println("ISBN: ");
        return read.next();
    }

    public static int requestDNDAC() {
        System.out.println("DADNCA: ");
        return read.nextInt();
    }

    public static String requestCategoria() {
        System.out.println("qual a categoria da Obra: ");
        System.out.println("[1]-Obra de referencia");
        System.out.println("[2]-Obra de Ficção");
        System.out.println("[3]-Obra tecnica e Cientifica");
        System.out.println("Qualquer tecla para- Otra Categoria");

        switch (read.nextInt()) {
            case 1:
                return "Obra de referencia";
            case 2:
                return "Obra de Ficção";
            case 3:
                return "Obra tecnica e Cientifica";
            default:
                return read.nextLine();
        }
    }
    
    public static String requestId() {
        Date data = new Date();
        final int ID_TOTAL = 9999;
        String ano[] = (String.valueOf(data)).split(" ");

        for (int senha = 0; senha <= ID_TOTAL; senha++) {
            if (Request_Obra.ids.size() < senha) {
                senha = Request_Obra.ids.size() + 1;
                if (senha < 10) {
                    Request_Obra.ids.add(senha);
                    return ("000" + (String.valueOf(senha)) + "/" + ano[ano.length - 1]);
                } else if (10 <= senha && senha < 100) {
                    Request_Obra.ids.add(senha);
                    return ("00" + (String.valueOf(senha)) + "/" + ano[ano.length - 1]);
                } else if (100 <= senha && senha < 1000) {
                    Request_Obra.ids.add(senha);
                    return ("0" + (String.valueOf(senha)) + "/" + ano[ano.length - 1]);
                } else if (1000 <= senha && senha < 10000) {
                    Request_Obra.ids.add(senha);
                    return ((String.valueOf(senha)) + "/" + ano[ano.length - 1]);
                }
            }
        }
        return null;
    }
}
