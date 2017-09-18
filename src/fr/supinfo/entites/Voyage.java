package fr.supinfo.entites;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import com.sun.istack.internal.NotNull;


@Entity
@Table(name="voyages")
public class Voyage implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idVoyage;
	@NotNull
	@Column(nullable=false)
	private String nom;
	@NotNull
	@Column(nullable=false)
	private String source;
	@NotNull
	@Column(nullable=false)
	private String destination;
	@Type(type="boolean")
	private boolean statut;
	@ManyToOne
	@JoinColumn(name="idUser")
	User user;
	@OneToOne
	@JoinColumn(name="idCampus1")
	private Campus campusSource;
	@OneToOne
	@JoinColumn(name="idCampus2")
	private Campus campusDestination;
	
	
	public boolean isStatut() {
		return statut;
	}
	public void setStatut(boolean statut) {
		this.statut = statut;
	}
	public Long getIdVoyage() {
		return idVoyage;
	}
	public void setIdVoyage(Long idVoyage) {
		this.idVoyage = idVoyage;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Campus getCampusSource() {
		return campusSource;
	}
	public void setCampusSource(Campus campusSource) {
		this.campusSource = campusSource;
	}
	public Campus getCampusDestination() {
		return campusDestination;
	}
	public void setCampusDestination(Campus campusDestination) {
		this.campusDestination = campusDestination;
	}
	public Voyage(String nom, String source, String destination, User user, Campus campusSource,
			Campus campusDestination) {
		super();
		this.nom = nom;
		this.source = source;
		this.destination = destination;
		this.user = user;
		this.campusSource = campusSource;
		this.campusDestination = campusDestination;
	}
	public Voyage() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
