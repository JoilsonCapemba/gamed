package gamed.Menus;

import gamed.DVD;
import gamed.Livro;
import gamed.Obra;
import gamed.Utente;
import static gamed.exception.Request_Obra.*;
import gamed.serializacao.Serializacao;
import java.util.ArrayList;
import java.util.Scanner;
import static gamed.serializacao.Serializacao.*;

public class GerenciadorMenu {

    public static Scanner read = new Scanner(System.in);

    public static void showMenuPrincipal() {
        System.out.println("[1]-Abrir");
        System.out.println("[2]-Guardar");
        System.out.println("[3]-Menu de Gestao de Utentes");
        System.out.println("[4]-Menu de Gestao de Obras");
        System.out.println("[5]-Menu de Gestao de Requisicoes");
        System.out.println("[6]-Sair");
    }

    public static void showMenuDeGestaoDeUtentes() {
        System.out.println("[1]-Registar Utente");
        System.out.println("[2]-Mostrar Utente");
        System.out.println("[3]-Mostrar Utentes");
        System.out.println("[4]-Pagar Multa");
        System.out.println("[5]-Sair");
    }

    public static void showMenuDeObras() {
        System.out.println("[1]-Registar Obra");
        System.out.println("[2]-Mostrar Obras");
        System.out.println("[3]-Efectusr pesquisa");
        System.out.println("[4]-Sair");
    }

    public static void showMenuDeRequisicoes() {
        System.out.println("[1]-Requisitar Obra");
        System.out.println("[2]-Devolver Obra");
        System.out.println("[3]-Sair");
    }

    public static void menuGestaoAbrir(ArrayList<Utente> utentes, ArrayList<Obra> obras) {
        Serializacao serializador = new Serializacao();
        utentes = (ArrayList<Utente>) serializador.deserialize("Utentes.txt");
        obras = (ArrayList<Obra>) serializador.deserialize("Obras.txt");
    }

    public static void menuDeGestaoGuardar(ArrayList<Utente> utentes, ArrayList<Obra> obras) {
        Serializacao serializador = new Serializacao();
        serializador.serializar(utentes, "Utentes.txt");
        serializador.serializar(obras, "Obras.txt");

    }

    public static void menuDeGestaoDeUtentes(ArrayList<Utente> utentes) {
        int opcaoMenuUtente = 0;
        do {
            showMenuDeGestaoDeUtentes();
            opcaoMenuUtente = read.nextInt();
            switch (opcaoMenuUtente) {
                case 1:
                    Utente utente = new Utente();
                    preencheDadosDoUtente(utente);
                    if (utentes.isEmpty()) {
                        utente.setNumeroDeUtente(1);
                        System.out.println(utente.toString());
                    } else {
                        utente.setNumeroDeUtente(utentes.size() + 1);
                    }
                    if (querSalvar("Utente: " + utente.toString()) == true) {
                        utentes.add(utente);
                    }
                    break;
                case 2:
                    System.out.println("Numero do utente: ");
                    int numeroUtente = read.nextInt();
                    System.out.println(showUtente(utentes, numeroUtente));
                    break;
                case 3:
                    showUtentes(utentes);
                    break;
                case 4:
                    break;
                default:
            }
        } while (opcaoMenuUtente != 5);
    }

    public static void menuDeGestaoDeObras(ArrayList<Obra> obras) {
        int opcaoMenuObras = 0;
        do {
            showMenuDeObras();
            opcaoMenuObras = read.nextInt();
            switch (opcaoMenuObras) {
                case 1:
                    Obra obra = null;
                    String opcao;
                    do {
                        System.out.println("Tipo de obra");
                        System.out.println("[1]-Livro/ [2]-DVD");
                        opcao = read.next();
                        if (opcao.equals("1")) {
                            obra = new Livro();
                        } else if (opcao.equals("2")) {
                            obra = new DVD();
                        }
                    } while (!(opcao.equals("1")) && !(opcao.equals("2")));

                    preencheDadosDaObra(obra);
                    if (querSalvar("Obra: " + obra.toString()) == true) {
                        obras.add(obra);
                    }
                    break;
                case 2:
                    showObras(obras);
                    break;
                case 3:
                    break;
                default:

            }
        } while (opcaoMenuObras != 4);
    }

    public static void menuDeGestaoDeRequisicoes(ArrayList<Obra> obras) {
        int opcaoMenuRequisicoes = 0;
        do {
            showMenuDeRequisicoes();
            opcaoMenuRequisicoes = read.nextInt();
            switch (opcaoMenuRequisicoes) {
                case 1:
                    break;
                case 2:
                    showObras(obras);
                    break;
                default:
                    System.out.println("Opcao invalida");
            }
        } while (opcaoMenuRequisicoes != 3);
    }

    public static void preencheDadosDoUtente(Utente utente) {
        System.out.println("Nome:");
        utente.setNome(read.nextLine());
        if (utente.getNome().equals("")) {
            utente.setNome(read.nextLine());
        }
        System.out.println("E-mail:");
        utente.setE_mail(read.next());
        utente.setSituacaoDoUtente("ACTIVO");
    }

    public static String showUtente(ArrayList<Utente> utentes, int ID_utente) {
        for (Utente utente : utentes) {
            if (utente.getNumeroDeUtente() == ID_utente) {
                return utente.toString();
            }
        }
        return "Utente nao encontrado";
    }

    public static void showUtentes(ArrayList<Utente> utentes) {
        System.out.println("======= Lista de Utentes ========");
        if (utentes.isEmpty()) {
            System.out.println("A lista de utentes esta vazia!");
        } else {
            for (Utente utente : utentes) {
                System.out.println(utente.toString());
            }
        }
    }

    public static void preencheDadosDaObra(Obra obra) {
        obra.setTitulo(requestTitle());
        obra.setPreco(requestPrice());
        obra.setCategoria(requestCategoria());
        obra.setNumeroDeExemplares(requestNumeroDeExemplares());
        obra.setNumeroDeObra(requestId());
        if (obra instanceof Livro) {
            ((Livro) obra).setAutores(requestAutor());
            String opcao;
            do {
                System.out.println("Desejas Acresnetar mais um autor ?");
                opcao = read.next();
                if (opcao.toUpperCase().equals("S")) {
                    ((Livro) obra).setAutores(requestAutor());
                }
            } while (opcao.equals("S"));
            ((Livro) obra).setISBN(requestISBN());
        } else if (obra instanceof DVD) {
            ((DVD) obra).setRealizador(requestRealizador());
            ((DVD) obra).setDNDAC(requestDNDAC());
        }
    }

    public static void showObras(ArrayList<Obra> obras) {
        if (obras.isEmpty()) {
            System.out.println("Lista de obras vazia!");
        } else {
            System.out.println("Lista de Obras");
            for (Obra obra : obras) {
                if (obra instanceof Livro) {
                    System.out.println(((Livro) obra).toString());
                } else if (obra instanceof DVD) {
                    System.out.println(((DVD) obra).toString());
                }
            }
        }
    }

    public static boolean querSalvar(String elementoAserSalvo) {
        System.out.println("Desejas salvar este/a " + elementoAserSalvo);
        System.out.println("[s]-Sim/ Nao[n]");

        String opcaoSalvar = read.next().toUpperCase();
        return (opcaoSalvar.equals("S"));
    }
}
