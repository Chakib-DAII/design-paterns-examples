package com.example.design.patterns.api;

import com.example.design.patterns.creational.builder.PersonInfo;
import com.example.design.patterns.creational.builder.PersonInfoBuilder;
import com.example.design.patterns.creational.factory.Pet;
import com.example.design.patterns.creational.factory.PetFactory;
import com.example.design.patterns.creational.factory.enumeration.PetType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chakib.daii on 3/20/2021.
 */
@RestController
@RequestMapping("/")
public class TestController {

    @Autowired
    PetFactory petFactory;

    @PostMapping("adoptPet/{type}/{name}")
    public ResponseEntity<Pet> adoptPet(@PathVariable(name = "type") PetType type, @PathVariable(name = "name") String name){
        Pet pet = petFactory.createPet(type);
        pet.setName(name);
        pet.feed();
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.set("Location", String.format("adoptPet/%s/%s", type, name));
        return new ResponseEntity<Pet>(pet, headers, HttpStatus.CREATED);
    }

    @GetMapping("infos")
    public ResponseEntity<List<PersonInfo>> getInfos(){
        List<PersonInfo> infos = new ArrayList<>();
        infos.add(new PersonInfoBuilder().firstName("firstName1").lastName("lastName1").nickName("nickName1").build());
        infos.add(new PersonInfoBuilder().firstName("firstName2").lastName("lastName2").nickName("nickName2").build());
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.set("Location", "infos");
        return new ResponseEntity<List<PersonInfo>>(infos, headers, HttpStatus.OK);
    }
}
