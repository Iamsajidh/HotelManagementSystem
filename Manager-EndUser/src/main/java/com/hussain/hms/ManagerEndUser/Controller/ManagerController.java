package com.hussain.hms.ManagerEndUser.Controller;

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

import com.hussain.hms.ManagerEndUser.Models.ManagerInformation;
import com.hussain.hms.ManagerEndUser.Repository.ManagerRepository;
import com.hussain.hms.ManagerEndUser.SecurityConfiguration.ManagerAuthResponse;
import com.hussain.hms.ManagerEndUser.Service.ManagerService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("Manager")
public class ManagerController {

	@Autowired
	private ManagerService managerService;
	@Autowired
	private ManagerRepository managerRepo;
	@Autowired
	private AuthenticationManager authenticationManager;
    
	
	//we are registering the manager for security
	@PostMapping("/addManager")
	private ResponseEntity<?> saveManagerInfo(@RequestBody ManagerInformation managerInfo) {
		String email = managerInfo.getEmail();
		String password = managerInfo.getPassword();
		ManagerInformation manager1 = new ManagerInformation();
		manager1.setEmail(email);
		manager1.setPassword(password);
		try {

			managerRepo.save(managerInfo);
		} catch (Exception e) {
			return ResponseEntity.ok(new ManagerAuthResponse("Error creating Manager " + email));
		}
		return ResponseEntity.ok(new ManagerAuthResponse("Successfully created Manager " + email));
	}
     // for providing authentication to the manager 
	@PostMapping("/auth")
	private ResponseEntity<?> authManager(@RequestBody ManagerInformation managerInfo) {
		String email = managerInfo.getEmail();
		String password = managerInfo.getPassword();
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
		} catch (Exception e) {
			return ResponseEntity.ok(new ManagerAuthResponse("Error during Manager Authentication " + email));
		}
		return ResponseEntity.ok(new ManagerAuthResponse("Successfully Authenticated Manager " + email));
	}

	@GetMapping("/manager")
	public List<ManagerInformation> findAll() {
		return managerService.getmanagerInfos();
	}

}