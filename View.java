/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

/**
 *
 * @author Danilo
 */
public class View {
    private String nome;
    private String cpf;
    private int quantidade;

    public View(String nome, String cpf, int quantidade) {
        this.nome = nome;
        this.cpf = cpf;
        this.quantidade = quantidade;
    }

    public View() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "Cliente{" + "nome=" + nome + ", cpf=" + cpf + ", quantidade=" + quantidade + '}';
    }  
}
