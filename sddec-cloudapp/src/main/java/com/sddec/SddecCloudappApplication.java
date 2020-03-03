package com.sddec;

import com.sddec.Model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;

@SpringBootApplication
public class SddecCloudappApplication implements CommandLineRunner {

	@Autowired
	UserRepository userRepo;

	@Autowired
	ResidentRepository residentRepo;

	@Autowired
	DoorSensorRepository doorSensorRepository;

	public static void main(String[] args) {
		SpringApplication.run(SddecCloudappApplication.class, args);
	}

	public void run(String... var1) throws Exception {
		/*//userRepo.deleteAll();
		//residentRepo.deleteAll();
		final User testUser = new User("Frank", "Sinatra Jr", "1234", new int(0), "frankieS");
		final Resident testResident = new Resident("Frank", "Sinatra Sr");
		//final DoorSensor testDoorSensor = new DoorSensor("U58ADTIYSXONNFV4S9");

		userRepo.save(testUser);
		residentRepo.save(testResident);
		//doorSensorRepository.save(testDoorSensor);

		final ArrayList<User> userResult = userRepo.findUserByFirstName(testUser.getFirstName());
		final Resident residentResult = residentRepo.findById(testResident.getResidentId()).get();

		System.out.printf("\n\n%s\n\n", userResult.get(0).toString());
		System.out.printf("\n\n%s\n\n", residentResult.toString());*/
	}
}
