package com.fitnesstracker.activities.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fitnesstracker.activities.models.Activity;

public interface ActivityRepository extends JpaRepository<Activity, Long>{

}
