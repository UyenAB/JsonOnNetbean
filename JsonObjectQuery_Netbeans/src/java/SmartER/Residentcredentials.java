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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author levuanhuyen
 */
@Entity
@Table(name = "RESIDENTCREDENTIALS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Residentcredentials.findAll", query = "SELECT r FROM Residentcredentials r")
    , @NamedQuery(name = "Residentcredentials.findByUsername", query = "SELECT r FROM Residentcredentials r WHERE r.username = :username")
    , @NamedQuery(name = "Residentcredentials.findByPassword", query = "SELECT r FROM Residentcredentials r WHERE r.password = :password")
    , @NamedQuery(name = "Residentcredentials.findByRegistrationdate", query = "SELECT r FROM Residentcredentials r WHERE r.registrationdate = :registrationdate")})
public class Residentcredentials implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "USERNAME")
    private String username;
    @Size(max = 50)
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "REGISTRATIONDATE")
    @Temporal(TemporalType.DATE)
    private Date registrationdate;
    @JoinColumn(name = "RESID", referencedColumnName = "RESID")
    @ManyToOne
    private Resident resid;

    public Residentcredentials() {
    }

    public Residentcredentials(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getRegistrationdate() {
        return registrationdate;
    }

    public void setRegistrationdate(Date registrationdate) {
        this.registrationdate = registrationdate;
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
        hash += (username != null ? username.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Residentcredentials)) {
            return false;
        }
        Residentcredentials other = (Residentcredentials) object;
        if ((this.username == null && other.username != null) || (this.username != null && !this.username.equals(other.username))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "SmartER.Residentcredentials[ username=" + username + " ]";
    }
    
}
