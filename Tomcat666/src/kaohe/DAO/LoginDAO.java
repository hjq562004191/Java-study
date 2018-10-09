package kaohe.DAO;

import kaohe.User;

public interface LoginDAO {
    User checkLoginDAO(String uname, String pwd);
    User checkUidDAO(String uid);
}
