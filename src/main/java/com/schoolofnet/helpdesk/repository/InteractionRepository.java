package com.schoolofnet.helpdesk.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.schoolofnet.helpdesk.models.Interaction;

public interface InteractionRepository extends JpaRepository<Interaction, Long> {

}
