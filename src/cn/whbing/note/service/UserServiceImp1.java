package cn.whbing.note.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.ErrorMessages_sk;

import cn.whbing.note.dao.UserDao;
import cn.whbing.note.entity.NoteResult;
import cn.whbing.note.entity.User;
import cn.whbing.note.util.NoteUtil;

@Service
public class UserServiceImp1 implements UserService{

	/*private UserDao UserDao = new UserDao();
	 * ��������д�ǲ��еģ�UserDaoֻ��һ���ӿڡ�
	 * �������ǲ��� ע�뷽ʽ*/
	
	@Resource
	private UserDao userDao;  //��ע��ķ�ʽ����һ��dao
	
	@Override
	public NoteResult checkLogin(String name, String pwd) throws Exception {
//		�����û��������룬��ѯ���ݿ����У�飬���ز�ͬ��״̬�������NoteResult�洢
		NoteResult result = new NoteResult();
//		���ﻹ��Ҫdao����ѯ���ݿ⡣Ϊ��ʹdao������������Ҳ����ʹ�ã����䶨�������
		User user=userDao.findByName(name);
		if(user==null){
			result.setStatus(1);
			result.setMsg("�û���������");
			return result;			
		}
		String md5_pwd=NoteUtil.md5(pwd);
		if(!user.getCn_user_password().equals(md5_pwd)){
			result.setStatus(2);
			result.setMsg("�������");
			return result;
		}
		result.setStatus(0);
		result.setMsg("�û���������ȷ");
		result.setData(user.getCn_user_id());
		return result;		
	}

	@Override
	public NoteResult regist(String name, String password, String nickname) throws Exception {
		
		NoteResult result=new NoteResult();
		User has_user = userDao.findByName(name);
		
		if(has_user!=null){
			result.setStatus(1);
			result.setMsg("�û����Ѿ�����");
			return result;
		}
		//ע��
		User user=new User();
		user.setCn_user_id(NoteUtil.createId());
		user.setCn_user_name(name);
		user.setCn_user_password(NoteUtil.md5(password));
		user.setCn_user_desc(nickname);
		
		userDao.save(user);		

		result.setStatus(0);
		result.setMsg("ע��ɹ�");
		return result;
	}
}
