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
import model.Livro;

/**
 *
 * @author Danilo
 */
public class LivroDAO {
    
    public boolean create(Livro l){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("insert into livro (cod,titulo,autor,editora) "
                    + "values (?, ?, ?, ?)");
            stmt.setInt(1, l.getCod());
            stmt.setString(2, l.getTitulo());
            stmt.setString(3, l.getAutor());
            stmt.setString(4, l.getEditora());
            
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
    
    public Livro read(String titulo){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Livro l = null;
        
        try {
            stmt = con.prepareStatement("select * from livro where titulo = ?");
            stmt.setString(1, titulo);
            rs = stmt.executeQuery();
            if (rs.next()){
                l = new Livro();
                l.setCod(rs.getInt(1));
                l.setTitulo(rs.getString(2));
                l.setAutor(rs.getString(3));
                l.setEditora(rs.getString(4));
                              
            }
        } catch (SQLException ex) {
            Logger.getLogger(LivroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return l;
    }
    
    public boolean delete(int cod){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("delete from livro where cod = ?");
            stmt.setInt(1, cod);
            int qtdAfetado = stmt.executeUpdate();
            if (qtdAfetado>0){
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(LivroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
        return false;        
    }
}
