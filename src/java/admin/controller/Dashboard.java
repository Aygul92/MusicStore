/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.controller;

import admin.dao.AlbumDao;
import admin.dao.ArtistDao;
import admin.dao.GenreDao;
import admin.dao.SongsDao;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author apple
 */

@ManagedBean(name="dashboard")
@SessionScoped
public class Dashboard implements Serializable {
    
    private int albumcount;
    private int genrecount;
    private int artistcount;
    private int songscount;
    
    private AlbumDao albD;
    private GenreDao genD;
    private ArtistDao arD;
    private SongsDao sogD;

    public int getAlbumcount() {
        this.albumcount = this.getAlbD().list().size();
        
        
        return albumcount;
    }

    public void setAlbumcount(int albumcount) {
        this.albumcount = albumcount;
    }

    public int getGenrecount() {
                this.genrecount = this.getGenD().list().size();

        return genrecount;
    }

    public void setGenrecount(int genrecount) {
        this.genrecount = genrecount;
    }

    public int getArtistcount() {
         this.artistcount = this.getArD().list().size();
        
        return artistcount;
    }

    public void setArtistcount(int artistcount) {
        this.artistcount = artistcount;
    }

    public int getSongscount() {
         this.songscount = this.getSogD().list().size();
        
        
        return songscount;
    }

    public void setSongscount(int songscount) {
        this.songscount = songscount;
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

    public GenreDao getGenD() {
        if ( this.genD == null )
			this.genD = new GenreDao();
        return genD;
    }

    public void setGenD(GenreDao genD) {
        this.genD = genD;
    }

    public ArtistDao getArD() {
        if( this.arD == null )
			this.arD = new ArtistDao();
        return arD;
    }

    public void setArD(ArtistDao arD) {
        this.arD = arD;
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
    
    
    
    
    
    
    
}
