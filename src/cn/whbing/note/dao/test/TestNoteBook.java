package cn.whbing.note.dao.test;

import java.util.List;

import cn.whbing.note.dao.NoteBookDao;
import cn.whbing.note.dao.UserDao;
import cn.whbing.note.entity.NoteBook;
import cn.whbing.note.entity.User;

public class TestNoteBook extends TestBase{

	public static void main(String[] args) {
		//����findByUser
		//��ͨ���������һ��User���õ���id
		UserDao userDao=getContext().getBean("userDao",UserDao.class);
		User user = userDao.findByName("lisi");
		String user_id=null;
		if(user == null){
			System.out.println("�޴��û���");
		}else{
			user_id=user.getCn_user_id();
			System.out.println(user.getCn_user_name()+"��id:"+user_id);
		}
		
		NoteBookDao noteBookDao =getContext().getBean("noteBookDao",NoteBookDao.class);
		List<NoteBook> books =noteBookDao.findByUser(user_id);
	}

}
