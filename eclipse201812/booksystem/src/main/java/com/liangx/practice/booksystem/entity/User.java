package com.liangx.practice.booksystem.entity;

public class User {
    private String userId;

    private String userName;

    private Integer userAge;

    private Integer cardId;

    private String userGender;

    private String userPhoneNumber;

    private String userEmail;

    public User(String userId, String userName, Integer userAge, Integer cardId, String userGender, String userPhoneNumber, String userEmail) {
        this.userId = userId;
        this.userName = userName;
        this.userAge = userAge;
        this.cardId = cardId;
        this.userGender = userGender;
        this.userPhoneNumber = userPhoneNumber;
        this.userEmail = userEmail;
    }

    public User() {
        super();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public Integer getUserAge() {
        return userAge;
    }

    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }

    public Integer getCardId() {
        return cardId;
    }

    public void setCardId(Integer cardId) {
        this.cardId = cardId;
    }

    public String getUserGender() {
        return userGender;
    }

    public void setUserGender(String userGender) {
        this.userGender = userGender == null ? null : userGender.trim();
    }

    public String getUserPhoneNumber() {
        return userPhoneNumber;
    }

    public void setUserPhoneNumber(String userPhoneNumber) {
        this.userPhoneNumber = userPhoneNumber == null ? null : userPhoneNumber.trim();
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail == null ? null : userEmail.trim();
    }
}