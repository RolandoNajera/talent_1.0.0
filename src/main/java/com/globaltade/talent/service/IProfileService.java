package com.globaltade.talent.service;

import com.globaltade.talent.transaction.TransactionProfile;

public interface IProfileService {

	TransactionProfile createProfile(TransactionProfile transactionProfileRequest);
	
	TransactionProfile updateProfile(TransactionProfile transactionProfileRequest);

	TransactionProfile removeProfile(TransactionProfile transactionProfileRequest);
	
	TransactionProfile getProfile(TransactionProfile transactionProfileRequest);
	
	TransactionProfile readProfiles();
	
	TransactionProfile getIdProfile(TransactionProfile transactionProfile);
	
}
