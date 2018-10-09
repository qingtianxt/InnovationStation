package sist.utils;

/**
 * @author wzw
 *	常量保存器
 */
public interface Constant {
	/**
	 * session中的用户
	 */
	String SESSION_USER  = "session_user";
	/**
	 * 技术所属领域的信息
	 */
	String JSSSLY = "jsssly";
	/**
	 * 技术所属领域单个信息
	 */
	String JSSSLYBEAN="jssslyBean";
	/**
	 * 设置企业需求审核的分页
	 */
	Integer QYXQ_SH_PAGESIZE =10;
	
	Integer QYXQ_KEY_PAGESIZE =5;
	
	/**
	 * 企业需求的session_pagebean
	 */
	String QYXQPAGINGBEAN = "qyxqPagingBean";
	
	
	/**
	 * 企业需求bean（单个信息）
	 */
	String JSXQBEAN="jsxqBean";
	
	String JSXQBEANS = "jsxqBeans";
	/**
	 * 所属高新技术类别
	 */
	String SSGXJSLB="ssgxjslb";
	/**
	 * 技术体现形式
	 */
	String JSTXXS = "jstxxs";
	/**
	 * 科技成果pagebean
	 */
	int KJCGPAGESIZE = 10;
	String KJCGPAGINGBEAN = "kjcgPagingBean";
	/**
	 * 科技成果pagebean模糊查询
	 */
	int KJCG_KEY_PAGESIZE = 5;
	/**
	 * 科技成果bean
	 */
	String KJCGBEAN ="kjcgBean";
	String KJCGBEANS = "kjcgBeans";
	
	
	/**
	 * 成果转化项目bean
	 */
	String CGZHXMBEAN = "cgzhxmBean";
	/**
	 * 成功案例bean
	 */
	String CGALBEAN = "cgalBean";
	/**
	 * 专家PagingBean
	 */
	String ZJXXPAGINGBEAN = "zjxxPagingBean";
	/**
	 * 专家信息分页每页的条数
	 */
	int ZJXXPAGESIZE = 10;
	/**
	 * 专家信息分页每页的条数模糊查询
	 */
	int KEY_ZJXXPAGESIZE = 5;
	/**
	 * 专家信息bean
	 */
	String ZJXXBEAN = "zjxxBean";
	String ZJXXBEANS = "zjxxBeans";
	/**
	 * 主要针对对象beans
	 */
	String ZYZDDX = "zyzddx";
	/**
	 * 政策法令pageSize
	 */
	int ZCFGPAGESIZE = 10;
	/**
	 * 政策法规模糊查询pageSize
	 */
	int KEY_ZCFGPAGESIZE=5;
	/**
	 * 政策法规pagingBean
	 */
	String ZCFGPAGINGBEAN = "zcfgPagingBean";
	/**
	 * 政策法规bean
	 */
	String ZCFGBEAN = "zcfgBean";
	String ZCFGBEANS = "zcfgBeans";
	/**
	 * 应用行业字段
	 */
	String YYHY ="yyhy";
	/**
	 * msg
	 */
	String MSG = "msg";
	/**
	 * 首页显示前几条数据
	 */
	int TOPSIZE =5;
	
	int FWPT_KEY_PAGESIZE=5;
	
	/**
	 * 服务平台beans
	 */
	String FWPTBEANS = "FwptBeans";
	
	/**
	 * 服务平台bean
	 */
	String FWPTBEAN = "FwptBean";
	
	/**
	 * 成功案例pagebean模糊查询
	 */
	int CGAL_KEY_PAGESIZE = 5;
	/**
	 * 服务平台pagingBean
	 */
	String FWPTPAGINGBEAN = "fwptPagingBean";
	/**
	 * 服务平台pageSize
	 */
	int FWPTPAGESIZE = 10;
}
