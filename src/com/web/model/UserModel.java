package com.web.model;


import java.util.List;

import com.web.entity.Menu;
import com.web.entity.Role;
import com.web.entity.User;
import com.web.vo.MenuVo;

public interface UserModel {
	
	/**
	 * 通过用户名加载一个用户对象（登录）
	 * @param userName 用户输入的帐号
	 * @return 返回null表示用户的帐号不存在 
	 */
	public User loadUserByName(String userName);
	
	/**
	 * 注册账户
	 * @param userName
	 * @param userPass
	 * @param Email
	 * @param sex
	 * @param diploma
	 * @param hobbys
	 * @param description
	 * @return
	 */
	public boolean loadEnroll(String userName,String userPass,String Email,
			String sex,String diploma,String[] hobbys,String description);
	
	/**
	 * 加载所有用户-->查询用户
	 * @return
	 */
	public List<User> loadAllUsers();
	
	/**
	 * 通过登录的账号的id加载次用拥有的菜单集合
	 * @param uid
	 * @return
	 */
	public List<Menu> loadMenusByUid(int uid);
	
	/**
	 * 查看用户详细信息
	 * @return
	 */
	public List<User> loadLookUser(String id);
	
	/**
	 * 删除用户
	 * @return
	 */
	public boolean loadRemoveUser(String id);
	
	/**
	 * 加载所有班级-->查询班级
	 * @return
	 */
	public List loadAllClass();
	/**
	 * 加载所有学生-->查询学生
	 * @return
	 */
	public List loadAllStudent();
	
	/**
	 * 添加班级
	 * @return
	 */
	public boolean loadAllAddClass(String className);
	
	/**
	 * 添加学生
	 * @return
	 */
	public boolean loadAllAddStudent(String snumber,String sname,String sex,String cid,
			String age,String Email,String description);
	
	/**
	 * 展示菜单
	 * @param uid
	 * @return
	 */
	public List<MenuVo> loadAllMenuVO();
	
	/**
	 * 查询数据跳转到添加菜单的界面
	 * @param uid
	 * @return
	 */
	public List<Menu> load12Menus();
	
	/**
	 * 添加菜单
	 * @param name
	 * @param url
	 * @param isshow
	 * @param parentid
	 * @return 返回1表示添加成功，
	 */
	public void addMenu(String name,String url,int isshow,int parentid);
	
	
	/**
	 * 加载角色
	 * @return
	 */
	public List<Role> showRoles(int  rid);
	
	/**
	 * 通过id加载角色对象
	 * @param uid
	 * @return
	 */
	public Role loadRoleById(int rid);

	/**
	 * 展示角色权限
	 * @return 
	 */
	public List<Object[]> showRolePermission(int rid);
	
	/**
	 * 确认修改角色权限
	 * @param uid
	 * @param s
	 */
	public void affirmalterPermission(int rid,String[] s);
	
	/**
	 * 加载用户角色
	 * @param uid
	 * @return
	 */
	public List<Object[]> showUserRole(int rid);
	
	
	/**
	 * 确认修改用户角色
	 * @param rid
	 * @param s
	 */
	public void affirmalterUser(int rid,String[] s);
	
	/**
	 * 检查uid这个用户是否拥有uri这个菜单权限
	 * @param uid
	 * @param uri
	 * @return 返回true表示有权限 返回false表示无权限
	 */
	public boolean checkUserMenu(int uid, String uri);
	
	/**
	 * 展示部门
	 * @param uid
	 * @param uri
	 * @return 返回true表示有权限 返回false表示无权限
	 */
	public Role showdepartment(int uid);
	
	
	
	
}
