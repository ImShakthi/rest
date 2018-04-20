package com.sakthi.rest.app;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import com.dhyan.rest.service.PersonServiceImpl;

@ApplicationPath("/rest")
public class RestApp extends Application
{

    private Set<Object> singletons = new HashSet<Object>();

    public RestApp()
    {
        singletons.add(new PersonServiceImpl());
    }

    @Override
    public Set<Object> getSingletons()
    {
        return singletons;
    }

    @Override
    public Set<Class<?>> getClasses()
    {
        return super.getClasses();
    }

    @Override
    public Map<String, Object> getProperties()
    {
        return super.getProperties();
    }
}