package com.BlankBlog.auth;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping()
public class ValuesController {

	@GetMapping()
	public ResponseEntity<List<String>> getNames(){
		List<String> names = new ArrayList<String>();
		names.add("Nick");
		names.add("Kamal");
		names.add("Jon");
		return ResponseEntity.ok(names);
	}
}
