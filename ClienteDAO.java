/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


import model.Cliente;

/**
 *
 * @author Danilo
 */
public class ClienteDAO {
    
    public boolean create(Cliente c){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("insert into cliente (nome, cpf, email, senha) values(?,?,?,?)");
            stmt.setString(1, c.getNome());
            stmt.setString(2, c.getCpf());
            stmt.setString(3, c.getEmail());
            stmt.setString(4, c.getSenha());
         
            int qtdAfetado = stmt.executeUpdate();
            if (qtdAfetado>0){
                return true;
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao salvar!"+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
        return false;
    }
    
    public Cliente read(String nome){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        Cliente c = null;
        ResultSet rs = null;
        try {
            stmt = con.prepareStatement("select * from cliente where nome = ?");
            stmt.setString(1, nome);
            rs = stmt.executeQuery();
            if (rs.next()){
                c = new Cliente();
                c.setNome(rs.getString(1));
                c.setCpf(rs.getString(2));
                c.setEmail(rs.getString(3));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return c;
       
    }
    
    public boolean delete(String cpf){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("delete from cliente where cpf = ?");
            stmt.setString(1, cpf);
            int qtdAfetado = stmt.executeUpdate();
            if (qtdAfetado>0){
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
        return false;
    }
    
}
