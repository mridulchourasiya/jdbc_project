package Service;

import DAO.GramPanchayatMemberDao;
import DAO.Impl.GramPanchayatMemberDaoImpl;
import Model.GramPanchayatMember;

import java.util.List;

public class GramPanchayatMemberService {

    private GramPanchayatMemberDao gramPanchayatMemberDao = new GramPanchayatMemberDaoImpl();


    public GramPanchayatMember getMemberById(int id) {
        return gramPanchayatMemberDao.getMemberById(id);
    }

    public GramPanchayatMember getMemberByEmail(String email) {
        return gramPanchayatMemberDao.getMemberByEmail(email);
    }

    public List<GramPanchayatMember> getAllMembers() {
        return gramPanchayatMemberDao.getAllMembers();
    }

    public boolean addMember(GramPanchayatMember member) {
        return gramPanchayatMemberDao.addMember(member);
    }

    public boolean updateMember(GramPanchayatMember member) {
        return gramPanchayatMemberDao.updateMember(member);
    }

    public boolean deleteMember(int id) {
        return gramPanchayatMemberDao.deleteMember(id);
    }


}
