package kaohe.Service;

import kaohe.User;

public interface LoginService {
    //校验用户登陆信息
    User checkLoginservice(String uname, String pwd);
    //校验用户cookie信息
    User checkUidservice(String uid);
}
