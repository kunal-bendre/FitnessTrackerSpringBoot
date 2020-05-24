package com.fitnesstracker.activities;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.fitnesstracker.activities.models.Activity;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ActivitiesApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ActivitiesApplicationTests {

	@Autowired
	private TestRestTemplate restTemplate;

	@LocalServerPort
	private int port;

	private String getRootUrl() {
		return "http://localhost:" + port;
	}


	@Test
	public void testCreateActivity() {
		Activity act = new Activity();
		act.setName("Jogging");
		act.setTime("Morning 6 am");

		ResponseEntity<Activity> postResponse = restTemplate.postForEntity(getRootUrl() + "/activities", act, Activity.class);
		Assert.assertNotNull(postResponse);
		Assert.assertNotNull(postResponse.getBody());
	}

}
