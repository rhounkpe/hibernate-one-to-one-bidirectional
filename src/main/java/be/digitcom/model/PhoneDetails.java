package be.digitcom.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "PhoneDetails")
@Table(name = "`phone_details`")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PhoneDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String provider;
	
	private String technology;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "phone_id")
	private Phone phone;

	public PhoneDetails(String provider, String technology) {
		super();
		this.provider = provider;
		this.technology = technology;
	}
	
	
}
