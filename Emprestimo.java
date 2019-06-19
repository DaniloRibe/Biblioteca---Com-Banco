/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Danilo
 */
public class Emprestimo {
    private int cod;
    private Livro livro;
    private Cliente cliente;
    
    private int codLivro;
    private String cpfCliente;

    public Emprestimo(int cod, Livro livro, Cliente cliente) {
        this.cod = cod;
        this.livro = livro;
        this.cliente = cliente;
    }

    public Emprestimo(Livro livro, Cliente cliente) {
        this.livro = livro;
        this.cliente = cliente;
    }

    public Emprestimo() {
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod ) {
        this.cod = cod;
    }

    public int getLivro() {
        return livro.getCod();
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public String getCliente() {
        return cliente.getCpf();
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public int getCodLivro() {
        return codLivro;
    }

    public void setCodLivro(int codLivro) {
        this.codLivro = codLivro;
    }

    public String getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }

    @Override
    public String toString() {
        return "Emprestimo{" + "cod=" + cod + ", codLivro=" + codLivro + ", cpfCliente=" + cpfCliente + '}';
    }
    
}
