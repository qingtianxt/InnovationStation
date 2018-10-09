package sist.dao;

import java.util.List;

import sist.bean.CoopSitePage;
import sist.domain.CoopSite;

public interface CoopSiteDao extends Dao {

	CoopSite findSiteById(Integer id);

	boolean addSite(CoopSite site);

	boolean updateSite(CoopSite site);

	List<CoopSite> getList(CoopSitePage sitePage);

	int getCount(CoopSitePage sitePage);

	/**
	 * ͨ��id��ȡվ����Ϣ
	 * @param id
	 * @return
	 */
	CoopSite getCoopSite(int id);

	boolean delById(int id);

	CoopSite getByName(String name);

}
