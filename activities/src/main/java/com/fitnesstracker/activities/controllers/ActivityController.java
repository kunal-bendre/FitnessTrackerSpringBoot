package com.fitnesstracker.activities.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fitnesstracker.activities.models.Activity;
import com.fitnesstracker.activities.repositories.ActivityRepository;

@RestController
@RequestMapping("/api/v1/activities")
public class ActivityController {

	@Autowired
	private ActivityRepository repo;
	
	@GetMapping	
	public List<Activity> list() {
		return repo.findAll();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	public void create(@RequestBody Activity activity) {
		repo.save(activity);
	}
	
	@GetMapping("/{id}")
	public Activity get(@PathVariable("id") long id) {
		return repo.getOne(id);
	}
}
