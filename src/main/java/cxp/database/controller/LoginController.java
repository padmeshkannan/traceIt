package cxp.database.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cxp.database.entity.Login;
import cxp.database.repository.LoginRepository;

@RestController

@RequestMapping("/api")
public class LoginController {

	@Autowired
	LoginRepository loginRepository;

	@PostMapping("/validate")
	public ResponseEntity<List<Login>> validateUser(@RequestBody Login loginDetails) {
		try {
			List<Login> loginList = loginRepository.findByUserNameAndPassword(loginDetails.getUserName(), loginDetails.getPassword());
			
			if (!loginList.isEmpty()) {
				loginList.stream().filter(fil -> fil.getUserName().equalsIgnoreCase(loginDetails.getUserName())
						&& fil.getUserName().equalsIgnoreCase(loginDetails.getPassword())).findAny();
			}
			return new ResponseEntity<>(loginList, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
