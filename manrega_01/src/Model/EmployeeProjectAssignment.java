

package Model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class EmployeeProjectAssignment {
    private int id;
    private int employeeId;
    private int projectId;
    private LocalDate assignedDate;
    private int daysWorked;
    private BigDecimal wagesEarned;
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public EmployeeProjectAssignment() {
    }

    public EmployeeProjectAssignment(int id, int employeeId, int projectId, LocalDate assignedDate, int daysWorked, BigDecimal wagesEarned, String status) {
        this.id = id;
        this.employeeId = employeeId;
        this.projectId = projectId;
        this.assignedDate = assignedDate;
        this.daysWorked = daysWorked;
        this.wagesEarned = wagesEarned;
        this.status = status;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    // Getters and Setters

    // Add getters and setters for all the fields here
    // Example:
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public LocalDate getAssignedDate() {
        return assignedDate;
    }

    public void setAssignedDate(LocalDate assignedDate) {
        this.assignedDate = assignedDate;
    }

    public int getDaysWorked() {
        return daysWorked;
    }

    public void setDaysWorked(int daysWorked) {
        this.daysWorked = daysWorked;
    }

    public BigDecimal getWagesEarned() {
        return wagesEarned;
    }

    public void setWagesEarned(BigDecimal wagesEarned) {
        this.wagesEarned = wagesEarned;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "EmployeeProjectAssignment{" +
                "id=" + id +
                ", employeeId=" + employeeId +
                ", projectId=" + projectId +
                ", assignedDate=" + assignedDate +
                ", daysWorked=" + daysWorked +
                ", wagesEarned=" + wagesEarned +
                ", status='" + status + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}


