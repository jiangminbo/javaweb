package com.web.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.jms.Session;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.web.entity.Menu;
import com.web.entity.Role;
import com.web.entity.User;
import com.web.model.UserModel;
import com.web.model.impl.UserModelMySQLImpl;
import com.web.util.JasperReportHelper;
import com.web.vo.MenuVo;
import com.web.vo.PageVo;

public class MainServlet  extends HttpServlet{
	private static final String vm = null;
	//控制层持有模型对象
	private UserModel userModel = new UserModelMySQLImpl();
	private Object menuList;
	private Object tomenuList;
	private String user;
	private String uid;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String methodName = req.getParameter("methodName");
		System.out.println(methodName);
		Class c = MainServlet.class;
		Method m = null;
		try {
			m = c.getMethod(methodName, HttpServletRequest.class,HttpServletResponse.class);
			m.invoke(this, req,resp);
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		
		
	}
	/**
	 * 登录方法
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void login(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		//取表单数据
		String userName = req.getParameter("userName");
		String userPass = req.getParameter("userPass");
		//查询数据库
		//2、查询数据库
		System.out.print("LoginServlet控制层==>");
		User user = userModel.loadUserByName(userName);
		
		//利用上面的查询判断，并给出不同提示
		if(null != user){
			System.out.println("账号正确");
			//账号正确
			if(userPass.equals(user.getUserPass())){
				//密码正确
				//保存数据到整个项目
				List<Menu> menuList = userModel.loadMenusByUid(user.getUid());
				
				
				System.out.println(menuList.size());//活的數組長度
				Menu m = menuList.get(0);
				System.out.println(m.getMid()+"==>"+m.getIsshow()+"==>"+m.getLevel()+"==>"+m.getName()+"==>"+m.getUrl()+"==>"+m.getParentid());
				
				req.getSession().setAttribute("loginUser", user);
				req.getSession().setAttribute("menuList", menuList);
				req.getRequestDispatcher("view/welcome.jsp").forward(req, resp);
			}else{
				//密码错了,给出提示，跳转页面到登录页面
				req.setAttribute("error", "密码错误！");
				req.getRequestDispatcher("view/login.jsp").forward(req, resp);
			}
		}else{
			//账号不存在
			req.setAttribute("error", "账号不存在！");
			req.getRequestDispatcher("view/login.jsp").forward(req, resp);
		}
	}
	
	/**
	 * 退出
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void logout(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.getSession().invalidate();
		resp.sendRedirect("view/login.jsp");
	}
	
	/**
	 * 注册
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void enroll(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String userName = req.getParameter("userName");
		String userPass = req.getParameter("userPass");
		String Email = req.getParameter("Email");
		String sex = req.getParameter("sex");
		String diploma = req.getParameter("diploma");
		String[] hobbys = req.getParameterValues("hobbys");
		String description = req.getParameter("description");
		boolean b = userModel.loadEnroll(userName, userPass, Email, sex, diploma, hobbys, description);
		if(b==true){
			//注册成功
			req.getRequestDispatcher("view/login.jsp").forward(req, resp);
		}else{
			//注册失败
			req.setAttribute("re", "已被占用!");
			resp.sendRedirect("view/enroll.jsp");
		}
	}
	
	
		
		/**
		 * 展示用户
		 * @param req
		 * @param resp
		 * @throws ServletException
		 * @throws IOException
		 */
	public void showAllUsers(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {	
		List<User> userList = userModel.loadAllUsers();
		req.setAttribute("userList", userList);
		req.getRequestDispatcher("view/showAllUsers.jsp").forward(req, resp);
		System.out.println();
	}
	/**
	 * 添加菜单
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	
	public void addMenu(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {	
		List<User> userList = userModel.loadAllUsers();
		req.setAttribute("menuListt", menuList);
		req.getRequestDispatcher("view/addMenu.jsp").forward(req, resp);
	}

	
	public void toAddMenu(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {	
		List<User> userList = userModel.loadAllUsers();
		req.setAttribute("tomenuListt", tomenuList);
		req.getRequestDispatcher("view/toaddMenu.jsp").forward(req, resp);
	}
	
	/**
	 * 修改角色
	 * 展示角色权限--修改角色权限
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void howUserPermissions(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String rid = req.getParameter("u_id");
		List<Object[]>  list = userModel.showRolePermission(Integer.valueOf(rid));
		req.setAttribute("executeAlterUser", list);
		
		Role role = userModel.loadRoleById(Integer.valueOf(rid));
		req.setAttribute("role", role);
		req.getRequestDispatcher("view/showUser.jsp").forward(req, resp);
	}
	/**
	 * 确认修改权限
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void executeAlterUser(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String rid = req.getParameter("u_id");
		String[] mid = req.getParameterValues("mids");
		System.out.println(rid);
		userModel.affirmalterPermission(Integer.valueOf(rid), mid);
		req.setAttribute("msg", "修改成功!");
		this.showUserPermissions(req, resp);
	}
	
	/**
	 * 展示菜单列表
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void showMenus(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		List<MenuVo> list = userModel.loadAllMenuVO();
		req.setAttribute("menusList", list);
		req.getRequestDispatcher("view/showMenus.jsp").forward(req, resp);
	}


	/**
	 * 加载角色列表
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void showAllRoles(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		List<Role> roleList = userModel.showRoles(0);
		req.setAttribute("roleList", roleList);
		req.getRequestDispatcher("view/showRole.jsp").forward(req, resp);
		System.out.println(roleList+"===============>");
		
		System.out.print("showRoles控制层==>");
	}
	/**
	 * 加载角色用户
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void showRole(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String rid = req.getParameter("rid");
		
		List<Object[]>  list = userModel.showRoleUser(Integer.valueOf(rid));
		req.setAttribute("showRoleUser", list);
		System.out.println(list.size());
		
		Role role = userModel.loadRoleById(Integer.valueOf(rid));
		req.setAttribute("role", role);
		req.getRequestDispatcher("view/showRoleUser.jsp").forward(req, resp);
	}
	
	/**
	 * 确认修改角色用户
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void affirmUser(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String rid = req.getParameter("rid");
		String[] rids = req.getParameterValues("rids");
		
		userModel.affirmalterUser(Integer.valueOf(uid), rids);
		req.setAttribute("msg", "修改成功!");
		this.showRole(req, resp);
	}
	/**
	 * 跳转到添加菜单列表
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void goAddMenu(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		List<Menu> list = userModel.load12Menus();
		req.setAttribute("menuList", list);
		req.getRequestDispatcher("view/addMenu.jsp").forward(req, resp);
	}
	
	/**
	 * 下载
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void download(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String fileName = "王童语-丫头.mp3";
		String realPath = this.getServletContext().getRealPath("/")+fileName;
		
		File file = new File(realPath);
		
		Enumeration<String> enume = req.getHeaders("User-Agent");
		fileName = enume.nextElement().contains("Firefox")?new String(file.getName().getBytes("utf-8"),"iso-8859-1") : URLEncoder.encode(file.getName(), "utf-8");
		
		//响应设置
		resp.setContentType("application/octet-stream");
		resp.setHeader("Content-Disposition", "attachment;filename="+fileName);
		resp.setHeader("Content-Location", fileName);
		resp.setHeader("Content-Length", file.length()+"");
		
		InputStream in = new FileInputStream(file);
		OutputStream out = resp.getOutputStream();
		//缓冲下载
		byte[] bs = new byte[1024*10240];
		int i;
		while((i = in.read(bs)) != -1){
			out.write(bs, 0, i);
		}
		
		out.flush();
		out.close();
		in.close();
	}
	/**
	 * 展示角色权限--加载角色菜单
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void showUserPermissions(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String rid = req.getParameter("rid");
		List<Object[]>  list = userModel.showRolePermission(Integer.valueOf(rid));
		req.setAttribute("ShowUserPermissions", list);
		
		Role role = userModel.loadRoleById(Integer.valueOf(rid));
		req.setAttribute("role", role);
		req.getRequestDispatcher("view/showPermission.jsp").forward(req, resp);
	}
	/**
	 * 确认修改权限
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void affirm(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String rid = req.getParameter("rid");
		String[] mid = req.getParameterValues("mids");
		System.out.println(rid);
		userModel.affirmalterPermission(Integer.valueOf(rid), mid);
		req.setAttribute("msg", "修改成功!");
		this.showUserPermissions(req, resp);
	}
	
//	public void showbaobiao(HttpServletRequest req, HttpServletResponse resp)
//			throws ServletException, IOException {
//		req.setCharacterEncoding("utf-8");
//		String pN=req.getParameter("pageNo");
//		int pageNo=null!=pN&&!"".equals(pN)?Integer.valueOf(pN):1;
//		String pS=req.getParameter("pageSize");
//		int pageSize=null!=pN&&!"".equals(pS)?Integer.valueOf(pS):10;
//	
//		PageVo<User> page=vm.userDataManage(pageNo,pageSize);
//		JasperReportHelper<User> helper=new JasperReportHelper();
//		Map<String,Object> map=new HashMap<String, Object>();
//		String jaspporFilePath=this.getServletContext().getRealPath("")+"JasperReportHelper.java";
//	}
}
