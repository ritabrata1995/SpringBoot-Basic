package com.example.edur.controller;

import ch.qos.logback.core.CoreConstants;
import com.example.edur.model.Leave;
import com.example.edur.service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/employee")
public class LeaveController {

	private final LeaveService leaveService;

	@Autowired
	public LeaveController(LeaveService leaveService) {
		this.leaveService = leaveService;
	}
	
	@GetMapping(value = "/leaves")
	public List<Leave> getAllLeaves() {
		return leaveService.getLeaves();
	}

	@GetMapping(value = "/leave/{id}")
	public Optional<Leave> getLeave(@NotNull @PathVariable("id") UUID id) {

		System.out.print(leaveService.getLeavebyID(id));

		return Optional.ofNullable(leaveService.getLeavebyID(id).orElse(null));
	}

//	@PostMapping((value = "/leave/{id}"))
//	public UUID createNewPerson(@NotNull @Valid @RequestBody Person person) {
//		return personService.insertNewPerson(person);
//	}

    @GetMapping(value = "/test")
    public String test() {
        return "test";
    }

}
