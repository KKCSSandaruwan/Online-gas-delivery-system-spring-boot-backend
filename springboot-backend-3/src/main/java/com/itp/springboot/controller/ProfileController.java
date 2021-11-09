package com.itp.springboot.controller;



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

import com.itp.springboot.exception.ResourceNotFoundException;
import com.itp.springboot.model.Profile;
import com.itp.springboot.repository.ProfileRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class ProfileController {

	@Autowired
	private ProfileRepository profileRepository;
	
	
	@GetMapping("/profile")
	public List<Profile> getAllProfile(){
		return profileRepository.findAll();
	}		
	
	
	@PostMapping("/profile")
	public Profile createProfile(@RequestBody Profile profile) {
		return profileRepository.save(profile);
	}
	
	
	@GetMapping("/profile/{customer_id}")
	public ResponseEntity<Profile> getProfileById(@PathVariable Long customer_id) {
		Profile profile = profileRepository.findById(customer_id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + customer_id));
		return ResponseEntity.ok(profile);
	}
	
	
	
	@PutMapping("/profile/{customer_id}")
	public ResponseEntity<Profile> updateProfile(@PathVariable Long customer_id, @RequestBody Profile profileDetails){
		Profile profile = profileRepository.findById(customer_id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + customer_id));
		
		profile.setName(profileDetails.getName());
		profile.setAddress(profileDetails.getAddress());
		profile.setName(profileDetails.getName());
		profile.setEmail(profileDetails.getEmail());
		
		
		Profile updatedProfile = profileRepository.save(profile);
		return ResponseEntity.ok(updatedProfile);
	}
	

	@DeleteMapping("/profile/{customer_id}")
	public ResponseEntity<Map<String, Boolean>> deleteProfile(@PathVariable Long customer_id){
		Profile profile = profileRepository.findById(customer_id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + customer_id));
		
		profileRepository.delete(profile);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	
}
