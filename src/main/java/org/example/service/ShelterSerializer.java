package org.example.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import org.example.model.Pet;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ShelterSerializer {
    private static final String FILE_PATH = "src/main/resources/saved_animals.json";
    private static final ObjectMapper mapper = new JsonMapper();

    public static void saveToFile(List<Pet> pets) {
        try {
            mapper.writeValue(new File(FILE_PATH), pets);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static List<Pet> loadPetsFromFile() {
        List<Pet> pets = new ArrayList<>();
        try {
            File file = new File(FILE_PATH);
            if (file.exists()) {
                pets = mapper.readValue(file, new TypeReference<List<Pet>>() {
                });
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return pets;
    }
}
