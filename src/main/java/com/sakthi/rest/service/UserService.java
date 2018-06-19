package com.sakthi.rest.service;

import com.sakthi.rest.model.User;
import com.sakthi.rest.model.ResponseData;

public interface UserService
{

    public ResponseData addUser(User p);

    public ResponseData deleteUser(int id);

    public User getUser(int id);

    public User[] getAllUsers();

}
