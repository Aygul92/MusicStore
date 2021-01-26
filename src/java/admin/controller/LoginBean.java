/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.controller;

import admin.dao.usersDao;
import admin.entity.users;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import utility.SessionUtility;

/**
 *
 * @author apple
 */
@ManagedBean(name = "login")
@SessionScoped
public class LoginBean  implements Serializable {
    
    private users user;
	private usersDao userDao;
	private boolean loggedIn = false;

    public String login() {
		users a = this.getUserDao().login(this.user);
		if (a != null) {
			this.loggedIn = true;
			HttpSession session = SessionUtility.getSession();
			session.setAttribute("user", a);
			return "/TemplateAdmin/Layout1?faces-redirect=true";
		} else {
			return "/TemplateAdmin/Layout1?faces-redirect=true";
		}
	}
public String doLogout() {

		this.setLoggedIn(false);

		FacesMessage msg = new FacesMessage("Logout success!", "INFO MSG");
		msg.setSeverity(FacesMessage.SEVERITY_INFO);
		FacesContext.getCurrentInstance().addMessage(null, msg);
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/TemplateAdmin/login?faces-redirect=true";
	}
    public users getUser() {
        
      if (this.user == null) {
			this.user = new users();
		}
		return user;
    }

    public void setUser(users user) {
        this.user = user;
    }

    public usersDao getUserDao() {
        
        if (this.userDao == null) {
			this.userDao = new usersDao();
		}
		return userDao;
    }

    public void setUserDao(usersDao userDao) {
        this.userDao = userDao;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }
    
    
    
    
    
    
    
    
    
    
    
    
}
