package com.example.auth;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/values")
public class ValuesController {

	@GetMapping()
	public ResponseEntity<List<String>> getNames(){
		List<String> names = new ArrayList<String>();
		names.add("Blank_Blog");
		return ResponseEntity.ok(names);
	}
}

