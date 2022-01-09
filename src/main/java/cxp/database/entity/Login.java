
package cxp.database.entity;

import javax.persistence.*;

import lombok.Data;

@Entity

@Table(name = "login_creds")

@Data
public class Login {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "login_id")
	private long login_id;

	@Column(name = "user_name")
	private String userName;

	@Column(name = "password")
	private String password;

	public Login() {

	}
}
