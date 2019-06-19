/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Emprestimo;

/**
 *
 * @author Danilo
 */
public class EmprestimoDAO {
    
    public boolean create(Emprestimo e){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("instert into emprestimo (cod_livro, cpf_cliente) values (?, ?)");
            stmt.setInt(1, e.getLivro());
            stmt.setString(2, e.getCliente());
            
            int qtdAfetado = stmt.executeUpdate();
            if (qtdAfetado>0){
                return true;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(EmprestimoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
        return false;
    }
    
    public boolean delete(int cod){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("delete from emprestimo where cod = ?");
            stmt.setInt(1, cod);
            
            int qtdAfetado = stmt.executeUpdate();
            if (qtdAfetado>0){
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmprestimoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
        
        return false;
    }
}
