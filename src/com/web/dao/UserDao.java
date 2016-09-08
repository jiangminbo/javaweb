package com.web.dao;

import java.util.List;

import com.web.entity.Menu;
import com.web.entity.Role;
import com.web.entity.User;
import com.web.vo.MenuVo;

public interface UserDao {

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
	public boolean loadAddClass(String className);
	
	/**
	 * 添加学生
	 * @return
	 */
	public boolean loadAddStudent(String snumber,String sname,String sex,String cid,
			String age,String Email,String description);
	
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
	 * 通过登录的账号的id加载次用拥有的菜单集合
	 * @param uid
	 * @return
	 */
	public List<Menu> loadMenusByUid(int uid);
	
	/**
	 * 展示菜单
	 * @param uid
	 * @return
	 */
	public List<MenuVo> loadAllMenuVO();
	
	/**
	 * 查询1.2级菜单，跳转到添加菜单的界面
	 * @param uid
	 * @return
	 */
	public List<Menu> load12Menus();
	
	/**
	 * 添加菜单
	 * @param name
	 * @param url
	 * @param isshow
	 * @param level
	 * @param parentid
	 */
	public void addMenu(String name,String url,int isshow,int parentid);
	
	
	/**
	 * 加载角色
	 * @return
	 */
	public List<Role> showRoles( int uid);
	
	/**
	 * 通过id加载角色对象
	 * @param uid
	 * @return
	 */
	public Role loadRoleById(int rid);
	
	/**
	 * 查询所菜单和当前用户已经拥有的菜单-展示角色权限
	 * @return 
	 */
	public List<Object[]> showRolePermission(int rid);
	
	/**
	 * 确认修改权限
	 * @param uid
	 * @param s
	 */
	public void affirmalterPermission(int rid,String[] s);
	
	/**
	 * 加载角色用户
	 * @param uid
	 * @return
	 */
	public List<Object[]> showRoleUser(int uid);
	
	
	
	/**
	 * 确认修改用户
	 * @param uid
	 * @param s
	 */
	public void affirmalterUser(int uid,String[] s);
	
	/**
	 * 检查当前这个用户是否拥有uri这个菜单权限
	 * @param uid
	 * @param uri
	 * @return 返回true表示有权限 返回false表示无权限
	 */
	public boolean checkUserMenu(int uid, String uri);
	
}
