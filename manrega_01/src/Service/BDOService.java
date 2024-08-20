package Service;

import DAO.BDODao;
import DAO.Impl.BDODaoImpl;
import Model.BDO;

import java.util.List;

public class BDOService {
    private BDODao bdoDao = new BDODaoImpl();

    // for an implement method

    public BDO getBDOById(int id) {
        return bdoDao.getBDOById(id);
    }

   public BDO getBDOByEmail(String email){
        return  bdoDao.getBDOByEmail(email);
   }

    public List<BDO> getAllBDOs() {
        return bdoDao.getAllBDOs();
    }

    public boolean addBDO(BDO bdo) {
        return bdoDao.addBDO(bdo);
    }

    public boolean updateBDO(BDO bdo) {
        return bdoDao.updateBDO(bdo);
    }

    public boolean deleteBDO(int id) {
        return bdoDao.deleteBDO(id);
    }


}
