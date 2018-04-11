/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SmartER;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author levuanhuyen
 */
@Entity
@Table(name = "RESIDENT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Resident.findAll", query = "SELECT r FROM Resident r")
    , @NamedQuery(name = "Resident.findByResid", query = "SELECT r FROM Resident r WHERE r.resid = :resid")
    , @NamedQuery(name = "Resident.findByFirstname", query = "SELECT r FROM Resident r WHERE r.firstname = :firstname")
    , @NamedQuery(name = "Resident.findByUpperFirstname", query = "SELECT r FROM Resident r WHERE UPPER(r.firstname) = UPPER(:firstname)") 
    , @NamedQuery(name = "Resident.findBySurname", query = "SELECT r FROM Resident r WHERE r.surname = :surname")
    , @NamedQuery(name = "Resident.findByUpperSurname", query = "SELECT r FROM Resident r WHERE UPPER(r.surname) = UPPER(:surname)") 
    , @NamedQuery(name = "Resident.findByDob", query = "SELECT r FROM Resident r WHERE r.dob = :dob")
    , @NamedQuery(name = "Resident.findByAddress", query = "SELECT r FROM Resident r WHERE r.address = :address")
    , @NamedQuery(name = "Resident.findByPostcode", query = "SELECT r FROM Resident r WHERE r.postcode = :postcode")
    , @NamedQuery(name = "Resident.findByEmail", query = "SELECT r FROM Resident r WHERE r.email = :email")
    , @NamedQuery(name = "Resident.findByMobile", query = "SELECT r FROM Resident r WHERE r.mobile = :mobile")
    , @NamedQuery(name = "Resident.findByNumberofresident", query = "SELECT r FROM Resident r WHERE r.numberofresident = :numberofresident")
    , @NamedQuery(name = "Resident.findByEnergyprovider", query = "SELECT r FROM Resident r WHERE r.energyprovider = :energyprovider")})
public class Resident implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "RESID")
    private Integer resid;
    @Size(max = 50)
    @Column(name = "FIRSTNAME")
    private String firstname;
    @Size(max = 50)
    @Column(name = "SURNAME")
    private String surname;
    @Column(name = "DOB")
    @Temporal(TemporalType.DATE)
    private Date dob;
    @Size(max = 100)
    @Column(name = "ADDRESS")
    private String address;
    @Size(max = 50)
    @Column(name = "POSTCODE")
    private String postcode;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 50)
    @Column(name = "EMAIL")
    private String email;
    @Size(max = 50)
    @Column(name = "MOBILE")
    private String mobile;
    @Column(name = "NUMBEROFRESIDENT")
    private Integer numberofresident;
    @Size(max = 50)
    @Column(name = "ENERGYPROVIDER")
    private String energyprovider;
    @OneToMany(mappedBy = "resid")
    private Collection<Electricityusage> electricityusageCollection;
    @OneToMany(mappedBy = "resid")
    private Collection<Residentcredentials> residentcredentialsCollection;

    public Resident() {
    }

    public Resident(Integer resid) {
        this.resid = resid;
    }

    public Integer getResid() {
        return resid;
    }

    public void setResid(Integer resid) {
        this.resid = resid;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Integer getNumberofresident() {
        return numberofresident;
    }

    public void setNumberofresident(Integer numberofresident) {
        this.numberofresident = numberofresident;
    }

    public String getEnergyprovider() {
        return energyprovider;
    }

    public void setEnergyprovider(String energyprovider) {
        this.energyprovider = energyprovider;
    }

    @XmlTransient
    public Collection<Electricityusage> getElectricityusageCollection() {
        return electricityusageCollection;
    }

    public void setElectricityusageCollection(Collection<Electricityusage> electricityusageCollection) {
        this.electricityusageCollection = electricityusageCollection;
    }

    @XmlTransient
    public Collection<Residentcredentials> getResidentcredentialsCollection() {
        return residentcredentialsCollection;
    }

    public void setResidentcredentialsCollection(Collection<Residentcredentials> residentcredentialsCollection) {
        this.residentcredentialsCollection = residentcredentialsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (resid != null ? resid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Resident)) {
            return false;
        }
        Resident other = (Resident) object;
        if ((this.resid == null && other.resid != null) || (this.resid != null && !this.resid.equals(other.resid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "SmartER.Resident[ resid=" + resid + " ]";
    }
    
}
