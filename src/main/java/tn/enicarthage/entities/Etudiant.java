package tn.enicarthage.entities;

import java.io.Serializable;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import jakarta.persistence.CascadeType;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
@Entity

@Table(name="Etudiant")
//alter table etudiant modify column role default 'nonregistred';
public class Etudiant extends Utilisateur implements Serializable {
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinColumn(name = "etudiant_id")
public Set<Livre> Livres;
	
	public Etudiant() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Etudiant(Set<Livre> livres, Abonnement abonnement, Role role, GestionneurBibliotheque gestionneur) {
		super();
		Livres = livres;
		this.abonnement = abonnement;
		this.role = role;
		this.gestionneur = gestionneur;
	}
	@OneToOne(mappedBy="etudiant")
	@JsonIgnore
	public Abonnement abonnement;
	@Enumerated(EnumType.STRING)
	
	public Role role;
	public Set<Livre> getLivres() {
		return Livres;
	}
	public void setLivres(Set<Livre> livres) {
		Livres = livres;
	}
	public Abonnement getAbonnement() {
		return abonnement;
	}
	public void setAbonnement(Abonnement abonnement) {
		this.abonnement = abonnement;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public GestionneurBibliotheque getGestionneur() {
		return gestionneur;
	}
	public void setGestionneur(GestionneurBibliotheque gestionneur) {
		this.gestionneur = gestionneur;
	}
	@ManyToOne(cascade=CascadeType.ALL)
	private GestionneurBibliotheque gestionneur;
}
