/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClientPackage;

/**
 *
 * @author parminder singh
 */
public class Clients {
     protected int id;
     protected int agentid;
     protected String firstname;
     protected String lastname;
     protected String streetnumber;
     protected String streetname;
     protected String city;
     protected String province;
     protected String postalcode;
     protected String teloffice;
     protected String telcell;
     protected String email;
     protected String company;
     protected String companytype;
     
     
      public Clients() {
    }
       public Clients(int id) {
        this.id = id;
    }
 
    public Clients(int id,int agentid, String firstname, String lastname, String streetnumber, String streetname, String city, String province, String postalcode, String teloffice, String telcell, String email, String company, String companytype) {
        this(agentid,firstname,lastname,streetnumber,streetname,city,province,postalcode,teloffice,telcell,email,company,companytype);
        this.id = id;
    }

    public Clients( int agentid, String firstname, String lastname, String streetnumber, String streetname, String city, String province, String postalcode, String teloffice, String telcell, String email, String company, String companytype) {
        
        this.agentid = agentid;
        this.firstname = firstname;
        this.lastname = lastname;
        this.streetnumber = streetnumber;
        this.streetname = streetname;
        this.city = city;
        this.province = province;
        this.postalcode = postalcode;
        this.teloffice = teloffice;
        this.telcell = telcell;
        this.email = email;
        this.company = company;
        this.companytype = companytype;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAgentid() {
        return agentid;
    }

    public void setAgentid(int agentid) {
        this.agentid = agentid;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getStreetnumber() {
        return streetnumber;
    }

    public void setStreetnumber(String streetnumber) {
        this.streetnumber = streetnumber;
    }

    public String getStreetname() {
        return streetname;
    }

    public void setStreetname(String streetname) {
        this.streetname = streetname;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }

    public String getTeloffice() {
        return teloffice;
    }

    public void setTeloffice(String teloffice) {
        this.teloffice = teloffice;
    }

    public String getTelcell() {
        return telcell;
    }

    public void setTelcell(String telcell) {
        this.telcell = telcell;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCompanytype() {
        return companytype;
    }

    public void setCompanytype(String companytype) {
        this.companytype = companytype;
    }
 

   
    
}
