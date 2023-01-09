package com.prospecta.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prospecta.models.Entry;

public interface EntryRepository extends JpaRepository<Entry, Integer>{

}
