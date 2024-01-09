package springmvc.login.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
	public String name;
	public String emailId;
	public String mobile_no;
	public String userPassword;
	public String userConfirmPass;
}
