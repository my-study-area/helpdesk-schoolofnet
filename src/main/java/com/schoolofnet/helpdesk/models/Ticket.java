package com.schoolofnet.helpdesk.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tickets")
@Getter @Setter
public class Ticket {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	@NotEmpty(message = "Can not be empty")
	private Long name;
	
	@Column
	@NotEmpty(message = "Can not be empty")
	private String description;
	
	@Column
	@NotEmpty(message = "Can not be empty")
	private Date created;
	
	@Column
	@NotEmpty(message = "Can not be empty")
	private Date closed;
	
	@Column
	@NotEmpty(message = "Can not be empty")
	private Boolean finished;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	@JsonBackReference
	private User userOpen;
	
	@ManyToOne
	@JoinColumn(name = "technician_id")
	@JsonBackReference
	private User technician;
	
	
}
