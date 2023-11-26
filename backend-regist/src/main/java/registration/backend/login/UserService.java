package registration.backend.login;

import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


@Service
public class UserService {
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

  //  @Autowired
 //   private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserDetails saveUserDetails(UserDetails userDetails, MultipartFile Photo) {
    //    if (userDetails.getPassword() == null) {
      //      throw new IllegalArgumentException("Password cannot be null!");
       // }

   //     String encodedPassword = bCryptPasswordEncoder.encode(userDetails.getPassword());
     //   userDetails.setPassword(encodedPassword);

        byte[] photoBytes = null;
        
		try {
			photoBytes = Photo.getBytes();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        userDetails.setPhoto(photoBytes);

        return userRepository.save(userDetails);
    }

    public List<UserDetails> getAllUsersDetails() {
        return userRepository.findAll();
    }
}

