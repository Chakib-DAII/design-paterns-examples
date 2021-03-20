package com.example.design.patterns.creational.builder;

/**
 * Created by chakib.daii on 3/20/2021.
 */
public class PersonInfoBuilder {
    private String firstName;
    private String lastName;
    private String middleName;
    private String nickName;
    private String gender;
    private int age;
    private String title;
    private String maritalStatus;
    private String address;
    private String emailAddress;

    public PersonInfoBuilder firstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public PersonInfoBuilder lastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public PersonInfoBuilder middleName(String middleName) {
        this.middleName = middleName;
        return this;
    }

    public PersonInfoBuilder nickName(String nickName) {
        this.nickName = nickName;
        return this;
    }

    public PersonInfoBuilder gender(String gender) {
        this.gender = gender;
        return this;
    }

    public PersonInfoBuilder age(int age) {
        this.age = age;
        return this;
    }

    public PersonInfoBuilder title(String title) {
        this.title = title;
        return this;
    }

    public PersonInfoBuilder maritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
        return this;
    }

    public PersonInfoBuilder address(String address) {
        this.address = address;
        return this;
    }

    public PersonInfoBuilder emailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
        return this;
    }

    public PersonInfo build(){
        PersonInfo personInfo = new PersonInfo(firstName, lastName, middleName, nickName, gender, age, title,
                maritalStatus, address, emailAddress);
        return personInfo;
    }
}
