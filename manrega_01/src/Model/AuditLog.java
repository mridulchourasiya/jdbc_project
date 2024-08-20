package Model;

import java.time.LocalDateTime;

public class AuditLog {
    private int id;
    private String userType;
    private int userId;
    private String action;
    private LocalDateTime timestamp;
    private String description;

    public AuditLog(int id, String userType, int userId, String action, LocalDateTime timestamp, String description) {
        this.id = id;
        this.userType = userType;
        this.userId = userId;
        this.action = action;
        this.timestamp = timestamp;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    @Override
    public String toString() {
        return "AuditLogs{" +
                "id=" + id +
                ", userType='" + userType + '\'' +
                ", userId=" + userId +
                ", action='" + action + '\'' +
                ", timestamp=" + timestamp +
                ", description='" + description + '\'' +
                '}';
    }

}
