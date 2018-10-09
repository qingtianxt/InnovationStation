package sist.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import sist.bean.PagingBean;
import sist.utils.URLUtil;

public class PageTag2 extends SimpleTagSupport {
 
	@Override
	public void doTag() throws JspException, IOException {
		init();
		StringBuffer sb = new StringBuffer();
		if(pagingBean!=null){
			
			int totalPage = pagingBean.getTotalPage();
			int currentPage = pagingBean.getCurrentPage();
			int pageSize = pagingBean.getPageSize();
			int totalCount = pagingBean.getTotalCount();
			
			sb.append("<div class='").append(css).append("' style='text-align:center;'>");
			sb.append("共<span>").append(totalCount).append("</span>条记录，每页显示<span>").append("<input type='number' max='50' min='1' id='number' value='")
			.append(pageSize).append("' style='width:35px' onkeypress='return fun()' onchange='page(1,this.value)'></span>条").append("，共").append(pagingBean.getTotalPage()).append("页")
			.append("，当前是第<span>")
			.append("<input type='number' max='").append(totalPage).append("' min='1' id='number' value='")
			.append(currentPage).append("' style='width:35px' onkeypress='return fun()' onchange='page(this.value,"+pagingBean.getPageSize()+")'>").append("</span>页&nbsp;&nbsp;");
			if(currentPage<=1){
				sb.append("&nbsp;<a>首页</a>&nbsp;");
				sb.append("&nbsp;<a>上一页</a>&nbsp;");
			}else{
				sb.append("&nbsp;<a href='").append(pagingBean.getPreUrl())
					.append(pagingBean.isAnd()? "&":"?").append("currentPage=1")
					.append("&pageSize=").append(pagingBean.getPageSize())
					.append("'>首页</a>&nbsp;");
				sb.append("&nbsp;<a href='").append(pagingBean.getPreUrl())
					.append(pagingBean.isAnd()? "&":"?").append("currentPage=")
					.append(pagingBean.getCurrentPage()-1)
					.append("&pageSize=").append(pagingBean.getPageSize())
					.append("'>上一页</a>&nbsp;");
			}
			
			if(currentPage>=totalPage){
				sb.append("&nbsp;<a>下一页</a>&nbsp;");
				sb.append("&nbsp;<a>尾页</a>&nbsp;");
			}else{
				sb.append("&nbsp;<a href='").append(pagingBean.getPreUrl())
				.append(pagingBean.isAnd()?"&":"?").append("currentPage=")
				.append(pagingBean.getCurrentPage()+1).append("&pageSize=").append(pagingBean.getPageSize()).append("'>下一页</a>&nbsp;");
				sb.append("&nbsp;<a href='").append(pagingBean.getPreUrl())
				.append(pagingBean.isAnd()?"&":"?").append("currentPage=")
				.append(totalPage).append("&pageSize=").append(pagingBean.getPageSize()).append("'>尾页</a>&nbsp;");
			}
			
			sb.append("</div>");
			sb.append("<script type='text/javascript'> function fun(e){ var s ; if(window.event){s = String.fromCharCode(window.event.keyCode);}else{ s = String.fromCharCode(e.keyCode); } var reg = /[0-9]/; var f = reg.test(s); return f;}");
			sb.append("function page(currentPage,pageSize){ var url = '").append(pagingBean.getPreUrl()).append("&currentPage='+currentPage+'&pageSize='+pageSize; location.href=url;}</script>");
		}
		getJspContext().getOut().write(sb.toString());
	}
	private PagingBean pagingBean;
	private String css="";
	private String preUrl="";
	
	private void init(){
		if(pagingBean!=null&&!preUrl.isEmpty()){
			String url =preUrl +"&" + URLUtil.preUrl(pagingBean);
			pagingBean.setPreUrl(url);
			pagingBean.setAnd(true);
		}
	}
	
	public PagingBean getPagingBean() {
		return pagingBean;
	}
	public void setPagingBean(PagingBean pagingBean) {
		this.pagingBean = pagingBean;
	}
	public String getCss() {
		return css;
	}
	public void setCss(String css) {
		this.css = css;
	}
	public String getPreUrl() {
		return preUrl;
	}
	public void setPreUrl(String preUrl) {
		this.preUrl = preUrl;
	}
	
}
