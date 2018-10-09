package kaohe.Service;

import kaohe.DAO.LoginDAO;
import kaohe.DAO.LoginDAOImpl;
import kaohe.User;

public class LoginServiceImpl implements LoginService {

    @Override
    public User checkLoginservice(String uname, String pwd) {
        //创建dao层对象
            LoginDAO ld = new LoginDAOImpl();
        return ld.checkLoginDAO(uname, pwd);
    }


    @Override
    public User checkUidservice(String uid) {
        LoginDAO ld = new LoginDAOImpl();
        return ld.checkUidDAO(uid);
    }

}