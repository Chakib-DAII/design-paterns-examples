package com.example.design.patterns.creational.builder;

/**
 * Created by chakib.daii on 3/20/2021.
 */
public class PersonInfo {
    private String firstName;
    private String lastName;
    private String middleName;
    private String nickName;
    private String gender;
    private Integer age;
    private String title;
    private String maritalStatus;
    private String address;
    private String emailAddress;

    public PersonInfo() {
        super();
    }

    public PersonInfo(String firstName, String lastName, String middleName, String nickName, String gender, Integer age,
                      String title, String maritalStatus, String address, String emailAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.nickName = nickName;
        this.gender = gender;
        this.age = age;
        this.title = title;
        this.maritalStatus = maritalStatus;
        this.address = address;
        this.emailAddress = emailAddress;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
}
