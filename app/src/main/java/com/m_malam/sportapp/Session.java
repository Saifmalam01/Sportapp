package com.m_malam.sportapp;

import java.util.List;

import io.realm.RealmObject;

public class Session extends RealmObject {
    private int sessionId;
    private String sport;
    private String gym;
    private long startTime;
    private List<Participant> participants;

    // Getters and setters for session details
    public int getSessionId() {
        return sessionId;
    }

    public void setSessionId(int sessionId) {
        this.sessionId = sessionId;
    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    public String getGym() {
        return gym;
    }

    public void setGym(String gym) {
        this.gym = gym;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public List<Participant> getParticipants() {
        return participants;
    }

    public void setParticipants(List<Participant> participants) {
        this.participants = participants;
    }

    @Override
    public String toString() {
        return "Session{" +
                "sessionId=" + sessionId +
                ", sport='" + sport + '\'' +
                ", gym='" + gym + '\'' +
                '}';
    }
}
