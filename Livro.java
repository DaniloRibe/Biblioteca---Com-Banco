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
public class Livro {
    private int cod;
    private String titulo;
    private String autor;
    private String editora;


    public Livro(int cod, String titulo, String autor, String editora) {
        this.cod = cod;
        this.titulo = titulo;
        this.autor = autor;
        this.editora = editora;
       
    }

    public Livro() {
        
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }
    
    

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }



    @Override
    public String toString() {
        return "Livro{" + "cod=" + cod + ", titulo=" + titulo + ", autor=" + autor + ", editora=" + editora + '}';
    }
    
    
}
