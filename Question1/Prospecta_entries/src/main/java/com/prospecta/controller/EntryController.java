package com.prospecta.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.prospecta.exception.EntryException;
import com.prospecta.models.AnswerDto;
import com.prospecta.models.Entry;
import com.prospecta.models.EntryBody;
import com.prospecta.service.EntryService;

@RestController
public class EntryController {
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	EntryService entryService;
	
	@GetMapping("/entries/{category}")
	public List<AnswerDto> getTitleAndDescription(@PathVariable String category) {
		
		EntryBody entryBody = restTemplate.getForObject("https://api.publicapis.org/entries", EntryBody.class);
		
		List<Entry> entries = entryBody.getAllEntries();
		List<AnswerDto> result = new ArrayList<>();
		
		for(Entry eachEntry : entries) {
			
			String cat = eachEntry.getCategory();
			String[] catArray = cat.split(" ");
			
			if(catArray.length > 0) {
				
				if(catArray[0].equals(category)) {
					result.add(new AnswerDto(eachEntry.getApi(), eachEntry.getDescription()));
				}
			}
			else {
				if(eachEntry.getCategory().equals(category)) {
					result.add(new AnswerDto(eachEntry.getApi(), eachEntry.getDescription()));
				}
			}
		}
		
		return result;
	}
	
	@PostMapping("/entries")
	public ResponseEntity<String>  addEntry(@RequestBody Entry entry) throws EntryException {
		
		String result = entryService.addEntry(entry);
		
		return new ResponseEntity<String>(result,HttpStatus.CREATED);
		
	}

}
