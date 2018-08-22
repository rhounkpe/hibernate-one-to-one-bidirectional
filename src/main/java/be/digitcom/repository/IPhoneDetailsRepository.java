package be.digitcom.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import be.digitcom.model.PhoneDetails;

public interface IPhoneDetailsRepository extends JpaRepository<PhoneDetails, Long> {

}
