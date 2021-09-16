package com.kh.jdbc.member.model.vo;


import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

public class Member implements Serializable {

    private static final long serialVersionUID = 1004L;

    private String userId;
    private String userPwd;
    private String userName;
    private String gender;
    private int age;
    private String email;
    private String phone;
    private String address;
    private String hobby;
    private Date enrollDate;

    public Member() {
    }

    public Member(String userId, String userPwd) {
        this.userId = userId;
        this.userPwd = userPwd;
    }

    public Member(String userId, String userPwd, String userName, String gender, int age,
                  String email, String phone, String address, String hobby, Date enrollDate) {
        this.userId = userId;
        this.userPwd = userPwd;
        this.userName = userName;
        this.gender = gender;
        this.age = age;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.hobby = hobby;
        this.enrollDate = enrollDate;
    }

    @Override
    public String toString() {
        return "Member {" +
                "userId='" + userId + '\'' +
                ", userPwd='" + userPwd + '\'' +
                ", userName='" + userName + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", hobby='" + hobby + '\'' +
                ", enrollDate=" + enrollDate +
                '}';
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public Date getEnrollDate() {
        return enrollDate;
    }

    public void setEnrollDate(Date enrollDate) {
        this.enrollDate = enrollDate;
    }
}
