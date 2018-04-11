/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SmartER;

import static SmartER.Electricityusage_.date;
import static SmartER.Electricityusage_.hourusage;
import static SmartER.Resident_.resid;
import java.util.Date;

/**
 *
 * @author levuanhuyen
 */
public class highestTotalHourlyPowerConsumption {

//    public void setResid(Integer resid) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

    private int resid;
    private Double highestConsump;
    private String date;
    private int hourusage;
 
    
    public highestTotalHourlyPowerConsumption() {
    }
    
    
   public highestTotalHourlyPowerConsumption(int resid,double highestConsump, String date, int hourusage ) {
    }
    

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getHourusage() {
        return hourusage;
    }

    public void setHourusage(Integer hourusage) {
        this.hourusage = hourusage;
    }

    public Double getHighestConsump() {
        return highestConsump;
    }

    public void setHighestConsump(double highestConsump) {
        this.highestConsump = highestConsump;
    }


    public int getResid() {
        return  resid;
    }

    public void setResid(int resid) {
        this.resid = resid;
    }

    public void setResid(Integer resid) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}