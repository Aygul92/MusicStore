/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.controller;

import admin.dao.ArtistDao;
import admin.entity.Artist;
import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author apple
 */

@ManagedBean(name="ArtistController")
@SessionScoped
public class ArtistBean implements Serializable {
    
    
    private Artist artist;
	private ArtistDao arDao;
	private ArrayList<Artist> artistList;
        
        
        
        
        public String create() {
		this.getArDao().create(this.artist);
		return "/admin/Artist/index?faces-redirect=true";
	}
        public String createForm() {
		return "/admin/Artist/newform?faces-redirect=true";
	}
        
        
        public String delete(Artist ar) {
		this.getArDao().delete(ar);
		return "/admin/Artist/index?faces-redirect=true";
	}

    public Artist getArtist() {
         if ( this.artist== null )
			this.artist = new Artist();
		
        
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public ArtistDao getArDao() {
        
        
        if( this.arDao == null )
			this.arDao = new ArtistDao();
		

        return arDao;
    }

    public void setArDao(ArtistDao arDao) {
        this.arDao = arDao;
    }

    public ArrayList<Artist> getArtistList() {
        
          this.artistList = new ArrayList();
		this.artistList = this.getArDao().list();
                
		
        
        
        return artistList;
    }

    public void setArtistList(ArrayList<Artist> artistList) {
        this.artistList = artistList;
    }

    
    
    
    
    
    
    
    
    
    
    
    
}
