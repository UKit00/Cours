/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Israel
 */
public class Complexe {
    
    private double pReel;
    private double pImag;

    public Complexe(double pReel, double pImag) {
        this.pReel = pReel;
        this.pImag = pImag;
    }

    public double partieRC() {
        return pReel;
    }

    public double partieIC() {
        return pImag;
    }
    
    public double module () {
        return ;
    }
    
    public Complexe oppose(){
        this.pImag = -(this.pImag);
        this.pReel = -(this.pReel);
        return this;
    }
    
    public Complexe conjuge(){
        Math.cos
        Math.cos(pImag);
        this.pImag = -(this.pImag);
        return this;
    }
    
    
}
