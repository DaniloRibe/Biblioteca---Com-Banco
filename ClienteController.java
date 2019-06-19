/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import connection.ConnectionFactory;
import dao.ClienteDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Cliente;
import view.Funcao;
import view.View;

/**
 *
 * @author Danilo
 */
public class ClienteController {
    
    ClienteDAO cd = new ClienteDAO();
    
    public Cliente buscarClientePorNome(String nome){
        return cd.read(nome);
    }
    
    public boolean addCliente(String nome, String cpf, String email, String senha){
        Cliente c = new Cliente();
        c.setNome(nome);
        c.setCpf(cpf);
        c.setEmail(email);
        c.setSenha(senha);
        return cd.create(c);
    }
    
    public boolean delCliente(String cpf){
        return cd.delete(cpf);
    }
    
    public void listCliente(){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            stmt = con.prepareStatement("select * from Cliente");
            rs = stmt.executeQuery();
            while (rs.next()){
                Cliente c = new Cliente();
                c.setNome(rs.getString(1));
                c.setCpf(rs.getString(2));
                c.setEmail(rs.getString(3));
                c.setSenha(rs.getString(4));
                System.out.println(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
    }
    
    public void visao(){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            stmt = con.prepareStatement("select * from qtd_livros");
            rs = stmt.executeQuery();
            while(rs.next()){
                View v = new View();
                v.setNome(rs.getString(1));
                v.setCpf(rs.getString(2));
                v.setQuantidade(rs.getInt(3));
                System.out.println(v);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
    }
    
    public void funcao(String cpf){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            stmt = con.prepareStatement("select qtd_de_livros(?)");
            stmt.setString(1, cpf);
            rs = stmt.executeQuery();
            while(rs.next()){
                Funcao f = new Funcao();
                f.setQtd(rs.getInt(1));
                System.out.println(f);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
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
            stmt = con.prepareStatement("select * from cliente where cpf = ? and senha = ?");
            stmt.setString(1, cpf);
            stmt.setString(2, senha);
            rs = stmt.executeQuery();
            if (rs.next()){
                check = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return check;
    }
}
