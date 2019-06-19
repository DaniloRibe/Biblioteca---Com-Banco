/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import connection.ConnectionFactory;
import dao.OperadorDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Operador;

/**
 *
 * @author Danilo
 */
public class OperadorController {
    
    OperadorDAO od = new OperadorDAO();
    
    public Operador buscarOperadorPorNome(String nome){
        return od.read(nome);
    }
    
    public boolean addOperador(String nome, String cpf, String email, String senha){
        Operador o = new Operador();
        o.setNome(nome);
        o.setCpf(cpf);
        o.setEmail(email);
        o.setSenha(senha);
        return od.create(o);
    }
    
    public boolean delOperador(String cpf){
        return od.delete(cpf);
    }
     
    public void listCliente(){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            stmt = con.prepareStatement("select * from Cliente");
            rs = stmt.executeQuery();
            while (rs.next()){
                Operador o = new Operador();
                o.setNome(rs.getString(1));
                o.setCpf(rs.getString(2));
                o.setEmail(rs.getString(3));
                o.setSenha(rs.getString(4));
                System.out.println(o);
            }
        } catch (SQLException ex) {
            Logger.getLogger(OperadorController.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
    }
    
    public boolean checkLogin(String cpf, String senha){
        boolean check = false;
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            stmt = con.prepareStatement("select * from operador where cpf = ? and senha = ?");
            stmt.setString(1, cpf);
            stmt.setString(2, senha);
            rs = stmt.executeQuery();
            if (rs.next()){
                check = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(OperadorController.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return check;
    }
}
