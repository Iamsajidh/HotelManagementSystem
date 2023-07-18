package com.hussain.hms.ReceptionistEndUser.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hussain.hms.ReceptionistEndUser.Models.ReceptionistInformation;
import com.hussain.hms.ReceptionistEndUser.Repository.ReceptionistRepository;
import com.hussain.hms.ReceptionistEndUser.SecurityConfiguration.ReceptionistAuthResponse;
import com.hussain.hms.ReceptionistEndUser.Service.ReceptionistService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/Receptionist")
public class ReceptionistController {
	
	@Autowired
	private ReceptionistService receptionistService;
	
	@Autowired
	private ReceptionistRepository receptionistRepository;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@PostMapping("/addReceptionist")
	private ResponseEntity<?> saveReceptionistInfo(@RequestBody ReceptionistInformation receptionistInfo) {
		String email = receptionistInfo.getEmail();
		String password = receptionistInfo.getPassword();
		ReceptionistInformation receptionist = new ReceptionistInformation();
		receptionist.setEmail(email);
		receptionist.setPassword(password);
		ReceptionistInformation savedReceptionist = receptionistService.addReceptionist(receptionist);
		return ResponseEntity.ok(savedReceptionist);
	}
	
	@PostMapping("/auth")
	private ResponseEntity<?> authReceptionist(@RequestBody ReceptionistInformation receptionistInfo) {
		String email = receptionistInfo.getEmail();
		String password = receptionistInfo.getPassword();
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
		} catch (Exception e) {
			return ResponseEntity.ok(new ReceptionistAuthResponse("Error during Receptionist Authentication" + email));
		}
		return ResponseEntity.ok(new ReceptionistAuthResponse("Successfully Authenticated Receptionist" + email));
	}
	
	@GetMapping("/receptionist")
	public List<ReceptionistInformation> findAllReceptionists() {
		return receptionistService.getAllReceptionists();
	}
}
