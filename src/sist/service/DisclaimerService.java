package sist.service;

import sist.domain.Disclaimer;

public interface DisclaimerService extends Service {

	boolean addOrUpdate(Disclaimer disclaimer);

}
