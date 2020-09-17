package com.dss.demo.client;

import com.dss.demo.domain.Person;
import com.google.gson.Gson;
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

    public List<Person> getPersonFromJson() throws JSONException {
        String json = restTemplate.getForObject("localhost:8080/person/list", String.class);
        JSONArray jsonArray = new JSONArray(json);
        Gson gson = new Gson();
        List<Person> people = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            Person person = gson.fromJson(String.valueOf(jsonArray.get(i)),Person.class);
            person.setName(person.getName());
            people.add(person);
        }
        for (Person person : people) {
            System.out.println("person = " + person);
        }
        return people;
    }
    @Bean
    public RestTemplate restConfig() {
        return new RestTemplate();
    }
}
