package com.example.design.patterns.creational.factory;

import com.example.design.patterns.creational.factory.enumeration.PetType;
import com.example.design.patterns.creational.factory.types.Cat;
import com.example.design.patterns.creational.factory.types.Dog;
import org.springframework.stereotype.Component;

/**
 * Created by chakib.daii on 3/20/2021.
 */
@Component
public class PetFactory {
    public Pet createPet(PetType type){
        switch (type){
            case CAT:
                return new Cat();
            case DOG:
                return new Dog();
            default:
                throw new UnsupportedOperationException("unknown Type : "+type.name());
        }
    }
}
