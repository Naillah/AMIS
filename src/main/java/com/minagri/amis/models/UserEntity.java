package com.minagri.amis.models;

import jakarta.persistence.*;

@Entity
@Table(name = "entity")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "amis_id")
    private Long amisId;

    @Column(name = "type", nullable = false)
    private String type = "person";

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "othernames")
    private String othernames;

    @Column(name = "name")
    private String name;

    @Column(name = "identification_doc_type")
    private String identificationDocType;

    @Column(name = "identification_doc_number")
    private String identificationDocNumber;

    @Column(name = "status")
    private String status = "Active";

    @Column(name = "address")
    private String address;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

   
    public UserEntity() {
        
    }

   
    public UserEntity(String type, String firstname, String lastname, String othernames,
                      String name, String identificationDocType, String identificationDocNumber,
                      String status, String address, String email, String phone) {
        this.type = type;
        this.firstname = firstname;
        this.lastname = lastname;
        this.othernames = othernames;
        this.name = name;
        this.identificationDocType = identificationDocType;
        this.identificationDocNumber = identificationDocNumber;
        this.status = status;
        this.address = address;
        this.email = email;
        this.phone = phone;
    }

    

    public Long getAmisId() {
        return amisId;
    }

    public void setAmisId(Long amisId) {
        this.amisId = amisId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public String getOthernames() {
        return othernames;
    }

    public void setOthernames(String othernames) {
        this.othernames = othernames;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdentificationDocType() {
        return identificationDocType;
    }

    public void setIdentificationDocType(String identificationDocType) {
        this.identificationDocType = identificationDocType;
    }

    public String getIdentificationDocNumber() {
        return identificationDocNumber;
    }

    public void setIdentificationDocNumber(String identificationDocNumber) {
        this.identificationDocNumber = identificationDocNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
