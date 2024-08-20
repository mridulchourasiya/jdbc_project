package DAO;

import Model.GramPanchayatMember;

import java.util.List;

public interface GramPanchayatMemberDao {

    GramPanchayatMember getMemberById(int id);

    GramPanchayatMember getMemberByEmail(String email);

    List<GramPanchayatMember> getAllMembers();

    boolean addMember(GramPanchayatMember member);

    boolean updateMember(GramPanchayatMember member);

    boolean deleteMember(int id);
}
