/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.controller;

import admin.dao.AlbumDao;
import admin.dao.ArtistDao;
import admin.dao.GenreDao;
import admin.entity.Album;
import admin.entity.Artist;
import admin.entity.Genre;
import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author apple
 */
@ManagedBean(name="AlbumController")
@SessionScoped
public class AlbumBean implements Serializable {
    
    private Album album;
    private AlbumDao albD;
    private ArrayList<Album> albList;
    
    private ArrayList<Artist> arList;
    private ArtistDao arD;
    
     private ArrayList<Genre> genList;
    private GenreDao genD;


	public String create() {
		this.getAlbD().create(this.album);
		return "/admin/Album/index?faces-redirect=true";
	}

	public String createForm() {
		return "/admin/Album/newform?faces-redirect=true";
	}

	

	public String delete(Album album) {
		this.getAlbD().delete(album);
		return "/admin/Album/index?faces-redirect=true";
	}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public Album getAlbum() {
        
        if (this.album == null) {
			this.album = new Album();
		}
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public AlbumDao getAlbD() {
        
        if (this.albD == null) {
			this.albD = new AlbumDao();
		}
        return albD;
    }

    public void setAlbD(AlbumDao albD) {
        this.albD = albD;
    }

    public ArrayList<Album> getAlbList() {
        
        
        this.albList = new ArrayList();
		this.albList = this.getAlbD().list();
                
        return albList;
    }

    public void setAlbList(ArrayList<Album> albList) {
        this.albList = albList;
    }

    public ArrayList<Artist> getArList() {
        
        
        this.arList = new ArrayList();
		this.arList = this.getArD().list();
        return arList;
    }

    public void setArList(ArrayList<Artist> arList) {
        this.arList = arList;
    }

    public ArtistDao getArD() {
        if (this.arD == null) {
			this.arD = new ArtistDao();
		}
        
        
        return arD;
    }

    public void setArD(ArtistDao arD) {
        this.arD = arD;
    }

    public ArrayList<Genre> getGenList() {
        
         this.genList = new ArrayList();
		this.genList = this.getGenD().list();
        
        
        return genList;
    }

    public void setGenList(ArrayList<Genre> genList) {
        this.genList = genList;
    }

    public GenreDao getGenD() {
       
        if (this.genD == null) {
			this.genD = new GenreDao();
		}
        return genD;
    }

    public void setGenD(GenreDao genD) {
        this.genD = genD;
    }
    
    
    
    
    
    
    
    
    
}
