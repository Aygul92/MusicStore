/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.dao;

import admin.entity.Artist;

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
public class ArtistDao  implements DAO<Artist> {

    @Override
    public void create(Artist ar) {
       
        
          try {
			Connection c = ConnectionManager.getConnection();
			Statement s = c.createStatement();
			String sql = "";
			sql = "insert into Artist (artist_id,artist_name) values ('" + ((Artist) ar).getArtist_id() + "', '" + ((Artist) ar).getArtist_name() + "'";
			s.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
    }

    

    @Override
    public ArrayList<Artist> list() {
        
        
        
         ArrayList<Artist> cList = new ArrayList();
		try {
			Connection c = ConnectionManager.getConnection();
			Statement s = c.createStatement();
			String sql = "select * from Artist";
			ResultSet rs = s.executeQuery(sql);
			while (rs.next()) {
				cList.add(new Artist(rs.getInt("artist_id"), rs.getString("artist_name")));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return cList;
    }

    @Override
    public ArrayList<Artist> pagedList(int page) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Artist artist) {
       
         try {
			Connection c = ConnectionManager.getConnection();
			Statement s = c.createStatement();
			String sql = "delete from Artist where artist_id=" + artist.getArtist_id();
			s.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
        
        
        
    }

    @Override
    public Artist detail(String st) {
       
           Artist artist = null;
		try {
			Connection c = ConnectionManager.getConnection();
			Statement s = c.createStatement();
			String sql = "select * from Artist where artist_id=" + st;
			ResultSet rs = s.executeQuery(sql);
			rs.next();
			artist = new Artist(rs.getInt("artist_id"), rs.getString("artist_name"));
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return artist;
        
    }
    
}
