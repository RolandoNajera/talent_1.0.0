package com.globaltade.talent.servicio;

import com.globaltade.talent.transaction.TransactionExperience;

public interface IExperienceService {

	TransactionExperience getAllExperience();

	TransactionExperience getExperienceById(TransactionExperience transactionExperience);

	TransactionExperience saveExperience(TransactionExperience transactionExperience);

	TransactionExperience updateExperience(TransactionExperience transactionExperience);
	
	TransactionExperience deleteExperience(TransactionExperience transactionExperience);
	
}
