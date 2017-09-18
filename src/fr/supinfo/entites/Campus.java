package fr.supinfo.entites;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.sun.istack.internal.NotNull;
@Entity
@Table(name="campus")
public class Campus implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idCampus;
	@NotNull
	@Column(nullable= false)
	private String ville;
	@NotNull
	@Column(nullable=false)
	private String nom;
	@NotNull
	@Column(nullable=false)
	private int contact;
	@NotNull
	@Column(nullable=false)
	private String email;
	@NotNull
	@Column(nullable=false)
	private String description;
	
	@OneToMany(mappedBy="campus")
	Collection<User> users;
	
	public Long getIdCampus() {
		return idCampus;
	}
	public void setIdCampus(Long idCampus) {
		this.idCampus = idCampus;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getContact() {
		return contact;
	}
	public void setContact(int contact) {
		this.contact = contact;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Collection<User> getUsers() {
		return users;
	}
	public void setUsers(Collection<User> users) {
		this.users = users;
	}
	public Campus(String ville,  int contact, String email, String description) {
		super();
		this.ville = ville;
	
		this.contact = contact;
		this.email = email;
		this.description = description;
	}
	public Campus() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
