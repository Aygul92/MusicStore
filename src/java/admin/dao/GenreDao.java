/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.dao;

import admin.entity.Genre;
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
public class GenreDao  implements DAO<Genre> {

    @Override
    public void create(Genre genre) {
        
          try {
			Connection c = ConnectionManager.getConnection();
			Statement s = c.createStatement();
			String sql = "";
			sql = "insert into Genre (Genre_id,Genre_name) values ('" + ((Genre) genre).getGenre_id() + "', '" + ((Genre) genre).getGenre_name() + "'";
			s.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
        
    }

   

    @Override
    public ArrayList<Genre> list() {
       ArrayList<Genre> cList = new ArrayList();
		try {
			Connection c = ConnectionManager.getConnection();
			Statement s = c.createStatement();
			String sql = "select * from Genre";
			ResultSet rs = s.executeQuery(sql);
			while (rs.next()) {
				cList.add(new Genre(rs.getInt("Genre_id"), rs.getString("Genre_name")));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return cList;
        
        
    }

    @Override
    public ArrayList<Genre> pagedList(int page) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Genre genre) {
        try {
			Connection c = ConnectionManager.getConnection();
			Statement s = c.createStatement();
			String sql = "delete from Genre where Genre_id=" + genre.getGenre_id();
			s.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
        
       }

    @Override
    public Genre detail(String st) {
        
         Genre genre = null;
		try {
			Connection c = ConnectionManager.getConnection();
			Statement s = c.createStatement();
			String sql = "select * from Genre where Genre_id=" + st;
			ResultSet rs = s.executeQuery(sql);
			rs.next();
			genre = new Genre(rs.getInt("Genre_id"), rs.getString("Genre_name"));
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return genre;
        
        
        
        
        
    }
    
}
