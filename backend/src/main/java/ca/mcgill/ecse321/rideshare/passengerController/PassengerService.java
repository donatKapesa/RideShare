package ca.mcgill.ecse321.rideshare.passengerController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ca.mcgill.ecse321.rideshare.model.Passenger;
import ca.mcgill.ecse321.rideshare.repo.PassengerRepository;
import ca.mcgill.ecse321.rideshare.repo.TripRepository;

@Service
@Transactional
public class PassengerService {
	
	@Autowired
	private PassengerRepository passengerRepo;

	@Autowired
	private TripRepository tripRepo;
	
	@Transactional
	public List<Passenger> getAllPassengers() {
		List<Passenger> passengers = new ArrayList<>();
		passengerRepo.findAll().forEach(passengers::add);
		return passengers;
	}
	
	@Transactional
	public Passenger getPassenger(String username) {
		return passengerRepo.findByUserName(username);
		}
	
	@Transactional
	public void addPassenger(Passenger passenger) {
		passengerRepo.save(passenger);
	}
	
	@Transactional
	public void updatePassenger(String username, Passenger passenger) {
		passengerRepo.save(passenger);
	}
	
	@Transactional
	public Optional<Passenger> deletePassenger(String username) {
		Optional<Passenger> passengerToDelete = passengerRepo.findById(username);
		tripRepo.deleteByPassengersUserName(username);
	//	passengerRepo.deleteById(username);
		return passengerToDelete;
	}
	
	@Transactional
	// active passengers
	public List<Passenger> getActivePassengers() {
		List<Passenger> activePassengers = new ArrayList<>();
		passengerRepo.findByIsActive(true).forEach(activePassengers::add);
		return activePassengers;
	}
}
