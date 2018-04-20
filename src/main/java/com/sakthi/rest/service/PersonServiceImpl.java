package com.sakthi.rest.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.sakthi.rest.model.Person;
import com.sakthi.rest.model.ResponseData;

@Path("/person")
@Consumes(MediaType.APPLICATION_XML)
@Produces(MediaType.APPLICATION_XML)
public class PersonServiceImpl implements PersonService
{

    private static Map<Integer, Person> persons = new HashMap<Integer, Person>();

    @Override
    @POST
    @Path("/add")
    public ResponseData addPerson(Person p)
    {
        ResponseData response = new ResponseData();
        if (persons.get(p.getId()) != null)
        {
            response.setStatus(false);
            response.setMessage("Person Already Exists");
            return response;
        }
        persons.put(p.getId(), p);
        response.setStatus(true);
        response.setMessage("Person created successfully");
        return response;
    }

    @Override
    @GET
    @Path("/{id}/delete")
    public ResponseData deletePerson(@PathParam("id") int id)
    {
        ResponseData response = new ResponseData();
        if (persons.get(id) == null)
        {
            response.setStatus(false);
            response.setMessage("Person Doesn't Exists");
            return response;
        }
        persons.remove(id);
        response.setStatus(true);
        response.setMessage("Person deleted successfully");
        return response;
    }

    @Override
    @GET
    @Path("/{id}/get")
    public Person getPerson(@PathParam("id") int id)
    {
        return persons.get(id);
    }

    @GET
    @Path("/{id}/getDummy")
    public Person getDummyPerson(@PathParam("id") int id)
    {
        Person p = new Person();
        p.setAge(99);
        p.setName("Dummy");
        p.setId(id);
        return p;
    }

    @Override
    @GET
    @Path("/getAll")
    public Person[] getAllPersons()
    {
        Set<Integer> ids = persons.keySet();
        Person[] p = new Person[ids.size()];
        int index = 0;
        for (Integer id : ids)
        {
            p[index] = persons.get(id);
            index++;
        }
        return p;
    }

}