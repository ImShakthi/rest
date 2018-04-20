package com.sakthi.rest.service;

import com.sakthi.rest.model.Person;
import com.sakthi.rest.model.ResponseData;

public interface PersonService
{

    public ResponseData addPerson(Person p);

    public ResponseData deletePerson(int id);

    public Person getPerson(int id);

    public Person[] getAllPersons();

}
