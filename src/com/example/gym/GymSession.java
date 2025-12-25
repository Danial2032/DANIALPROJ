package com.example.gym;

public class GymSession {

    // 1. PRIVATE FIELDS
    private int sessionId;
    private String trainerName;
    private String sessionType;
    private int durationMinutes;
    private boolean completed;

    // 2. CONSTRUCTOR WITH PARAMETERS
    public GymSession(int sessionId, String trainerName, String sessionType,
                      int durationMinutes, boolean completed) {
        this.sessionId = sessionId;
        this.trainerName = trainerName;
        this.sessionType = sessionType;
        this.durationMinutes = durationMinutes;
        this.completed = completed;
    }

    // 3. DEFAULT CONSTRUCTOR
    public GymSession() {
        this.sessionId = 0;
        this.trainerName = "Unknown";
        this.sessionType = "General";
        this.durationMinutes = 0;
        this.completed = false;
    }

    // 4. GETTERS
    public int getSessionId() {
        return sessionId;
    }

    public String getTrainerName() {
        return trainerName;
    }

    public String getSessionType() {
        return sessionType;
    }

    public int getDurationMinutes() {
        return durationMinutes;
    }

    public boolean isCompleted() {
        return completed;
    }

    // 5. SETTERS
    public void setSessionId(int sessionId) {
        this.sessionId = sessionId;
    }

    public void setTrainerName(String trainerName) {
        this.trainerName = trainerName;
    }

    public void setSessionType(String sessionType) {
        this.sessionType = sessionType;
    }

    public void setDurationMinutes(int durationMinutes) {
        this.durationMinutes = durationMinutes;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    // 6. ADDITIONAL METHODS
    public void completeSession() {
        completed = true;
    }

    public boolean isLongSession() {
        return durationMinutes > 60;
    }

    // 7. toString()
    @Override
    public String toString() {
        return "GymSession{" +
                "sessionId=" + sessionId +
                ", trainerName='" + trainerName + '\'' +
                ", sessionType='" + sessionType + '\'' +
                ", durationMinutes=" + durationMinutes +
                ", completed=" + completed +
                '}';
    }
}