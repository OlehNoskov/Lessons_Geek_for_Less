package com.example.geek_for_less;

import com.example.geek_for_less.dto.Address;
import com.example.geek_for_less.dto.Person;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JSONTest {

    private Person person;
    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void readFileAndDeserialize() throws IOException, URISyntaxException {
        URI uri = this.getClass().getClassLoader().getResource("Test.json").toURI();
        File file = new File(uri);

        // When we need List objects
//        List<Person> personList = Arrays.asList(objectMapper.readValue(file, Person[].class));
//        person = personList.get(0);

        person = objectMapper.readValue(file, Person.class);

        assertEquals("Oleg", person.getName());
        assertEquals("Noskov", person.getSurname());

        assertEquals("Kharkiv", person.getAddress().getCity());
        assertEquals("Sumska", person.getAddress().getStreet());
        assertEquals(10, person.getAddress().getBuildingNumber());
    }

    @Test
    public void serialize() throws JsonProcessingException {
        Address address = new Address("Kyiv", "Khreshchatyk", 36);
        person = new Person("Vitaliy", "Klichko", address);

//        String json = objectMapper.writeValueAsString(person);
        String json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(person);
        System.out.println(json);
    }
}