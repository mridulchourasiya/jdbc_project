package Model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Payment {
    private int id;
    private int employeeId;
    private LocalDate paymentDate;
    private BigDecimal amount;
    private String status;
    private String paymentMode;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Payment(int id, int employeeId, LocalDate paymentDate, BigDecimal amount, String status, String paymentMode) {
        this.id = id;
        this.employeeId = employeeId;
        this.paymentDate = paymentDate;
        this.amount = amount;
        this.status = status;
        this.paymentMode = paymentMode;
    }


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

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
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
        return "Payments{" +
                "id=" + id +
                ", employeeId=" + employeeId +
                ", paymentDate=" + paymentDate +
                ", amount=" + amount +
                ", status='" + status + '\'' +
                ", paymentMode='" + paymentMode + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }


}
