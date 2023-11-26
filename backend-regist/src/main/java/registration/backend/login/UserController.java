package registration.backend.login;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


@RestController
@CrossOrigin
public class UserController {
    private UserService userService;
    

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    
    @PostMapping(value = "/api/createuser", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createUserApi(@RequestPart("userDetails") UserDetails userDetails, @RequestPart("Photo") MultipartFile Photo) throws Exception {
       
    	try {
            System.out.println("Received Password: " + userDetails.getPassword());
            System.out.println("Received UserDetails: " + userDetails);
            System.out.println("Received Photo: " + Photo.getOriginalFilename());
                        
            return new ResponseEntity<>(userService.saveUserDetails(userDetails, Photo), HttpStatus.CREATED);
            
        } catch (Exception e) {
            return new ResponseEntity<>("Error when trying to save the user: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/api/allusers")
    public ResponseEntity<List<UserDetails>> allUsersApi() {
    	
        List<UserDetails> allUsers = userService.getAllUsersDetails();
        
        if (allUsers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            
        } else {
            return new ResponseEntity<>(allUsers, HttpStatus.OK);
        }
    }
}
