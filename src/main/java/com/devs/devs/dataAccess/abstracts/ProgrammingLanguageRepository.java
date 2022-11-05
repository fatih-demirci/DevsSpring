package com.devs.devs.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devs.devs.entities.concretes.ProgrammingLanguage;

public interface ProgrammingLanguageRepository extends JpaRepository<ProgrammingLanguage, Integer> {
    ProgrammingLanguage findById(int id);

    ProgrammingLanguage findByName(String name);

    void deleteById(int id);
}
