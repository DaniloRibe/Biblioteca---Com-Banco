/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import connection.ConnectionFactory;
import dao.LivroDAO;
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
public class LivroController {
    
    LivroDAO ld = new LivroDAO();
    
    public Livro buscarLivroPorTitulo(String titulo){
        return ld.read(titulo);
    }
    
    public boolean addLivro(int cod, String titulo, String autor, String editora){
        Livro l = new Livro();
        l.setCod(cod);
        l.setTitulo(titulo);
        l.setAutor(autor);
        l.setEditora(editora);
        return ld.create(l);
    }
    
    public boolean delLivro(int cod){
        return ld.delete(cod);
    }
    
    public void listLivro(){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            stmt = con.prepareStatement("select * from livro");
            rs = stmt.executeQuery();
            while (rs.next()){
                Livro l = new Livro();
                l.setCod(rs.getInt(1));
                l.setTitulo(rs.getString(2));
                l.setAutor(rs.getString(3));
                l.setEditora(rs.getString(4));
                
                System.out.println(l);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LivroController.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
    }
    
}
