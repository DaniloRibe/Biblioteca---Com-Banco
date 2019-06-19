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
public class Cliente extends Usuario {
    
    public Cliente(String nome, String cpf, String email, String senha) {
        super(nome, cpf, email, senha);
    }

    public Cliente() {
       
    }

    @Override
    public String toString() {
        return "Cliente {" + super.toString();
    }

    public void getCpf(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
