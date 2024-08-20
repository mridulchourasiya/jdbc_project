package Model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Project {
    private int projectId;
    private int bdoId;
    private String projectName;
    private String projectDescription;
    private BigDecimal budget;
    private LocalDate startDate;
    private LocalDate endDate;
    private String status;

    // Constructor
    public Project(int projectId, int bdoId, String projectName, String projectDescription,
                   BigDecimal budget, LocalDate startDate, LocalDate endDate, String status) {
        this.projectId = projectId;
        this.bdoId = bdoId;
        this.projectName = projectName;
        this.projectDescription = projectDescription;
        this.budget = budget;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
    }

    // Getters and Setters
    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public int getBdoId() {
        return bdoId;
    }

    public void setBdoId(int bdoId) {
        this.bdoId = bdoId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectDescription() {
        return projectDescription;
    }

    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription;
    }

    public BigDecimal getBudget() {
        return budget;
    }

    public void setBudget(BigDecimal budget) {
        this.budget = budget;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Project [projectId=" + projectId + ", bdoId=" + bdoId + ", projectName=" + projectName +
                ", projectDescription=" + projectDescription + ", budget=" + budget +
                ", startDate=" + startDate + ", endDate=" + endDate + ", status=" + status + "]";
    }


}
