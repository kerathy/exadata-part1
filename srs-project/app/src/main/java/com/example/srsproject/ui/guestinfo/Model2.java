package com.example.srsproject.ui.guestinfo;

public class Model2 {

    private Integer id;
    private String title;
    private String firstName;
    private String middleInitial;
    private String lastName;
    private String email;
    private boolean createAnAccount;
    private String gender;
    private String companyName;
    private String address;
    private String city;
    private String postalCode;
    private String country;
    private String telephone;
    private String mobilePhone;
    private String purpose;
    private String comments;

    public Model2(String title, String firstName, String middleInitial, String lastName, String email, boolean createAnAccount, String gender, String companyName, String address, String city, String postalCode, String country, String telephone, String mobilePhone, String purpose, String comments) {
        this.title = title;
        this.firstName = firstName;
        this.middleInitial = middleInitial;
        this.lastName = lastName;
        this.email = email;
        this.createAnAccount = createAnAccount;
        this.gender = gender;
        this.companyName = companyName;
        this.address = address;
        this.city = city;
        this.postalCode = postalCode;
        this.country = country;
        this.telephone = telephone;
        this.mobilePhone = mobilePhone;
        this.purpose = purpose;
        this.comments = comments;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleInitial() {
        return middleInitial;
    }

    public void setMiddleInitial(String middleInitial) {
        this.middleInitial = middleInitial;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isCreateAnAccount() {
        return createAnAccount;
    }

    public void setCreateAnAccount(boolean createAnAccount) {
        this.createAnAccount = createAnAccount;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
