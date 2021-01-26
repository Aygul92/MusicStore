/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.controller;

import admin.dao.GenreDao;
import admin.entity.Genre;
import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author apple
 */
@ManagedBean(name="GenreController")
@SessionScoped
public class GenreBean implements Serializable{
    
    private Genre genre;
	private GenreDao gDao;
	private ArrayList<Genre> genreList;

        public String create() {
		this.getgDao().create(this.genre);
		return "/admin/Genre/index?faces-redirect=true";
	}
         
        public String createForm() {
		return "/admin/Genre/newform?faces-redirect=true";
	}
        public String delete(Genre gen) {
		this.getgDao().delete(gen);
		return "/admin/Genre/index?faces-redirect=true";
	}
    public Genre getGenre() {
        if ( this.genre== null )
			this.genre = new Genre();
		return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public GenreDao getgDao() {
if ( this.gDao == null )
			this.gDao = new GenreDao();
		return gDao;    }

    public void setgDao(GenreDao gDao) {
        this.gDao = gDao;
    }

    public ArrayList<Genre> getGenreList() {
        this.genreList = new ArrayList();
		this.genreList = this.getgDao().list();
                
		return genreList;
        
        
    }

    public void setGenreList(ArrayList<Genre> genreList) {
        this.genreList = genreList;
    }
	
    
    
    
    
    
    
    
    
}
