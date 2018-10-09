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
		// 获取技术供应信息的id
		Integer id = bean.getId();
		JSGJDao dao = factory.getDao(JSGJDao.class);
		// 根据id查找数据库中是否存在指定信息
		if(dao.findById(id)==null){
			// 不能存在指定id的信息
			bean.setTime(new Date().toLocaleString());
			String zlh = bean.getZlh();
			if(zlh==null||zlh.trim().isEmpty())
				bean.setZlh("未标注");
			String djh = bean.getDjh();
			if(djh==null||djh.trim().isEmpty())
				bean.setDjh("未标注");
			String dw = bean.getDw();
			if(dw==null||dw.trim().isEmpty())
				bean.setDh("未标注");
			String sfzl = bean.getSfzl();
			if(sfzl==null||sfzl.trim().isEmpty())
				bean.setSfzl("未标注");
			String zlzt = bean.getZlzt();
			if(zlzt==null||zlzt.trim().isEmpty())
				bean.setZlzt("未标注");
			String dh = bean.getDh();
			if(dh==null||dh.trim().isEmpty())
				bean.setDh("未标注");
			String dz = bean.getDz();
			if(dz==null||dz.trim().isEmpty())
				bean.setDz("未标注");
			String lxr = bean.getLxr();
			if(lxr==null||lxr.trim().isEmpty())
				bean.setLxr("未标注");
			// 向数据库中添加信息
			return dao.add(bean);
		}else{
			// 存在指定id的信息，修改指定id的信息
			return dao.update(bean);
		}
	}
	@Override
	public List<JSGJBean> getList(SupplyPagingBean pagingBean) {
		// 处理当前的页码
		int currentPage = pagingBean.getCurrentPage();
		if(currentPage==0){
			currentPage = 1;
			pagingBean.setCurrentPage(1);
		}
		// 处理每页显示数据量
		int pageSize = pagingBean.getPageSize();
		if(pageSize==0){
			pageSize = 10;
			pagingBean.setPageSize(10);
		}
		
		JSGJDao dao = factory.getDao(JSGJDao.class);
		// 获取供应信息
		List<JSGJBean> list = dao.getList(pagingBean);
		// 获取记录总条数
		int count = dao.getCount(pagingBean);
		// 封装信息
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
