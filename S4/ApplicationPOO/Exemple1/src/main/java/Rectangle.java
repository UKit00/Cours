/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Israel
 */
public class Rectangle {
    
    private long larg, longu;
    
    public void Rectangle() {
        
    }
    
    public void Rectangle(long larg, long longu){
        this.larg = larg;
        this.longu = longu;
    }

    public long getLarg() {
        return larg;
    }

    public long getLongu() {
        return longu;
    }

    public void setLarg(long larg) {
        this.larg = larg;
    }

    public void setLongu(long longu) {
        this.longu = longu;
    }
    
    
    
    
    public long perimetre(){
        return (this.getLongu() + this.getLarg())/2;
    }
    
    public void aire(){
        return this.getLongu()*this.getLarg();
    }
    
    public void toString(){
        System.out.println("Longueur = "+ this.getLongu());;
        this.getLarg();
        this.perimetre();        
        this.aire();
    }
    
    
    
    
    
    
    
}
