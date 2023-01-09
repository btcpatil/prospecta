package com.prospecta.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prospecta.exception.EntryException;
import com.prospecta.models.Entry;
import com.prospecta.repository.EntryRepository;

@Service
public class EntryService {

	@Autowired
	EntryRepository entryRepo;
	
	public String addEntry(Entry entry) throws EntryException {
		
		if(entry != null) {
			
			entryRepo.save(entry);
			return "entry is successfully saved";
			
		}
		else {
			throw new EntryException("entry can not be null");
		}
	}
	
}
