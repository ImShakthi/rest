package com.sakthi.rest.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.sakthi.rest.model.User;
import com.sakthi.rest.model.ResponseData;

@Path("/users")
@Consumes(MediaType.APPLICATION_XML)
@Produces(MediaType.APPLICATION_XML)
public class UserServiceImpl implements UserService
{

    private static Map<Integer, User> users = new HashMap<Integer, User>();

    @Override
    @POST
//    @Path("/add")
    public ResponseData addUser(User p)
    {
        ResponseData response = new ResponseData();
        if (users.get(p.getId()) != null)
        {
            response.setStatus(false);
            response.setMessage("User Already Exists");
            return response;
        }
        users.put(p.getId(), p);
        response.setStatus(true);
        response.setMessage("User created successfully");
        return response;
    }

    @Override
    @DELETE
    @Path("/{id}")
    public ResponseData deleteUser(@PathParam("id") int id)
    {
        ResponseData response = new ResponseData();
        if (users.get(id) == null)
        {
            response.setStatus(false);
            response.setMessage("User Doesn't Exists");
            return response;
        }
        users.remove(id);
        response.setStatus(true);
        response.setMessage("User deleted successfully");
        return response;
    }

    @Override
    @GET
    @Path("/{id}")
    public User getUser(@PathParam("id") int id)
    {
        return users.get(id);
    }

//    @GET
//    @Path("/{id}/getDummy")
//    public User getDummyUser(@PathParam("id") int id)
//    {
//        User p = new User();
//        p.setAge(99);
//        p.setName("Dummy");
//        p.setId(id);
//        return p;
//    }

    @Override
    @GET
    public User[] getAllUsers()
    {
        Set<Integer> ids = users.keySet();
        User[] p = new User[ids.size()];
        int index = 0;
        for (Integer id : ids)
        {
            p[index] = users.get(id);
            index++;
        }
        return p;
    }

}