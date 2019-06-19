/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exec;

import controller.ClienteController;
import controller.EmprestimoController;
import controller.LivroController;
import controller.OperadorController;
import java.util.Scanner;

/**
 *
 * @author Danilo
 */
public class InterfacePrincipal {

    public static Scanner in = new Scanner(System.in);
    ClienteController cc = new ClienteController();
    OperadorController oc = new OperadorController();
    LivroController lc = new LivroController();
    EmprestimoController ec = new EmprestimoController();

    String interfaceInicial = "\n****Bem-Vindo à Biblioteca**** \n"
            + "1 - Fazer login como operador \n"
            + "2 - Fazer login como cliente \n"
            + "3 - Cadastrar-se como cliente \n"
            + "4 - Sair";

    String interfaceOperador = "\n1 - Listar livros \n"
            + "2 - Adicionar livro \n"
            + "3 - Remover livro \n"
            + "4 - Buscar livro \n"
            + "5 - Listar clientes \n"
            + "6 - Buscar cliente \n"
            + "7 - Remover cliente \n"
            + "8 - Listar emprestimos \n"
            + "9 - Quantidade de emp para cada cliente \n"
            + "10 - Adicionar operador \n"
            + "11 - Sair";

    String interfaceCliente = "\n1 - Listar livros \n"
            + "2 - Buscar livro por nome \n"
            + "3 - Mostrar minha quantidade de livros \n"
            + "4 - Pegar livro \n"
            + "5 - Devolver livro \n"
            + "6 - Sair";
    
    public void start(){
        while(true){
            System.out.println(interfaceInicial);
            System.out.print("Digite uma opção: ");
            String comando = in.nextLine();
            if (comando.equals("4")) {
                break;
            }
            switch(comando){
                case "1":
                    System.out.print("Digite seu CPF: ");
                    String cpf = in.nextLine();
                    System.out.print("Digite sua senha: ");
                    String senha = in.nextLine();
                    if(oc.checkLogin(cpf, senha)==true){
                        menuOperador();
                    }else{
                        System.out.println("CPF ou senha incorretos!");
                        break;
                    }
                    break;
                case "2":
                    System.out.print("Digite seu CPF: ");
                    String cpfC = in.nextLine();
                    System.out.print("Digite sua senha: ");
                    String senhaC = in.nextLine();
                    if (cc.checkLogin(cpfC, senhaC)==true){
                        menuCliente();
                    }else{
                        System.out.println("CPF ou senha incorretos!");
                        break;
                    }
                    break;
                case "3":
                    cadastroCliente();
                    break;
                default:
                    System.out.println("Entrada inválida!");
                    break;
            }
        }
    }
    
    public void menuOperador() {

        while (true) {
            System.out.println(interfaceOperador);
            System.out.print("Digite uma opção: ");
            String comandoOperador = in.nextLine();
            if (comandoOperador.equals("11")) {
                break;
            }
            
            switch(comandoOperador){
                case "1":
                    lc.listLivro();
                    break;
                case "2":
                    System.out.print("Digite o código do livro: ");
                    int cod = in.nextInt();
                    in.nextLine();
                    System.out.print("Digite o nome do livro: ");
                    String titulo = in.nextLine();
                    System.out.print("Digite o nome do autor:");
                    String autor = in.nextLine();
                    System.out.print("Digite o nome da editora: ");
                    String editora = in.nextLine();
                    if (cod == 0 || titulo.equals("") || autor.equals("") || editora.equals("")) {
                        System.out.println("ERRO. Preencha todo o formulário!");
                        break;
                    } else {
                        if (lc.addLivro(cod, titulo, autor, editora) == true) {
                            System.out.println("Livro adicionado!");
                        } else {
                            System.out.println("Não foi possível adicionar o livro!");
                        }
                    }
                    break;
                case "3":
                    System.out.print("Digite o código do livro: ");
                    int codl = in.nextInt();
                    in.nextLine();
                    if (lc.delLivro(codl) == true) {
                        System.out.println("Livro removido");
                        break;
                    } else {
                        System.out.println("Código não encontrado");
                    }
                    break;
                case "4":
                    System.out.print("Digite o nome do livro: ");
                    String nomeL = in.nextLine();
                    if(lc.buscarLivroPorTitulo(nomeL)==null){
                        System.out.println("Livro não encontrado!");
                    }else{
                        System.out.println(lc.buscarLivroPorTitulo(nomeL));
                    }
                    break;
                case "5":
                    cc.listCliente();
                    break;
                case "6":
                    System.out.print("Digite o nome do cliente: ");
                    String nomC = in.nextLine();
                    if(cc.buscarClientePorNome(nomC)==null){
                        System.out.println("Cliente não encontrado!");
                    }else{
                        System.out.println(cc.buscarClientePorNome(nomC));
                    }
                    break;
                case "7":
                    System.out.print("Digite o CPF do cliente: ");
                    String cpfc = in.nextLine();

                    if (cc.delCliente(cpfc) == true) {
                        System.out.print("Cliente removido");
                    } else {
                        System.out.println("Erro ao remover");
                    }
                    break;
                case "8":
                    ec.listEmprestimos();
                    break;
                case "9":
                    cc.visao();
                    break;
                case "10":
                    cadastroOperador();
                    break;
                default:
                    System.out.println("Comando inválido!");
                    break;
            }
        }
    }
    
    public void menuCliente(){
        while(true){
            System.out.println(interfaceCliente);
            System.out.print("Digite uma opção: ");
            String comandoCliente = in.nextLine();
            if (comandoCliente.equals("6")){
                break;
            }
            switch(comandoCliente){
                case "1":
                    lc.listLivro();
                    break;
                case "2":
                    System.out.print("Digite o nome do livro: ");
                    String nomeL = in.nextLine();
                    if(lc.buscarLivroPorTitulo(nomeL)==null){
                        System.out.println("Livro não encontrado!");
                    }else{
                        System.out.println(lc.buscarLivroPorTitulo(nomeL));
                    }
                    break;
                case "3":
                    System.out.print("Digite seu CPF: ");
                    String cpf = in.nextLine();
                    cc.funcao(cpf);
                    break;
                case "4":
                    System.out.print("Digite o código do livro: ");
                    int cod = in.nextInt();
                    in.nextLine();
                    System.out.print("Digite seu CPF: ");
                    String cpfC = in.nextLine();
                    ec.pegarLivro(cod, cpfC);
                    break;
                case "5":
                    System.out.print("Digite o codigo do livro: ");
                    int codl = in.nextInt();
                    in.nextLine();
                    System.out.print("Digite seu cpf para confirmar: ");
                    String cpff = in.nextLine();
                    ec.devolverLivro(codl, cpff);
                    break;
                default:
                    System.out.println("Comando inválido!");
                    break;
            }
        }
    }
    
    public void cadastroCliente() {
        System.out.print("Digite seu nome: ");
        String nome = in.nextLine();
        System.out.print("Digite seu CPF: ");
        String cpfC = in.nextLine();
        System.out.print("Digite seu email: ");
        String email = in.nextLine();
        System.out.print("Digite uma senha: ");
        String senhaC = in.nextLine();
        if (nome.equals("") || cpfC.equals("") || email.equals("") || senhaC.equals("")) {
            System.out.println("ERRO. Preencha todo o fromulário!");
        } else {
            if (cc.addCliente(nome, cpfC, email, senhaC) == true) {
                System.out.println("Cadastro realizado!");
            } else {
                System.out.println("Erro ao cadastrar!");
            }
        }

    }
    
    public void cadastroOperador() {
        System.out.print("Digite seu nome: ");
        String nome = in.nextLine();
        System.out.print("Digite seu CPF: ");
        String cpfC = in.nextLine();
        System.out.print("Digite seu email: ");
        String email = in.nextLine();
        System.out.print("Digite uma senha: ");
        String senhaC = in.nextLine();
        if (nome.equals("") || cpfC.equals("") || email.equals("") || senhaC.equals("")) {
            System.out.println("ERRO. Preencha todo o formulário!");
        } else {
            if (oc.addOperador(nome, cpfC, email, senhaC) == false) {
                System.out.println("Cadastro realizado!");
            }
        }
    }
}