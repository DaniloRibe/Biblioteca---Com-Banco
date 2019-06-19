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
public class Funcao {
    private int qtd;

    public Funcao(int qtd) {
        this.qtd = qtd;
    }

    public Funcao() {
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    @Override
    public String toString() {
        return "Funcao{" + "qtd=" + qtd + '}';
    }   
}
