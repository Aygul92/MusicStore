/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.dao;

import java.util.ArrayList;

/**
 *
 * @author apple
 */
public interface DAO<T> {
    
    
    void create(T o);
	ArrayList<T> list();
	ArrayList<T> pagedList(int page);
	void delete(T o);
	T detail(String st);
    
    
}
