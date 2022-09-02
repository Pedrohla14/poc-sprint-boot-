package controller;


import controller.dto.PersonDto;
import model.PersonModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import repository.PersonRepository;
import service.PersonService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {



    @Autowired
    PersonRepository personRepository;

    @Autowired
    PersonService personService;


    @PostMapping
    public ResponseEntity<Object> savePerson(@RequestBody @Valid PersonDto personDto){
        if(personRepository.existsByEmail(personDto.getEmail())){

            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: Person already exists");

        }

        PersonModel personModel = new PersonModel();

        BeanUtils.copyProperties(personDto,personModel);


        return ResponseEntity.status(HttpStatus.CREATED).body(personService.save(personModel));
    }


    @GetMapping
    public ResponseEntity<List<PersonModel>> getAllPerson(){
        return ResponseEntity.status(HttpStatus.OK).body(personService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonModel> getOnePerson(@PathVariable(value="id") Long id){
        PersonModel personModel = personService.findById(id).get();


        return ResponseEntity.status(HttpStatus.OK).body(personModel);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePerson(@PathVariable(value="id")Long id){
        PersonModel personModel= personService.findById(id).get();

        personService.delete(personModel);
        return ResponseEntity.status(HttpStatus.OK).body("The Person was deleted");
    }

    @PutMapping("/{id}")
    public ResponseEntity<PersonModel> updatePerson(@PathVariable(value = "id") Long id, @RequestBody @Valid PersonDto personDto){
        PersonModel personModel = personService.findById(id).get();


        personModel.setName(personDto.getName());
        personModel.setCpf(personDto.getCpf());
        personModel.setEmail(personDto.getEmail());
        personModel.setBirth(personDto.getBirth());
        personModel.setFone(personDto.getFone());


        return ResponseEntity.status(HttpStatus.OK).body(personService.save(personModel));
    }

}