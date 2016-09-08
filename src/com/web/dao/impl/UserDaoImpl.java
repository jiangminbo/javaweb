package com.web.dao.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;

import com.web.dao.UserDao;
import com.web.entity.Menu;
import com.web.entity.Role;
import com.web.entity.User;
import com.web.util.DBUtil;
import com.web.vo.MenuVo;

public class UserDaoImpl implements UserDao{

	private Object uid;

	/**
	 * 通过用户名加载一个用户对象（登录）
	 * @param userName 用户输入的帐号
	 * @return 返回null表示用户的帐号不存在 
	 */
	public User loadUserByName(String userName){
		System.out.println("UserDaoImpl数据层");
		String sql = "select * from user where u_name=?";
		List<Object[]> list = DBUtil.executeDQL(sql, new Object[]{userName});
		
		if(null != list && list.size() > 0){
			Object[] ob = list.get(0);
			//, (String)(ob[1]), (String)(ob[2]), , , , , (String)(ob[7]),(String)(ob[8]),(String)(ob[9]),(String)(ob[10]),(String)(ob[11]),(Integer)ob[12]
			User user = new User((Integer)ob[0], (Integer)ob[1], userName, (String)(ob[3]), (String)(ob[4]), (String)(ob[5]), (String)(ob[6]), (String)(ob[7]), (String)(ob[8]), (String)(ob[9]), (String)(ob[10]), (String)(ob[11]), (Integer)(ob[12]), (Date)ob[13], (Integer)(ob[14]));
			return user;
		}else{
			return null;
		}
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
		boolean b = true;
		String hobby = "";
		//爱好不为空则将爱好组合成字符串
		if(null != hobbys && hobbys.length>0){
			for(String s : hobbys){
				hobby += s + ",";
			}
		}
		//去掉最后的逗号
		if(hobby.endsWith(",")) hobby = hobby.substring(0, hobby.length()-1);
		String sql = "select * from user where userName=?";
		List<Object[]> list = DBUtil.executeDQL(sql, new Object[]{userName});
		if(list.size()>0){
			b = false;
		}else{
			sql = "insert into user(userName,userPass,sex,diploma,Email,hobby,description) values(?,?,?,?,?,?,?)";
			DBUtil.executeDML(sql, new Object[]{userName,userPass,sex,diploma,Email,hobby,description});
		}
		return b;
	}
	
	/**
	 * 加载所有用户-->查询用户
	 * @return
	 */
	public List<User> loadAllUsers(){
		String sql = "select * from user";
		List<Object[]> list = DBUtil.executeDQL(sql, null);
		List<User> userList = new ArrayList<User>();
		User user = null;
		
		if(null != list&&list.size()>0){
			for(Object[] ob : list){
				user = new User((Integer)ob[0], (Integer)ob[1], (String)ob[2], (String)(ob[3]), (String)(ob[4]), (String)(ob[5]), (String)(ob[6]), (String)(ob[7]), (String)(ob[8]), (String)(ob[9]), (String)(ob[10]), (String)(ob[11]), (Integer)(ob[12]), (Date)ob[13], (Integer)(ob[14]));
				userList.add(user);
			}
		}
		return userList;
	}
	
	/**
	 * 通过id加载拥有的菜单集合-拥有的权限
	 * @param uid
	 * @return
	 */
	public List<Menu> loadMenusByUid(int uid){
		String sql = "select m.* from userrole ur,rolemenu rm,menu m where ur.rid=rm.rid and rm.mid=m.mid and m.isshow=1 and ur.uid=?";
		List<Object[]> list = DBUtil.executeDQL(sql, new Object[]{uid});
		List<Menu> menuList = new ArrayList<Menu>();
		Menu m = null;
		if(null != list&&list.size()>0){
			for(Object[] ob : list){
				m = new Menu((Integer)ob[0], String.valueOf(ob[1]), String.valueOf(ob[2]), (Integer)ob[3], (Integer)ob[4], (Integer)ob[5]);
				menuList.add(m);
			}
		}
		return menuList;
	}
	/**
	 * 查看用户详细信息
	 * @return
	 */
	public List<User> loadLookUser(String id){
		String sql = "select * from user where u_id=?";
		List<Object[]> list = DBUtil.executeDQL(sql, new Object[]{id});
		List<User> userList = new ArrayList<User>();
		Object[] ob = list.get(0);
		User user = new User((Integer)ob[0], (Integer)ob[1], (String)ob[2], (String)(ob[3]), (String)(ob[4]), (String)(ob[5]), (String)(ob[6]), (String)(ob[7]), (String)(ob[8]), (String)(ob[9]), (String)(ob[10]), (String)(ob[11]), (Integer)(ob[12]), (Date)ob[13], (Integer)(ob[14]));
		userList.add(user);
		return userList;
	}
	
	/**
	 * 删除用户
	 * @return
	 */
	public boolean loadRemoveUser(String id){
		String sql = "delete from u_ser where u_id=?";
		DBUtil.executeDML(sql, new Object[]{id});
		return true;
		
	}
	
	/**
	 * 加载所有班级-->查询班级
	 * @return
	 */
	public List loadAllClass(){
		
		String sql = "select * from class order by ctime desc";
		List<Object[]> list = DBUtil.executeDQL(sql, null);
		List classList = new ArrayList();
		for(Object[] ob : list){
			classList.add(ob);
		}
		return classList;
	}
	/**
	 * 加载所有学生-->查询学生
	 * @return
	 */
	public List loadAllStudent(){
		String sql = "select * from student order by sid desc";
		List<Object[]> list = DBUtil.executeDQL(sql, null);
		List classList = new ArrayList();
		for(Object[] ob : list){
			classList.add(ob);
		}
		return classList;
	}
	

	/**
	 * 添加班级
	 * @return
	 */
	public boolean loadAddClass(String className){
		//默认添加成功
		boolean b = true;
		String sql = "select * from class where className=?";
		List<Object[]> list = DBUtil.executeDQL(sql, new Object[]{className});
		if(list.size()>0){
			b = false;
		}else{
			//获取时间
			Date date=new Date();        
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			System.out.println(sdf.format(date));
			//插入数据
			sql = "insert into class(className,ctime) values(?,?)";
			DBUtil.executeDML(sql, new Object[]{className,sdf.format(date)});
		}
		return b;
	}
	
	/**
	 * 添加学生
	 * @return
	 */
	public boolean loadAddStudent(String snumber,String sname,String sex,String cid,
			String age,String Email,String description){
		//默认添加成功
		boolean b = true;
		String sql = "select * from student where snumber=?";
		List<Object[]> list = DBUtil.executeDQL(sql, new Object[]{snumber});
		
		if(list.size()>0){
			b = false;
		}else{
			//获取时间
			Date date=new Date();        
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			System.out.println(sdf.format(date));
			
			sql = "insert into student(snumber,sname,sex,cid,age,Email,description,ctime) values(?,?,?,?,?,?,?,?)";
			DBUtil.executeDML(sql, new Object[]{snumber,sname,sex,cid,age,Email,description,sdf.format(date)});
		}
		return b;
	}
	
	/**
	 * 展示菜单
	 * @param uid
	 * @return
	 */
	public List<MenuVo> loadAllMenuVO(){
		String sql = "select m.mid,m.name,m.url,m.isshow,m.level,(select m2.name from menu m2 where m.parentid=m2.mid) from menu m";
		List<Object[]> list = DBUtil.executeDQL(sql, null);
		List<MenuVo> menuVoList = new ArrayList<MenuVo>();
		MenuVo m = null;
		if(null != list&&list.size()>0){
			for(Object[] ob : list){
				m = new MenuVo((Integer)ob[0], String.valueOf(ob[1]), String.valueOf(ob[2]), (Integer)ob[3], (Integer)ob[4], (String)ob[5]);
				menuVoList.add(m);
			}
		}
		return menuVoList;
	}
	/**
	 * 查询数据，跳转到添加菜单的界面
	 * @param uid
	 * @return
	 */
	public List<Menu> load12Menus(){
		String sql = "select m.* from menu m where m.level in (1,2)";
		List<Object[]> list = DBUtil.executeDQL(sql, null);
		List<Menu> menuList = new ArrayList<Menu>();
		Menu m = null;
		if(null != list&&list.size()>0){
			for(Object[] ob : list){
				m = new Menu((Integer)ob[0], String.valueOf(ob[1]), String.valueOf(ob[2]), (Integer)ob[3], (Integer)ob[4], (Integer)ob[5]);
				menuList.add(m);
			}
		}
		return menuList;
	}
	
	/**
	 * 添加菜单
	 * @param name
	 * @param url
	 * @param isshow
	 * @param level
	 * @param parentid
	 */
	public void addMenu(String name,String url,int isshow,int parentid){
		String sql = "select m.level from menu m where m.mid=?";
		List<Object[]> list = DBUtil.executeDQL(sql, new Object[]{parentid});
		Object[] o = list.get(0);
		int level = (Integer)o[0]+1;
		sql = "insert into menu(name,url,isshow,level,parentid) values(?,?,?,?,?)";
		DBUtil.executeDML(sql, new Object[]{name,url,isshow,level,parentid});
	}
	
	/**
	 * 加载角色
	 * @return
	 */
	public List<Role> showRoles(int uid ){
		String sql = "select * from role order by rid";
		List<Object[]>  list = DBUtil.executeDQL(sql, null);
		List<Role> roleList = new ArrayList<Role>();
		Role r = null;
		if(null != list&&list.size()>0){
			for(Object[] ob : list){
				r = new Role((Integer)ob[0], (String)ob[1]);
				roleList.add(r);
			}
		}
		return roleList;
	}
	
	/**
	 * 通过id加载角色对象
	 * @param uid
	 * @return
	 */
	public Role loadRoleById(int rid){
		String sql = "select * from role where rid=? ";
		List<Object[]>  list = DBUtil.executeDQL(sql, new Object[]{rid});
		Role r = null;
		if(null != list&&list.size()>0){
			Object[] ob = list.get(0);
			r = new Role((Integer)ob[0], String.valueOf(ob[1]));
		}
		return r;
	}
	
	/**
	 * 查询所菜单和当前用户已经拥有的菜单-展示角色权限
	 * @return 
	 */
	public List<Object[]> showRolePermission(int rid){
		String sql = "select m.mid,m.mname,m.parentid,(select 1 from rolemenu rm where rm.mid=m.mid and rm.rid=?) from menu m";
		return DBUtil.executeDQL(sql, new Object[]{rid});
	}
	
	
	/**
	 * 确认修改权限
	 * @param uid
	 * @param s
	 */
	public void affirmalterPermission(int rid,String[] s){
		//删除之前已有的菜单列表关联
		String sql = "delete from rolemenu where rid=?";
		DBUtil.executeDML(sql, new Object[]{rid});
		//重新添加新的菜单列表关联
		sql = "insert into rolemenu(rid,mid) values(?,?)";
		for(String ss:s){
			DBUtil.executeDML(sql, new Object[]{rid,ss});
		}
	}
	
	/**
	 * 加载角色用户
	 * @param uid
	 * @return
	 */
	public List<Object[]> showRoleUser(int uid){
		String sql = "select u.uid,u.userName,(select 1 from userrole ur where ur.uid=u.uid and ur.rid=?) from tb_user u";
		return DBUtil.executeDQL(sql, new Object[]{uid});
	}
	
	
	/**
	 * 确认修改用户
	 * @param uid
	 * @param s
	 */
	public void affirmalterUser(int uid,String[] s){
		//删除之前已有的菜单列表关联
		String sql = "delete from userrole where urid=?";
		DBUtil.executeDML(sql, new Object[]{uid});
		//重新添加新的菜单列表关联
		System.out.println(uid+"<====");
		sql = "insert into userrole(rid,uid) values(?,?)";
		for(String ss:s){
			System.out.println("====="+ss);
			DBUtil.executeDML(sql, new Object[]{uid,ss});
		}
	}
	
	/**
	 * 检查当前这个用户是否拥有uri这个菜单权限
	 * @param uid
	 * @param uri
	 * @return 返回true表示有权限 返回false表示无权限
	 */
	public boolean checkUserMenu(int uid, String uri){
		String sql = "select 1 from userrole ur,rolemenu rm,menu m where ur.rid=rm.rid and rm.mid=m.mid and ur.uid=? and m.url like '%" + uri + "%'";
		List<Object[]> list = DBUtil.executeDQL(sql, new Object[]{uid});
		if(null != list && list.size() > 0){
			return true;
		}
		return false;
	}
	
	
}
