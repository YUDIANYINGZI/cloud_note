package cn.whbing.note.dao.test;

import cn.whbing.note.dao.UserDao;
import cn.whbing.note.entity.User;

public class TestUserDao extends TestBase{
	//����findbyname
	public static void main(String[] args) {
		UserDao userDao=getContext().getBean("userDao",UserDao.class);
		User user = userDao.findByName("whb");
		if(user == null){
			System.out.println("�û�������ȷ");
		}else{
			System.out.println(
				user.getCn_user_password());
		}
	}

}
