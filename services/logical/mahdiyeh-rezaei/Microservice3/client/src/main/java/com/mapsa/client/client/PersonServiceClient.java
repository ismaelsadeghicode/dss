package com.mapsa.client.client;

import com.google.gson.Gson;
import com.mapsa.client.dto.PersonDTO;


import org.json.JSONArray;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class PersonServiceClient {
    @Autowired
    RestTemplate restTemplate;

    @Bean
    RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    public List<PersonDTO> personDTOList() throws JSONException {
        String object = restTemplate.getForObject("http://localhost:8000/person", String.class);
        JSONArray jsonArray = new JSONArray(object);
        Gson gson = new Gson();
        List<PersonDTO> dtoList = new ArrayList<>();

        for (int i = 0; i < jsonArray.length(); i++) {
            PersonDTO personDTO = gson.fromJson(String.valueOf(jsonArray.get(i)), PersonDTO.class);
            dtoList.add(personDTO);
        }

        return dtoList;
    }

    public PersonDTO findPerson(String nationalCode) {
//        Map<String, String> map = new HashMap<>();
//        map.put("code", nationalCode);

        String url = "http://localhost:8000/person/code/" + nationalCode;
        return restTemplate.getForObject(url, PersonDTO.class);
    }


}
