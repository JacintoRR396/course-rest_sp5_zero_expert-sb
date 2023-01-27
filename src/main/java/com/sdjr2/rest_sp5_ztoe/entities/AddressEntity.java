package com.sdjr2.rest_sp5_ztoe.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * Entity that represents a Address in the database.
 *
 * @author jroldan
 * @version 1.0
 * @category Entity
 * @since 22/12/26
 * @upgrade 23/01/27
 */
@Entity
@Table(name = "addresses")
public class AddressEntity implements Serializable {

	private static final long serialVersionUID = 2339186471035380213L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "street")
	private String street;

	@Column(name = "number")
	private String number;

	@Column(name = "city")
	private String city;

	@ManyToOne
	@JoinColumn(name = "profile_id", referencedColumnName = "id")
	private ProfileEntity profile;

	public Integer getId() {
		return this.id;
	}

	public void setId(final Integer id) {
		this.id = id;
	}

	public String getStreet() {
		return this.street;
	}

	public void setStreet(final String street) {
		this.street = street;
	}

	public String getNumber() {
		return this.number;
	}

	public void setNumber(final String number) {
		this.number = number;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(final String city) {
		this.city = city;
	}

	public ProfileEntity getProfile() {
		return this.profile;
	}

	public void setProfile(final ProfileEntity profile) {
		this.profile = profile;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (prime * result) + ((this.id == null) ? 0 : this.id.hashCode());
		return result;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		final AddressEntity other = (AddressEntity) obj;
		if (this.id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!this.id.equals(other.id)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "AddressEntity [id=" + id + ", street=" + street + ", number=" + number + ", city=" + city + ", profile="
				+ profile + "]";
	}
	
}
