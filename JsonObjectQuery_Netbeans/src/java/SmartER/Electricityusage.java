/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SmartER;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author levuanhuyen
 */
@Entity
@Table(name = "ELECTRICITYUSAGE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Electricityusage.findAll", query = "SELECT e FROM Electricityusage e")
    , @NamedQuery(name = "Electricityusage.findByUsageid", query = "SELECT e FROM Electricityusage e WHERE e.usageid = :usageid")
    , @NamedQuery(name = "Electricityusage.findByDate", query = "SELECT e FROM Electricityusage e WHERE e.date = :date")
    , @NamedQuery(name = "Electricityusage.findByHourusage", query = "SELECT e FROM Electricityusage e WHERE e.hourusage = :hourusage")
    , @NamedQuery(name = "Electricityusage.findResidentBySurnameAndEmail3d", query = "SELECT e FROM Electricityusage e WHERE e.resid.surname = :surname AND e.resid.email = :email")
    , @NamedQuery(name = "Electricityusage.findByFridge", query = "SELECT e FROM Electricityusage e WHERE e.fridge = :fridge")
    , @NamedQuery(name = "Electricityusage.findByAirconditioner", query = "SELECT e FROM Electricityusage e WHERE e.airconditioner = :airconditioner")
    , @NamedQuery(name = "Electricityusage.findByWashingmachine", query = "SELECT e FROM Electricityusage e WHERE e.washingmachine = :washingmachine")
    , @NamedQuery(name = "Electricityusage.findByTemperature", query = "SELECT e FROM Electricityusage e WHERE e.temperature = :temperature")})
    
        
public class Electricityusage implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "USAGEID")
    private Integer usageid;
    @Column(name = "DATE")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Column(name = "HOURUSAGE")
    private Integer hourusage;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "FRIDGE")
    private Double fridge;
    @Column(name = "AIRCONDITIONER")
    private Double airconditioner;
    @Column(name = "WASHINGMACHINE")
    private Double washingmachine;
    @Column(name = "TEMPERATURE")
    private Double temperature;
    @JoinColumn(name = "RESID", referencedColumnName = "RESID")
    @ManyToOne
    private Resident resid;

    public Electricityusage() {
    }

    public Electricityusage(Integer usageid) {
        this.usageid = usageid;
    }

    public Integer getUsageid() {
        return usageid;
    }

    public void setUsageid(Integer usageid) {
        this.usageid = usageid;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getHourusage() {
        return hourusage;
    }

    public void setHourusage(Integer hourusage) {
        this.hourusage = hourusage;
    }

    public Double getFridge() {
        return fridge;
    }

    public void setFridge(Double fridge) {
        this.fridge = fridge;
    }

    public Double getAirconditioner() {
        return airconditioner;
    }

    public void setAirconditioner(Double airconditioner) {
        this.airconditioner = airconditioner;
    }

    public Double getWashingmachine() {
        return washingmachine;
    }

    public void setWashingmachine(Double washingmachine) {
        this.washingmachine = washingmachine;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public Resident getResid() {
        return resid;
    }

    public void setResid(Resident resid) {
        this.resid = resid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usageid != null ? usageid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Electricityusage)) {
            return false;
        }
        Electricityusage other = (Electricityusage) object;
        if ((this.usageid == null && other.usageid != null) || (this.usageid != null && !this.usageid.equals(other.usageid))) {
            return false;
        }
        return true;
    }
    
    //4d:
    
    

    @Override
    public String toString() {
        return "SmartER.Electricityusage[ usageid=" + usageid + " ]";
    }
    
}
