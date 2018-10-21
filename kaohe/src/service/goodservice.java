package service;

import user.User;

import java.util.List;

public interface goodservice{
    void add(User user);

    List<User> read();

    void dele(String id);

    void change(User user);
}
