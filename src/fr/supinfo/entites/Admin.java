package fr.supinfo.entites;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="admins")
public class Admin {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idAdmin;
	private String login;
	private String password;
	
	
	public Admin(String login, String password) {
		super();
		this.login = login;
		this.password = password;
	}
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getIdAdmin() {
		return idAdmin;
	}
	public void setIdAdmin(Long idAdmin) {
		this.idAdmin = idAdmin;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
