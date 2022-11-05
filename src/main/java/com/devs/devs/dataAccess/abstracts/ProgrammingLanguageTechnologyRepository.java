package com.devs.devs.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devs.devs.entities.concretes.ProgrammingLanguageTechnology;

public interface ProgrammingLanguageTechnologyRepository extends JpaRepository<ProgrammingLanguageTechnology, Integer> {
    ProgrammingLanguageTechnology findById(int id);

    ProgrammingLanguageTechnology findByName(String name);

    void deleteById(int id);
}
