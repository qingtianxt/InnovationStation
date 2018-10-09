package sist.service.impl;

import java.util.List;

import sist.bean.LibPageBean;
import sist.dao.SpeLibDao;
import sist.domain.SpecialLibrary;
import sist.factory.BasicFactory;
import sist.service.SpeLibService;
import sist.utils.URLUtil;

public class SpeLibServiceImp implements SpeLibService {

	BasicFactory factory = BasicFactory.getFactory();
	@Override
	public boolean saveOrUpdate(SpecialLibrary lib) {
		SpeLibDao dao = factory.getDao(SpeLibDao.class);
		if(dao.findById(lib.getId())==null){
			return dao.add(lib);
		}else{
			return dao.update(lib);
		}
	}
	@Override
	public List<SpecialLibrary> getList(LibPageBean page) {
		SpeLibDao dao = factory.getDao(SpeLibDao.class);
		if(page != null)
        {
            int currentPage = page.getCurrentPage();
            if(currentPage == 0)
            {
                currentPage = 1;
                page.setCurrentPage(1);
            }
            int pageSize = page.getPageSize();
            if(pageSize == 0)
            {
                pageSize = 10;
                page.setPageSize(10);
            }
            int count = dao.getCount(page);
            page.setTotalCount(count);
            page.setTotalPage(count % pageSize != 0 ? count / pageSize + 1 : count / pageSize);
            page.setPreUrl((new StringBuilder("libraryServlet?method=list&result=list&")).append(URLUtil.preUrl(page)).toString());
            page.setAnd(true);
        }
       List<SpecialLibrary> list = dao.getList(page);
		
		return list;
	}
	@Override
	public SpecialLibrary getLibrary(int id) {
		SpeLibDao dao = factory.getDao(SpeLibDao.class);
		
		return dao.findById(id);
	}
	@Override
	public boolean delById(int id) {
		return factory.getDao(SpeLibDao.class).delById(id);
	}
	@Override
	public boolean checkTitle(String title) {
		SpeLibDao dao = factory.getDao(SpeLibDao.class);
		SpecialLibrary lib = dao.getByTitle(title);
		return lib==null;
	}

}
