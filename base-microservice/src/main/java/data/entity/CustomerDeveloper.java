package data.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * customer developer
 * Created by 刘佳兴 on 16-4-13.
 */
@Entity
@javax.persistence.Table(name = "customer_developer")
public class CustomerDeveloper {
    protected Long id;

    @Id
    @javax.persistence.Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    protected Long userid;

    @Basic
    @javax.persistence.Column(name = "userid", nullable = true)
    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    protected String companyname;

    @Basic
    @javax.persistence.Column(name = "companyname", nullable = true, length = 80)
    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    protected String ceoname;

    @Basic
    @javax.persistence.Column(name = "ceoname", nullable = true, length = 20)
    public String getCeoname() {
        return ceoname;
    }

    public void setCeoname(String ceoname) {
        this.ceoname = ceoname;
    }

    protected Long country;

    @Basic
    @javax.persistence.Column(name = "country", nullable = true)
    public Long getCountry() {
        return country;
    }

    public void setCountry(Long country) {
        this.country = country;
    }

    protected String state;

    @Basic
    @javax.persistence.Column(name = "state", nullable = true, length = 50)
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    protected String city;

    @Basic
    @javax.persistence.Column(name = "city", nullable = true, length = 50)
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    protected String address1;

    @Basic
    @javax.persistence.Column(name = "address1", nullable = true, length = 128)
    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    protected String address2;

    @Basic
    @javax.persistence.Column(name = "address2", nullable = true, length = 128)
    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    protected Integer employees;

    @Basic
    @javax.persistence.Column(name = "employees", nullable = true)
    public Integer getEmployees() {
        return employees;
    }

    public void setEmployees(Integer employees) {
        this.employees = employees;
    }

    protected String contactpersonname;

    @Basic
    @javax.persistence.Column(name = "contactpersonname", nullable = true, length = 32)
    public String getContactpersonname() {
        return contactpersonname;
    }

    public void setContactpersonname(String contactpersonname) {
        this.contactpersonname = contactpersonname;
    }

    protected String website;

    @Basic
    @javax.persistence.Column(name = "website", nullable = true, length = 255)
    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    protected String telephone;

    @Basic
    @javax.persistence.Column(name = "telephone", nullable = true, length = 30)
    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    protected String fax;

    @Basic
    @javax.persistence.Column(name = "fax", nullable = true, length = 30)
    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    protected Date founddate;

    @Basic
    @javax.persistence.Column(name = "founddate", nullable = true)
    public Date getFounddate() {
        return founddate;
    }

    public void setFounddate(Date founddate) {
        this.founddate = founddate;
    }

    protected String operationarea;

    @Basic
    @javax.persistence.Column(name = "operationarea", nullable = true, length = 80)
    public String getOperationarea() {
        return operationarea;
    }

    public void setOperationarea(String operationarea) {
        this.operationarea = operationarea;
    }

    protected String abn;

    public CustomerDeveloper() {
    }

    public CustomerDeveloper(Long id) {
        this.id = id;
    }

    @Basic
    @javax.persistence.Column(name = "abn", nullable = true, length = 255)
    public String getAbn() {
        return abn;
    }

    public void setAbn(String abn) {
        this.abn = abn;
    }

    protected String acn;

    @Basic
    @javax.persistence.Column(name = "acn", nullable = true, length = 20)
    public String getAcn() {
        return acn;
    }

    public void setAcn(String acn) {
        this.acn = acn;
    }

    protected String companyprofile;

    @Basic
    @javax.persistence.Column(name = "companyprofile", nullable = true, length = 255)
    public String getCompanyprofile() {
        return companyprofile;
    }

    public void setCompanyprofile(String companyprofile) {
        this.companyprofile = companyprofile;
    }

    protected Long createdby;

    @Basic
    @javax.persistence.Column(name = "createdby", nullable = true)
    public Long getCreatedby() {
        return createdby;
    }

    public void setCreatedby(Long createdby) {
        this.createdby = createdby;
    }

    protected Date createddtm;

    @Basic
    @javax.persistence.Column(name = "createddtm", nullable = true)
    public Date getCreateddtm() {
        return createddtm;
    }

    public void setCreateddtm(Date createddtm) {
        this.createddtm = createddtm;
    }

    protected Long updatedby;

    @Basic
    @javax.persistence.Column(name = "updatedby", nullable = true)
    public Long getUpdatedby() {
        return updatedby;
    }

    public void setUpdatedby(Long updatedby) {
        this.updatedby = updatedby;
    }

    protected Date updateddtm;

    @Basic
    @javax.persistence.Column(name = "updateddtm", nullable = true)
    public Date getUpdateddtm() {
        return updateddtm;
    }

    public void setUpdateddtm(Date updateddtm) {
        this.updateddtm = updateddtm;
    }

    protected Date regtime;

    @Basic
    @javax.persistence.Column(name = "regtime", nullable = true)
    public Date getRegtime() {
        return regtime;
    }

    public void setRegtime(Date regtime) {
        this.regtime = regtime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustomerDeveloper that = (CustomerDeveloper) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (userid != null ? !userid.equals(that.userid) : that.userid != null) return false;
        if (companyname != null ? !companyname.equals(that.companyname) : that.companyname != null) return false;
        if (ceoname != null ? !ceoname.equals(that.ceoname) : that.ceoname != null) return false;
        if (country != null ? !country.equals(that.country) : that.country != null) return false;
        if (state != null ? !state.equals(that.state) : that.state != null) return false;
        if (city != null ? !city.equals(that.city) : that.city != null) return false;
        if (address1 != null ? !address1.equals(that.address1) : that.address1 != null) return false;
        if (address2 != null ? !address2.equals(that.address2) : that.address2 != null) return false;
        if (employees != null ? !employees.equals(that.employees) : that.employees != null) return false;
        if (contactpersonname != null ? !contactpersonname.equals(that.contactpersonname) : that.contactpersonname != null)
            return false;
        if (website != null ? !website.equals(that.website) : that.website != null) return false;
        if (telephone != null ? !telephone.equals(that.telephone) : that.telephone != null) return false;
        if (fax != null ? !fax.equals(that.fax) : that.fax != null) return false;
        if (founddate != null ? !founddate.equals(that.founddate) : that.founddate != null) return false;
        if (operationarea != null ? !operationarea.equals(that.operationarea) : that.operationarea != null)
            return false;
        if (abn != null ? !abn.equals(that.abn) : that.abn != null) return false;
        if (acn != null ? !acn.equals(that.acn) : that.acn != null) return false;
        if (companyprofile != null ? !companyprofile.equals(that.companyprofile) : that.companyprofile != null)
            return false;
        if (createdby != null ? !createdby.equals(that.createdby) : that.createdby != null) return false;
        if (createddtm != null ? !createddtm.equals(that.createddtm) : that.createddtm != null) return false;
        if (updatedby != null ? !updatedby.equals(that.updatedby) : that.updatedby != null) return false;
        if (updateddtm != null ? !updateddtm.equals(that.updateddtm) : that.updateddtm != null) return false;
        if (regtime != null ? !regtime.equals(that.regtime) : that.regtime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (userid != null ? userid.hashCode() : 0);
        result = 31 * result + (companyname != null ? companyname.hashCode() : 0);
        result = 31 * result + (ceoname != null ? ceoname.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (address1 != null ? address1.hashCode() : 0);
        result = 31 * result + (address2 != null ? address2.hashCode() : 0);
        result = 31 * result + (employees != null ? employees.hashCode() : 0);
        result = 31 * result + (contactpersonname != null ? contactpersonname.hashCode() : 0);
        result = 31 * result + (website != null ? website.hashCode() : 0);
        result = 31 * result + (telephone != null ? telephone.hashCode() : 0);
        result = 31 * result + (fax != null ? fax.hashCode() : 0);
        result = 31 * result + (founddate != null ? founddate.hashCode() : 0);
        result = 31 * result + (operationarea != null ? operationarea.hashCode() : 0);
        result = 31 * result + (abn != null ? abn.hashCode() : 0);
        result = 31 * result + (acn != null ? acn.hashCode() : 0);
        result = 31 * result + (companyprofile != null ? companyprofile.hashCode() : 0);
        result = 31 * result + (createdby != null ? createdby.hashCode() : 0);
        result = 31 * result + (createddtm != null ? createddtm.hashCode() : 0);
        result = 31 * result + (updatedby != null ? updatedby.hashCode() : 0);
        result = 31 * result + (updateddtm != null ? updateddtm.hashCode() : 0);
        result = 31 * result + (regtime != null ? regtime.hashCode() : 0);
        return result;
    }
}
