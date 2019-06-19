/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import connection.ConnectionFactory;
import dao.ClienteDAO;
import dao.LivroDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Cliente;
import model.Emprestimo;
import model.Livro;

/**
 *
 * @author Danilo
 */
public class EmprestimoController {
    
    public void listEmprestimos(){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            stmt = con.prepareStatement("select * from emprestimo");
            rs = stmt.executeQuery();
            while(rs.next()){
                Emprestimo e = new Emprestimo();
                e.setCod(rs.getInt(1));
                e.setCodLivro(rs.getInt(2));
                e.setCpfCliente(rs.getString(3));
                System.out.println(e);                
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmprestimoController.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
    }
    
    public void pegarLivro(int codLivro, String cpfCliente){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            stmt = con.prepareStatement("select * from emprestimo where cod_livro = ? and cpf_cliente = ?");
            stmt.setInt(1, codLivro);
            stmt.setString(2, cpfCliente);
            rs = stmt.executeQuery();
            
            if (rs.next()){
                System.out.println("Você já pegou este livro");
                ConnectionFactory.closeConnection(con, stmt, rs);
                
            }else{
                try{
                    stmt = con.prepareStatement("insert into emprestimo (cod_livro, cpf_cliente) values (?, ?)");
                    stmt.setInt(1, codLivro);
                    stmt.setString(2, cpfCliente);
                    stmt.executeUpdate();
                    System.out.println("operação realizada!");
                }catch (SQLException ex){
                    System.out.println("CPF ou Codigo inexistente "+ ex);
                }finally{
                    ConnectionFactory.closeConnection(con, stmt);
                }
            }
        } catch (SQLException ex) {
            System.out.println("Erro na operacao!" + ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
    }
    
    public void devolverLivro(int cod, String cpfCliente){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("delete from emprestimo where cod_livro = ? and cpf_cliente = ?");
            stmt.setInt(1, cod);
            stmt.setString(2, cpfCliente);
            int qtdAfetado = stmt.executeUpdate();
            if (qtdAfetado>0){               
                System.out.println("Operação realizada!");
            }else{
                System.out.println("Erro na operação");
            }
        } catch (SQLException ex) {
            System.out.println("Erro na operação "+ ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
}
