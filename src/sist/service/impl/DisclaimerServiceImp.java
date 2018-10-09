package sist.service.impl;

import sist.dao.DisclaimerDao;
import sist.domain.Disclaimer;
import sist.factory.BasicFactory;
import sist.service.DisclaimerService;

public class DisclaimerServiceImp implements DisclaimerService {

	@Override
	public boolean addOrUpdate(Disclaimer disclaimer) {
		DisclaimerDao dao = BasicFactory.getFactory().getDao(DisclaimerDao.class);
		Integer id = disclaimer.getId();
		if(id==null){
//			id = dao.getMaxId();
//			disclaimer.setId(id);
			return dao.add(disclaimer);
		}
		Disclaimer disc = dao.getById(id);
		if(disc==null){
			return dao.add(disclaimer);
		}else{
			return dao.update(disclaimer);
		}
	}

}
