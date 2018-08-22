package be.digitcom.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import be.digitcom.model.Phone;

public interface IPhoneRepository extends JpaRepository<Phone, Long> {

}