package sist.service.impl;

import java.util.Date;
import java.util.List;

import sist.bean.SupplyPagingBean;
import sist.bean.TeachSearchPage;
import sist.dao.JSGJDao;
import sist.dao.OptionDao;
import sist.domain.JSGJBean;
import sist.factory.BasicFactory;
import sist.service.JSGJService;
import sist.utils.URLUtil;

public class JSGJServiceImp implements JSGJService {

	private BasicFactory factory = BasicFactory.getFactory();
	/* (non-Javadoc)
	 * @see sist.service.JSGJService#saveOrUpdate(sist.domain.JSGJBean)
	 */
	@SuppressWarnings("deprecation")
	@Override
	public boolean saveOrUpdate(JSGJBean bean) {
		// ��ȡ������Ӧ��Ϣ��id
		Integer id = bean.getId();
		JSGJDao dao = factory.getDao(JSGJDao.class);
		// ����id�������ݿ����Ƿ����ָ����Ϣ
		if(dao.findById(id)==null){
			// ���ܴ���ָ��id����Ϣ
			bean.setTime(new Date().toLocaleString());
			String zlh = bean.getZlh();
			if(zlh==null||zlh.trim().isEmpty())
				bean.setZlh("δ��ע");
			String djh = bean.getDjh();
			if(djh==null||djh.trim().isEmpty())
				bean.setDjh("δ��ע");
			String dw = bean.getDw();
			if(dw==null||dw.trim().isEmpty())
				bean.setDh("δ��ע");
			String sfzl = bean.getSfzl();
			if(sfzl==null||sfzl.trim().isEmpty())
				bean.setSfzl("δ��ע");
			String zlzt = bean.getZlzt();
			if(zlzt==null||zlzt.trim().isEmpty())
				bean.setZlzt("δ��ע");
			String dh = bean.getDh();
			if(dh==null||dh.trim().isEmpty())
				bean.setDh("δ��ע");
			String dz = bean.getDz();
			if(dz==null||dz.trim().isEmpty())
				bean.setDz("δ��ע");
			String lxr = bean.getLxr();
			if(lxr==null||lxr.trim().isEmpty())
				bean.setLxr("δ��ע");
			// �����ݿ��������Ϣ
			return dao.add(bean);
		}else{
			// ����ָ��id����Ϣ���޸�ָ��id����Ϣ
			return dao.update(bean);
		}
	}
	@Override
	public List<JSGJBean> getList(SupplyPagingBean pagingBean) {
		// ����ǰ��ҳ��
		int currentPage = pagingBean.getCurrentPage();
		if(currentPage==0){
			currentPage = 1;
			pagingBean.setCurrentPage(1);
		}
		// ����ÿҳ��ʾ������
		int pageSize = pagingBean.getPageSize();
		if(pageSize==0){
			pageSize = 10;
			pagingBean.setPageSize(10);
		}
		
		JSGJDao dao = factory.getDao(JSGJDao.class);
		// ��ȡ��Ӧ��Ϣ
		List<JSGJBean> list = dao.getList(pagingBean);
		// ��ȡ��¼������
		int count = dao.getCount(pagingBean);
		// ��װ��Ϣ
		pagingBean.setTotalCount(count);
		pagingBean.setTotalPage(count%pageSize==0? count/pageSize:count/pageSize+1);
		String preUrl = "supplyServlet?method=list&result=list&"+URLUtil.preUrl(pagingBean);
		pagingBean.setPreUrl(preUrl);
		pagingBean.setAnd(true);
		return list;
	}
	@Override
	public JSGJBean getSupply(int id) {
		JSGJDao dao = factory.getDao(JSGJDao.class);
		JSGJBean bean = dao.findById(id);
		String xs = factory.getDao(OptionDao.class).getByIdOrName(bean.getXs());
		bean.setXs(xs);
		return bean;
	}
	@Override
	public boolean delById(int stringToInt) {
		JSGJDao dao = factory.getDao(JSGJDao.class);
		return dao.delById(stringToInt);
	}
	public void search(TeachSearchPage page)
    {
        JSGJDao dao = (JSGJDao)BasicFactory.getFactory().getDao(JSGJDao.class);
         List<JSGJBean> list = dao.search(page);
        page.setList(list);
        Integer integer = dao.searchCount(page);
        page.setTotalCount(integer.intValue());
        page.setTotalPage(integer.intValue() % page.getPageSize() != 0 ? integer.intValue() / page.getPageSize() + 1 : integer.intValue() / page.getPageSize());
    }
	@Override
	public boolean checkName(String name) {
		JSGJDao dao = BasicFactory.getFactory().getDao(JSGJDao.class);
		JSGJBean byName = dao.getByName(name);
		return byName!=null;
	}
}
