package com.web.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.entity.User;
import com.web.model.UserModel;
import com.web.model.impl.UserModelMySQLImpl;

public class LoginFilter implements Filter{

	public void destroy() {
		
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		System.out.println("执行过滤");
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse)response;
		
		req.setCharacterEncoding("utf-8");
		String methodName = req.getParameter("methodName");
		if("login".equals(methodName)||"logout".equals(methodName)||"enroll".equals(methodName)){
			System.out.println("特权放行");
			//通过
			chain.doFilter(request, response);
		}else{
			User user =(User)req.getSession().getAttribute("loginUser");
			if(null == user){
				req.getSession().setAttribute("error", "请先登录在访问！");
				String path = req.getContextPath();
				String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
				PrintWriter out = response.getWriter();
				out.write("<script type='text/javascript'>window.top.location.href='"+basePath+"login.jsp'</script>");
			}else{
				String uri = req.getServletPath();
				uri = uri.substring(1);
				UserModel um = new UserModelMySQLImpl();
				System.out.println("===========>"+uri);
				boolean b = um.checkUserMenu(user.getUid(), uri);
				if(b){
					chain.doFilter(req, resp);
				}else{
					req.setAttribute("noRightError", "对不起,你没有访问此资源的权限!");
					req.getRequestDispatcher("view/noPermission.jsp").forward(req, resp);
				}
			}
		}
	}
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

}
