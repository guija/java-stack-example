package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/user")
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@PostMapping(path="/add")
	public @ResponseBody String addNewUser (
        @RequestParam String name,
        @RequestParam String email,
		@RequestParam String lastName,
		@RequestParam String address) {

		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request

		User user = new User();
		user.setName(name);
        user.setEmail(email);
		user.setLastName(lastName);
		user.setAddress(address);
		userRepository.save(user);

        return "Saved";
        
	}

	@GetMapping(path="/all")
	public @ResponseBody Iterable<User> getAllUsers() {
		// This returns a JSON or XML with the users
		return userRepository.findAll();
    }
    
}