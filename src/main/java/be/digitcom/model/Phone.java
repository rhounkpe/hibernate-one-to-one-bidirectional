package be.digitcom.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "Phone")
@Table(name = "phones")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Phone {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "`number`")
	private String number;
	
	@OneToOne(
			mappedBy = "phone",
			cascade = CascadeType.ALL,
			orphanRemoval = true,
			fetch = FetchType.LAZY
	)
	@LazyToOne(LazyToOneOption.NO_PROXY)
	private PhoneDetails details;

	
	public Phone(String number) {
		super();
		this.number = number;
	}
	
	public Phone(String number, PhoneDetails phoneDetails) {
		this(number);
		this.number = number;
		this.details = phoneDetails;
	}
	
	public void addDetails(PhoneDetails details) {
		details.setPhone(this);
		this.details = details;
	}
	
	
	
	public void removeDetails() {
		if (details != null) {
			details.setPhone(null);
			this.details = null;
		}
	}

	
	
}
