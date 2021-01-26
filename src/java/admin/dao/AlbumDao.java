/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.dao;

import admin.entity.Album;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import utility.ConnectionManager;

/**
 *
 * @author apple
 */
public class AlbumDao  implements DAO<Album> {
private ArtistDao arD;
private GenreDao gnD;

    public ArtistDao getArD() {
        if ( this.arD == null )
			this.arD = new ArtistDao();
        return arD;
    }

    public void setArD(ArtistDao arD) {
        this.arD = arD;
    }

    public GenreDao getGnD() {
         if ( this.gnD == null )
			this.gnD = new GenreDao();
        return gnD;
    }

    public void setGnD(GenreDao gnD) {
        this.gnD = gnD;
    }
    
    @Override
    public void create(Album alb) {
        
        
         try {
			Connection c = ConnectionManager.getConnection();
			Statement s = c.createStatement();
			String sql = "";
			sql = "insert into Album (album_id,artist_name,title,price,genre_name) values ('" + ((Album) alb).getAlbum_id() + "', '" + ((Album) alb).getArtist().getArtist_id() + "','" + ((Album) alb).getTitle() + "' ,'" + ((Album) alb).getPrice() + "','" + ((Album) alb).getGenre().getGenre_id() + "'";
			s.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
        
    }
    

    

    @Override
    public ArrayList<Album> list() {
      
        
        ArrayList<Album> albList = new ArrayList();
		try {
			Connection c = ConnectionManager.getConnection();
			Statement s = c.createStatement();
			String sql = "select * from Album";
			ResultSet rs = s.executeQuery(sql);
			
			while (rs.next()) {
				albList.add(new Album(rs.getInt("album_id"), this.getArD().detail(rs.getString("artist_name")), rs.getString("title"),rs.getInt("price"), this.getGnD().detail(rs.getString("genre_name"))));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return albList;
    }

    @Override
    public ArrayList<Album> pagedList(int page) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Album album) {
        
        try {
			Connection c = ConnectionManager.getConnection();
			Statement s = c.createStatement();
			String sql = "delete from Album where id=" + album.getAlbum_id();
			s.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
    }

    @Override
    public Album detail(String st) {
        
        
        
        Album album = null;
		try {
			Connection c = ConnectionManager.getConnection();
			Statement s = c.createStatement();
			String sql = "select * from Album where title='" + st + "'";
			ResultSet rs = s.executeQuery(sql);
			rs.next();
			album = new Album(rs.getInt("album_id"), this.getArD().detail(rs.getString("artist_name")), rs.getString("title"),rs.getInt("price"), this.getGnD().detail(rs.getString("genre_name")));
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return album;
        
        
        
        
    }
    
}
