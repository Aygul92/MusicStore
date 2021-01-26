/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Home.controller;

import Home.dao.UsersDao;
import Home.entity.Users;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author apple
 */
@ManagedBean(name="registController")
@SessionScoped
public class UserBean {
    
    private Users user;
    private UsersDao usD;
    
    public String create() {
		this.getUsD().create(this.user);
		return "/Home/login.xhtml";
	}

	public String createForm() {
		return "/Home/login?faces-redirect=true";
	}
    
    
    
    
    

    public Users getUser() {
           if (this.user == null) {
			this.user = new Users();
		}
        
        
        
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public UsersDao getUsD() {
        
        
        if (this.usD == null) {
			this.usD = new UsersDao();
		}
        return usD;
    }

    public void setUsD(UsersDao usD) {
        this.usD = usD;
    }
    
    
    
    
    
    
    
}
