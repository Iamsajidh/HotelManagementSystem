package com.hussain.hms.ReceptionistEndUser.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.hussain.hms.ReceptionistEndUser.Models.ReceptionistInformation;
import com.hussain.hms.ReceptionistEndUser.Repository.ReceptionistRepository;

@Service
public class ReceptionistService implements UserDetailsService{
	
	@Autowired
	ReceptionistRepository receptionistRepository;
	
	
	 public ReceptionistInformation addReceptionist(ReceptionistInformation receptionist) {
	        return receptionistRepository.save(receptionist);
	    }

	    public ReceptionistInformation updateReceptionist(ReceptionistInformation receptionist) {
	        return receptionistRepository.save(receptionist);
	    }

	    public void deleteReceptionist(String id) {
	        receptionistRepository.deleteById(id);
	    }

	    public ReceptionistInformation getReceptionistById(String id) {
	        return receptionistRepository.findById(id).orElse(null);
	    }

	    public ReceptionistInformation getReceptionistByEmail(String email) {
	        return receptionistRepository.findByEmail(email);
	    }
	    
	    @Override
	    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	        ReceptionistInformation receptionist = receptionistRepository.findByEmail(username);
	        if (receptionist == null) {
	            throw new UsernameNotFoundException("Invalid email or password");
	        }
	        String email = receptionist.getEmail();
	        String password = receptionist.getPassword();
	        return new User(email, password, new ArrayList<>());
	    }


	    public List<ReceptionistInformation> getAllReceptionists() {
	        return receptionistRepository.findAll();
	    }

		
}