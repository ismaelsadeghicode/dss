package com.mapsaclient.demo.client;

import com.google.gson.Gson;
import com.mapsaclient.demo.domain.Person;
import org.json.JSONArray;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
@Component
public class PersonClient {
    @Autowired
    RestTemplate restTemplate;

    public List<Person> getPersonWithJsonArray() throws JSONException {
        String json = restTemplate.getForObject("http://localhost:8080/all/0", String.class);
        JSONArray jsonArray = new JSONArray(json);
        Gson gson = new Gson();
        List<Person> people = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            Person person = gson.fromJson(String.valueOf(jsonArray.get(i)), Person.class);
            person.setName(person.getName()+"mahdiyeh");
            people.add(person);
        }
        return people;
    }


}
