package com.web.model.impl;

import java.util.List;

import com.web.dao.UserDao;
import com.web.dao.impl.UserDaoImpl;
import com.web.entity.Menu;
import com.web.entity.Role;
import com.web.entity.User;
import com.web.model.UserModel;
import com.web.vo.MenuVo;

public class UserModelMySQLImpl implements UserModel{

	//模型层持有一个DAO层对象
	private UserDao userDao = new UserDaoImpl();
	
	/**
	 * 通过用户名加载一个用户对象（登录）
	 * @param userName 用户输入的帐号
	 * @return 返回null表示用户的帐号不存在 
	 */
	public User loadUserByName(String userName){
		System.out.print("UserModelMySQLImpl模型==>");
		return userDao.loadUserByName(userName);
	}
	
	/**
	 * 通过登录的账号的id加载次用拥有的菜单集合
	 * @param uid
	 * @return
	 */
	public List<Menu> loadMenusByUid(int uid){
		return userDao.loadMenusByUid(uid);
	}
	
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
			String sex,String diploma,String[] hobbys,String description){
		return userDao.loadEnroll(userName, userPass, Email, sex, diploma, hobbys, description);
	}
	
	/**
	 * 加载所有用户-->查询用户
	 * @return
	 */
	public List<User> loadAllUsers(){
		return userDao.loadAllUsers();
	}
	
	/**
	 * 查看用户详细信息
	 * @return
	 */
	public List<User> loadLookUser(String id){
		return userDao.loadLookUser(id);
	}
	
	/**
	 * 删除用户
	 * @return
	 */
	public boolean loadRemoveUser(String id){
		return userDao.loadRemoveUser(id);
	}
	
	/**
	 * 加载所有班级-->查询班级
	 * @return
	 */
	public List loadAllClass(){
		return userDao.loadAllClass();
	}
	/**
	 * 加载所有学生-->查询学生
	 * @return
	 */
	public List loadAllStudent(){
		return userDao.loadAllStudent();
	}
	
	/**
	 * 添加班级
	 * @return
	 */
	public boolean loadAllAddClass(String className){
		return userDao.loadAddClass(className);
	}
	
	/**
	 * 添加学生
	 * @return
	 */
	public boolean loadAllAddStudent(String snumber,String sname,String sex,String cid,
			String age,String Email,String description){
		return userDao.loadAddStudent(snumber, sname, sex, cid, age, Email, description);
	}
	
	/**
	 * 
	 * @return
	 */
	public List<MenuVo> loadAllMenuVO(){
		return userDao.loadAllMenuVO();
	}


	/**
	 * 查询数据跳转到添加菜单的界面
	 * @param uid
	 * @return
	 */
	public List<Menu> load12Menus(){
		return userDao.load12Menus();
	}
	/**
	 * 开始添加菜单
	 */
	public void addMenu(String name,String url,int isshow,int parentid){
		userDao.addMenu(name, url, isshow, parentid);
	}
	
	/**
	 * 通过id加载角色对象
	 * @param uid
	 * @return
	 */
	public Role loadRoleById(int uid){
		return userDao.loadRoleById(uid);
	}
	
	/**
	 * 加载角色
	 * @return
	 */
	public List<Role> showRoles(int  rid){
		return userDao.showRoles(rid);
	}
	
	/**
	 * 查询所菜单和当前用户已经拥有的菜单-展示角色权限
	 * @return 
	 */
	public List<Object[]> showRolePermission(int uid){
		 return userDao.showRolePermission(uid);
	}
	
	/**
	 * 确认修改权限
	 * @param uid
	 * @param s
	 */
	public void affirmalterPermission(int rid,String[] s){
		userDao.affirmalterPermission(rid, s);
	}
	
	/**
	 * 加载角色用户
	 * @param uid
	 * @return
	 */
	public List<Object[]> showRoleUser(int uid){
		return userDao.showRoleUser(uid);
	}
	
	/**
	 * 确认修改用户
	 * @param uid
	 * @param s
	 */
	public void affirmalterUser(int uid,String[] s){
		userDao.affirmalterUser(uid, s);
	}
	
	/**
	 * 检查uid这个用户是否拥有uri这个菜单权限
	 * @param uid
	 * @param uri
	 * @return 返回true表示有权限 返回false表示无权限
	 */
	public boolean checkUserMenu(int uid, String uri){
		return userDao.checkUserMenu(uid, uri);
	}
}
