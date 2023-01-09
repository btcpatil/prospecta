package com.prospecta.models;

import java.util.List;

import lombok.Data;

@Data
public class EntryBody {

  private Integer count;
	
  private List<Entry> allEntries;
  
  
}
