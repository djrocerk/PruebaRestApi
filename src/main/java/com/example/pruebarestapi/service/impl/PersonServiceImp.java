package com.example.pruebarestapi.service.impl;

import com.example.pruebarestapi.dto.AuthRestDTO;
import com.example.pruebarestapi.dto.AuthRestRegisterDTO;
import com.example.pruebarestapi.dto.PersonRestDto;
import com.example.pruebarestapi.model.AuthModel;
import com.example.pruebarestapi.model.PersonModel;
import com.example.pruebarestapi.repository.PersonRepository;
import com.example.pruebarestapi.service.PersonService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class PersonServiceImp implements PersonService {

    private final ModelMapper modelMapper;
    private final PersonRepository personRepository;

    public PersonServiceImp(ModelMapper modelMapper, PersonRepository personRepository) {
        this.modelMapper = modelMapper;
        this.personRepository = personRepository;
    }

    @Override
    public AuthRestRegisterDTO created(PersonRestDto personDto, AuthModel authModel) {
        PersonModel personModel = modelMapper.map(personDto, PersonModel.class);
        personModel.setAuth(authModel);
        personModel = this.personRepository.save(personModel);
        AuthRestDTO authRestDTO = modelMapper.map(authModel, AuthRestDTO.class);
        PersonRestDto personRestDto = modelMapper.map(personModel, PersonRestDto.class);
        return new AuthRestRegisterDTO(authRestDTO, personRestDto);
    }

    @Override
    public Iterable<PersonModel> readAll() {
        return this.personRepository.findAll();
    }

    @Override
    public PersonRestDto readById(UUID id) {
        Optional<PersonModel> personModelOptional = this.personRepository.findById(id);
        PersonModel personModel= null;
        if(personModelOptional.isPresent()){
            personModel = personModelOptional.get();
        }
        return modelMapper.map(personModel, PersonRestDto.class);
    }

    @Override
    public PersonRestDto updated(UUID id, PersonRestDto personDto) {
        Optional<PersonModel> personModelOptional = this.personRepository.findById(id);
        PersonModel personModel = null;
        if(personModelOptional.isPresent()){
            personModel = personModelOptional.get();
            personModel.setName(personDto.getName());
            personModel.setLastName(personDto.getLastName());
            personModel.setPhone(personDto.getPhone());
            personModel.setAge(personDto.getAge());
            personModel.setDireccion(personDto.getStreet());
            personModel = personRepository.save(personModel);
        }
        return modelMapper.map(personModel, PersonRestDto.class);
    }

    @Override
    public void deleted(UUID id) {
        Optional<PersonModel> personModelOptional = this.personRepository.findById(id);
        personModelOptional.ifPresent(this.personRepository::delete);
    }
}
