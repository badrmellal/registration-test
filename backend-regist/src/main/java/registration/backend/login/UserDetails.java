package registration.backend.login;


import java.util.Base64;

import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;


@Entity
public class UserDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String Username;
	private String About;
	@Lob
	@Column(name = "Photo", columnDefinition="bytea")
	private byte[] Photo;
	private String FirstName;
	private String LastName;
	private String EmailAddress;
	private String Country;
	private String Password;
	private String City;
	private Integer PhoneNumber;
	private String PushNotification;
	
	
	//   public String getPhotoBase64() {
	  //      return Photo;
	  //  }

	 //   public void setPhotoBase64(String photoBase64) {
	  //      this.Photo = photoBase64;
	  //  }
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public String getAbout() {
		return About;
	}
	public void setAbout(String about) {
		About = about;
	}
	
	public byte[] getPhoto() {
		return Photo;
	}
	
	public void setPhoto(byte[] photoBytes) {
		Photo = photoBytes;
		
	}
	// Convert the Base64 string to byte[] when getting the photo
    // public byte[] getPhoto() {
     //   return Base64.getDecoder().decode(Photo);
    // }
    // Convert the byte[] to Base64 string when setting the photo
	// public void setPhoto(byte[] photo) {
	  //      this.Photo = Base64.getEncoder().encodeToString(photo);
	   // }
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getEmailAddress() {
		return EmailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		EmailAddress = emailAddress;
	}
	public String getCountry() {
		return Country;
	}
	public void setCountry(String country) {
		Country = country;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public Integer getPhoneNumber() {
		return PhoneNumber;
	}
	public void setPhoneNumber(Integer phoneNumber) {
		PhoneNumber = phoneNumber;
	}
	public String getPushNotification() {
		return PushNotification;
	}
	public void setPushNotification(String pushNotification) {
		PushNotification = pushNotification;
	}
	
	
	

}
