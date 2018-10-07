package ca.mcgill.ecse321.rideshare.adminOperationsController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ca.mcgill.ecse321.rideshare.model.Trip;

@RestController
public class AdminOperationsController {
	@Autowired
	private AdminOperationsService adminOpService;
	
	// @RequestMapping("/admin/operations")
	// return list of active trips, users and passengers
	// reutrn top drivers and passengers
	
	@RequestMapping("/admin/operations/trips")
	public List<Trip> getAllTrips() {
		return adminOpService.getAllTrips();
	}
	
	// TODO: getTrip(int id)
	
	@RequestMapping(method=RequestMethod.POST, value = "/admin/operations/trips") // why doesn't it work when this address is the same as GET
	// handle uniqueness of id in front end?
	public String addTrip(@RequestBody Trip trip) {
		adminOpService.addNewtrip(trip); // TODO: take care of ID here
		return "YOU POSTED A NEW TRIP";
	}
	
//	@RequestMapping("/admin/operations/trips/active")
	
//	public List<Trip> getActiveTrips() {
//		return adminOpService.getAllActiveTrips();
//	}
}
