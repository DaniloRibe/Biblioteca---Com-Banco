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
import model.Operador;

/**
 *
 * @author Danilo
 */
public class OperadorDAO {
    
    public boolean create(Operador c){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("call inserir_operador (?,?,?,?)");
            stmt.setString(1, c.getNome());
            stmt.setString(2, c.getCpf());
            stmt.setString(3, c.getEmail());
            stmt.setString(4, c.getSenha());        
            stmt.executeUpdate();
            
        } catch (SQLException ex) {
            System.out.println("Erro ao salvar!"+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
        return false;
    }
    
    public Operador read(String nome){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        Operador o = null;
        ResultSet rs = null;
        try {
            stmt = con.prepareStatement("select * from cliente where nome = ?");
            stmt.setString(1, nome);
            rs = stmt.executeQuery();
            if (rs.next()){
                o = new Operador();
                o.setNome(rs.getString(1));
                o.setCpf(rs.getString(2));
                o.setEmail(rs.getString(3));
            }
        } catch (SQLException ex) {
            Logger.getLogger(OperadorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return o;
       
    }
    
    public boolean delete(String cpf){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("delete from operador where cpf = ?");
            stmt.setString(1, cpf);
            int qtdAfetado = stmt.executeUpdate();
            if (qtdAfetado>0){
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(OperadorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
        return false;
    }
    
}
