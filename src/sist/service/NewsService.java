package sist.service;

import java.util.List;

import sist.bean.NewsPaging;
import sist.bean.PagingBean;
import sist.domain.NewsBean;

public interface NewsService extends Service {

	/**
	 * ��������޸����Ź���
	 * @param newsBean
	 * @return
	 */
	boolean saveOrUpdate(NewsBean newsBean);

	/**
	 * ��ѯ������Ϣ
	 * @param newsPaging
	 * @return
	 */
	List<NewsBean> getList(NewsPaging newsPaging);

	/**
	 * ͨ�����ŵ�idɾ��һ�����ż�¼
	 * @param id
	 * @return
	 */
	boolean delById(int id);

	/**
	 * ����id����ָ����������Ϣ
	 * @param id
	 * @return
	 */
	NewsBean getNews(int id);

	List<NewsBean> search(PagingBean pagingBean);

	/**
	 * ��֤���ű����Ƿ��Ѿ�������
	 * @param title	����֤�ı���
	 * @return		���������ڷ���false�����򷵻�true
	 */
	boolean checkTitle(String title);


}
