package com.hussain.hms.ManagerEndUser.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.hussain.hms.ManagerEndUser.Models.ManagerInformation;
import com.hussain.hms.ManagerEndUser.Repository.ManagerRepository;

@Service
public class ManagerService implements UserDetailsService {

	@Autowired
	private ManagerRepository managerRepo;

	public List<ManagerInformation> getmanagerInfos() {
		List<ManagerInformation> managerInfos = managerRepo.findAll();
		System.out.println("Getting Manager from DB" + managerInfos);
		return managerInfos;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		ManagerInformation foundedManager = managerRepo.findByEmail(username);
		if (foundedManager == null)
			return null;
		String Email = foundedManager.getEmail();
		String Password = foundedManager.getPassword();
		return new User(Email, Password, new ArrayList<>());
	}

}