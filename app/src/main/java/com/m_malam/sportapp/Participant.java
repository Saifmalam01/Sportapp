package com.m_malam.sportapp;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class Participant extends RealmObject {

    @PrimaryKey
    private int memberNumber;

    private String firstName;
    private String lastName;
    private String phoneNumber;
    private int sessionId;

    // Default constructor is needed by Realm
    public Participant() {}

    // Constructor for convenience
    public Participant(String firstName, String lastName, String phoneNumber, int memberNumber, int sessionId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.memberNumber = memberNumber;
        this.sessionId = sessionId;
    }

    // Getters and setters
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getMemberNumber() {
        return memberNumber;
    }

    public void setMemberNumber(int memberNumber) {
        this.memberNumber = memberNumber;
    }

    public int getSessionId() {
        return sessionId;
    }

    public void setSessionId(int sessionId) {
        this.sessionId = sessionId;
    }

    @Override
    public String toString() {
        return "Participant{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", memberNumber=" + memberNumber +
                ", sessionId=" + sessionId +
                '}';
    }
}
