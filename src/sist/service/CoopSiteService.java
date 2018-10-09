package sist.service;

import java.util.List;

import sist.bean.CoopSitePage;
import sist.domain.CoopSite;

public interface CoopSiteService extends Service {

	/**
	 * 保存或者修改
	 * @param site
	 * @return
	 */
	boolean saveOrUpdate(CoopSite site);

	/**
	 * 分页获取合作站点信息
	 * @param sitePage
	 * @return
	 */
	List<CoopSite> getList(CoopSitePage sitePage);

	/**
	 * 通过id获取站点信息
	 * @param id
	 * @return
	 */
	CoopSite getCoopSite(int id);

	boolean delById(int id);

	/**
	 * 检测指定名称的合作站点是否已经存在.
	 * @param name	待检测的站点名称
	 * @return		如果站点存在返回false,如果该站点的名称不存在返回true
	 */
	boolean checkSiteName(String name);

}
