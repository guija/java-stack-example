package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping(path="/user")
@Api(description = "CRUD for User resource")
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@ApiOperation(value="Add a new user to the database")
	@PostMapping(path="/add")
	public @ResponseBody User addNewUser (
			@RequestParam String name,
			@RequestParam String email,
			@RequestParam String lastName,
			@RequestParam String address) {

		User user = new User();
		user.setName(name);
        user.setEmail(email);
		user.setLastName(lastName);
		user.setAddress(address);
		userRepository.save(user);

        return user;
        
	}

	@ApiOperation(value = "Get list of all users")
	@GetMapping(path="/all")
	public @ResponseBody Iterable<User> getAllUsers() {
		// This returns a JSON or XML with the users
		return userRepository.findAll();
    }
    
}