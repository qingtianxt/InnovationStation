package sist.service;

import java.util.List;

import sist.bean.CoopSitePage;
import sist.domain.CoopSite;

public interface CoopSiteService extends Service {

	/**
	 * ��������޸�
	 * @param site
	 * @return
	 */
	boolean saveOrUpdate(CoopSite site);

	/**
	 * ��ҳ��ȡ����վ����Ϣ
	 * @param sitePage
	 * @return
	 */
	List<CoopSite> getList(CoopSitePage sitePage);

	/**
	 * ͨ��id��ȡվ����Ϣ
	 * @param id
	 * @return
	 */
	CoopSite getCoopSite(int id);

	boolean delById(int id);

	/**
	 * ���ָ�����Ƶĺ���վ���Ƿ��Ѿ�����.
	 * @param name	������վ������
	 * @return		���վ����ڷ���false,�����վ������Ʋ����ڷ���true
	 */
	boolean checkSiteName(String name);

}
