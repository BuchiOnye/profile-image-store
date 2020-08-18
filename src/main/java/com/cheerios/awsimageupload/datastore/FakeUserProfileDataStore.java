package com.cheerios.awsimageupload.datastore;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.cheerios.awsimageupload.profile.UserProfile;

@Repository
public class FakeUserProfileDataStore {
	
	private static final List<UserProfile> USER_PROFILES =  new ArrayList<>();
	
	static {
		USER_PROFILES.add(new UserProfile(UUID.fromString("6dfa35ce-0b9d-4a4a-aef8-93e693afea93"), "jane", null));
		USER_PROFILES.add(new UserProfile(UUID.fromString("1504242f-74c9-4cd4-abac-4ece7a40675f"), "janet", null));
	}
	
	public List<UserProfile> getUserProfiles(){
		return USER_PROFILES;
	}

}
