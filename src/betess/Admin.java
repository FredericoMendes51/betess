/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package betess;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author misterfour
 */
public class Admin {
    private int idAdmin;
    private String username;
    private String password;
    private boolean log;
    
    public Admin(String idAdmin, String username, String password, Boolean log){
        this.idAdmin = idAdmin;
        this.username = username;
        this.password = password;
        this.log=log;
    }
    
    public Admin(Admin a){
        this.idAdmin = a.getIdAdmin();
        this.username = a.getUsername();
        this.password = a.getPassword();
        this.log = a.getLog();
    }
    
    //get's
    public int getIdAdmin(){
        return this.idAdmin;
    }
    
    public String getUsername(){
        return this.username;
    }
    
    public String getPassword(){
        return this.password;
    }
   
    public Boolean getLog(){
        return this.log;
    }
    
    //set's
    public void setIdAdmin(int idAdmin) {
        this.idAdmin = idAdmin;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setLog(boolean log) {
        this.log = log;
    }

    @Override
    public Admin clone() {
        return new Admin(this);
    }
    
    public boolean equals(Admin a) {
        if (this == a) {
            return true;
        }
        if ((a == null) || (this.getClass() != a.getClass())) {
            return false;
        }
        Admin e = (Admin) a;
        return this.idAdmin==(e.getIdAdmin());
    }
    
    @Override
    public String toString() {
        return "Admin:" + "idAdmin=" + idAdmin + ", username=" + username + '.';
    }

}