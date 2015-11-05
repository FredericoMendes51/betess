/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package betess;

import java.util.Date;

/**
 *
 * @author misterfour
 */
public class Odd {
    
    private double oddUm;
    private double oddDois;
    private double oddX;
    private Date timestamp;
    
    public Odd(){
        this.oddUm = 0.0;
        this.oddX = 0.0;
        this.oddDois = 0.0;
        this.timestamp = new Date();
    }
    
    public Odd(double odd1, double oddx, double odd2, Date time){
        this.oddUm = odd1;
        this.oddX = oddx;
        this.oddDois = odd2;
        this.timestamp = time;
    }
    
    public Odd(Odd o){
        this.oddUm = o.getOddUm();
        this.oddX = o.getOddX();
        this.oddDois = o.getOddDois();
        this.timestamp = o.getTimestamp();
    }
    
    
    
    public double getOddUm() {
        return this.oddUm;
    }

    public double getOddDois() {
        return this.oddDois;
    }

    public double getOddX() {
        return this.oddX;
    }
    
    public Date getTimestamp(){
        return this.timestamp;
    }
    
    
    
    public void setOddUm(double oddUm) {
        this.oddUm = oddUm;
    }

    public void setOddDois(double oddDois) {
        this.oddDois = oddDois;
    }

    public void setOddX(double oddX) {
        this.oddX = oddX;
    }
    
    public void setTimestamp(Date time){
        this.timestamp = time;
    }

    public Odd clone() {
        return new Odd(this);
    } 
    
    public boolean equals(Odd j) {
        if (this == j) {
            return true;
        }
        if ((j == null) || (this.getClass() != j.getClass())) {
            return false;
        }
        Odd e = (Odd) j;
        return this.oddUm==(e.getOddUm()) && this.oddX==(e.getOddX()) && this.oddDois==(e.getOddDois()) && this.timestamp.equals(e.getTimestamp());
    }
    
    public String toString(){
        StringBuilder s = new StringBuilder();
        s.append(this.oddUm).append("-").append(this.oddX).append("-").append(this.oddDois).append("-").append(this.timestamp);

        return s.toString();
    }
    
    
    
    
}
