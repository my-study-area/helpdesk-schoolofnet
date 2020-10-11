package com.schoolofnet.helpdesk.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.schoolofnet.helpdesk.models.Ticket;

public interface TicketRepository extends PagingAndSortingRepository<Ticket, Long> {

}
