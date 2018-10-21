package service;

import dao.gooddao;
import dao.gooddaoImpl;
import user.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class goodserviceImpl implements goodservice{
    gooddao gd = new gooddaoImpl();

    @Override
    public void add(User user) {
        gd.add(user);
    }

    @Override
    public List<User> read() {

        return gd.read();
    }

    @Override
    public void dele(String id) {
        gd.dele(id);
    }

    @Override
    public void change(User user) {
        gd.change(user);
    }

}
