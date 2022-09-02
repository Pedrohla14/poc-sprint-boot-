package service;


import model.PersonModel;
import org.springframework.stereotype.Service;
import repository.PersonRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Transactional
    public PersonModel save(PersonModel personModel){
        return personRepository.save(personModel);
    }


    public boolean existsByEmail(String email) {
        return personRepository.existsByEmail(email);
    }

//    public boolean existsByNome(String nome) {
//        return personRepository.existsByNome(nome);
//    }

    public List<PersonModel> findAll() {
        return personRepository.findAll();
    }

    public Optional<PersonModel> findById(Long id) {
        return personRepository.findById(id);
    }

    @Transactional
    public void delete(PersonModel personModel) {
        personRepository.delete(personModel);
    }
}
