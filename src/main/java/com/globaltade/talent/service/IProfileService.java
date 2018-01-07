package com.globaltade.talent.service;

import com.globaltade.talent.transaction.TransactionProfile;

public interface IProfileService {

	TransactionProfile createProfile(TransactionProfile transactionProfileRequest);
	
	TransactionProfile updateProfileByProfileId(TransactionProfile transactionProfileRequest);

	TransactionProfile removeProfileByProfileId(TransactionProfile transactionProfileRequest);
	
	TransactionProfile getProfileByProfileId(TransactionProfile transactionProfileRequest);
	
	TransactionProfile readProfiles(TransactionProfile transactionProfileRequest);
	
}
