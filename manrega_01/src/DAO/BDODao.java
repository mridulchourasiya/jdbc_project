package DAO;

import Model.BDO;

import java.util.List;

public interface BDODao {
    BDO getBDOById(int id);

    BDO getBDOByEmail(String email);

    List<BDO> getAllBDOs();


    boolean addBDO(BDO bdo);

    boolean updateBDO(BDO bdo);

    boolean deleteBDO(int id);
}
