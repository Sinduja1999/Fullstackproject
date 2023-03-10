package com.example.demo1.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo1.exceptionhandling.ResourceNotFoundException;
import com.example.demo1.model.BusManagement;
import com.example.demo1.repository.BusManagementRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/busdetails.com")
public class BusManagementController {
	@Autowired
	private BusManagementRepository  busManagementRepository ;

	// get all BusDetails
	@GetMapping("/busdetails")
	public List<BusManagement> getAllBusDetails(){
		return busManagementRepository .findAll();
	}

	// create BusDetails rest api
	@PostMapping("/BusDetails")
	public BusManagement createBusdetails(@RequestBody BusManagement busManagement) {
		return busManagementRepository .save(busManagement);
	}
	// get BusDetails by id rest api
	@GetMapping("/BusDetails/{id}")
	public ResponseEntity<BusManagement > getBusDetailsById(@PathVariable Integer id) {
		BusManagement busManagement = busManagementRepository .findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Busdetails not exist with id :" + id));
		return ResponseEntity.ok(busManagement);
	}
	// update BusDetails rest api

	@PutMapping("/BusDetails/{id}")
	public ResponseEntity<BusManagement> updateBusDetails(@PathVariable Integer id, @RequestBody BusManagement BusDetails){
		BusManagement busManagement = busManagementRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("BusDetails not exist with id :" + id));

		busManagement.setStartingPoint(BusDetails.getStartingPoint());
		busManagement.setEndingPoint(BusDetails.getEndingPoint());
		busManagement.setBusType(BusDetails.getBusType());

		BusManagement updatedBusDetails = busManagementRepository.save(busManagement);
		return ResponseEntity.ok(updatedBusDetails);
	}

	// delete BusDetails rest api
	@DeleteMapping("/BusDetails/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteBusDetails(@PathVariable Integer id){
		BusManagement busManagement = busManagementRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("BusDetails not exist with id :" + id));

		busManagementRepository.delete(busManagement);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}


}



