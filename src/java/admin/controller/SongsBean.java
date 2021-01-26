/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.controller;

import admin.dao.ArtistDao;
import admin.dao.SongsDao;
import admin.entity.Artist;
import admin.entity.Songs;
import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author apple
 */
@ManagedBean(name="SongController")
@SessionScoped
public class SongsBean implements Serializable{
    
    private Songs song;
    private SongsDao sogD;
     private ArrayList<Songs> sogList;
    
     private ArrayList<Artist> arList;
    private ArtistDao arD;

    
    
    public String create() {
		this.getSogD().create(this.song);
		return "/admin/Songs/index?faces-redirect=true";
	}

	public String createForm() {
		return "/admin/Songs/newform?faces-redirect=true";
	}

	

	public String delete(Songs song) {
		this.getSogD().delete(song);
		return "/admin/Songs/index?faces-redirect=true";
	}
    
    
    
    
    
    
    
    
    
    
    
    public Songs getSong() {
        
         if (this.song == null) {
			this.song = new Songs();
		}
        
        return song;
    }

    public void setSong(Songs song) {
        this.song = song;
    }

    public SongsDao getSogD() {
        
         if (this.sogD == null) {
			this.sogD = new SongsDao();
		}
        return sogD;
    }

    public void setSogD(SongsDao sogD) {
        this.sogD = sogD;
    }

    public ArrayList<Songs> getSogList() {
        
        this.sogList = new ArrayList();
		this.sogList = this.getSogD().list();
        
        
        return sogList;
    }

    public void setSogList(ArrayList<Songs> sogList) {
        this.sogList = sogList;
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
    
    
    
    
    
    
    
    
    
    
}
