package DAO;

import Model.AuditLog;

import java.util.List;

public interface AuditLogsDao {
    boolean addLog(AuditLog log);

    List<AuditLog> getLogsByUserId(int userId, String userType);

    List<AuditLog> getAllLogs();
}
