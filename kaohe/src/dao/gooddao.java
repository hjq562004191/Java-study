package dao;

import user.User;

import java.util.List;

public interface gooddao {
    void add(User user);

    List<User> read();

    void dele(String id);

    void change(User user);
}
