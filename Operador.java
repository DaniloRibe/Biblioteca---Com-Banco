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
public class Operador extends Usuario{

    public Operador(String nome, String cpf, String email, String senha) {
        super(nome, cpf, email, senha);
    }

    public Operador() {
 
    }

    @Override
    public String toString() {
        return "Operador {" + super.toString();
    }
    
    
    
}
