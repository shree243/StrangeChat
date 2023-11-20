package com.Project.demo.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Project.demo.entity.User;
import com.Project.demo.entity.UserRegistrationDetails;
import com.Project.demo.entity.UserResponse;
import com.Project.demo.entity.userRequestDto;
import com.Project.demo.repository.UsersRepository;

@Service
public class UserServiceImpl {

	@Autowired
	private UsersRepository userRepo;

	public List<User> findAll() {
		return userRepo.findAll();
	}

	public User save(UserRegistrationDetails userRegistrationDetails) {
		User user = new User();
		user.setUsername(userRegistrationDetails.getUsername());
		user.setPassword(userRegistrationDetails.getPassword());
		user.setFirstname(userRegistrationDetails.getfirstname());
		user.setLastname(userRegistrationDetails.getfirstname());
		return userRepo.save(user);
	}

	public User update(User User) {
		User user = userRepo.findAllById(User.getId());
		user.setUsername(User.getUsername());
		user.setId(User.getId());
		user.setFirstname(User.getFirstname());
		user.setLastname(User.getLastname());
		user.setPassword(User.getPassword());
		return user;
	}

	public void delete(Long id) {
		User User = userRepo.findAllById(id);
		userRepo.delete(User);
	}

	public User getUser(String userName) {
//		User User = userRepo.findAllById(id);
		User user = userRepo.findByUserName(userName);
		return user;
	}

	public List<UserResponse> getLat(userRequestDto entity) {
		double resultDistance;
		User userById = userRepo.findAllById(entity.getId());
		userById.setLatitude(entity.getLatitude());
		userById.setLongitude(entity.getLongitude());
		userRepo.save(userById);
		List<User> usersList = userRepo.findAll();
		List<User> usersResultList = new ArrayList<>();
		List<UserResponse> usersResponseList = new ArrayList<>();

		for (User users : usersList) {
			String latus = users.getLatitude();
			String longus = users.getLongitude();

			double lat1 = Double.parseDouble(latus);
			double lon1 = Double.parseDouble(longus);

			String ulat = entity.getLatitude();
			String ulongi = entity.getLongitude();

			double lat2 = Double.parseDouble(ulat);
			double lon2 = Double.parseDouble(ulongi);

			String unit = entity.getUnit();

			if ((lat1 == lat2) && (lon1 == lon2)) {
				return null;
			} else {
				double theta = lon1 - lon2;
				double dist = Math.sin(Math.toRadians(lat1)) * Math.sin(Math.toRadians(lat2))
						+ Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
								* Math.cos(Math.toRadians(theta));
				dist = Math.acos(dist);
				dist = Math.toDegrees(dist);
				dist = dist * 60 * 1.1515;
				if (unit.equals("K")) {
					dist = dist * 1.609344;
				} else if (unit.equals("N")) {
					dist = dist * 0.8684;
				}
				resultDistance = dist;
			}
			double radiusD = Double.parseDouble(entity.getRadius());
			if (radiusD > resultDistance) {
				UserResponse userResponse = new UserResponse();
				userResponse.setLatitude(users.getLatitude());
				userResponse.setLongitude(users.getLongitude());
				userResponse.setFirstname(users.getFirstname());
				userResponse.setLastname(users.getLastname());
				usersResponseList.add(userResponse);
			}

		}
		return usersResponseList;

//		User User = userRepo.findAllById(entity.getId());

//		String dlat = User.getLatitude();
//		String dlongi = User.getLongitude();

	}

}
