package cn.whbing.note.controller.user;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.whbing.note.entity.NoteResult;
import cn.whbing.note.service.UserService;

@Controller//ɨ��������
@RequestMapping("/user")
public class LoginController {
	
	@Resource//ע��
	private UserService userService;
	
	@RequestMapping("/login.do")  
	@ResponseBody  //������ֵNoteResultת��json���
	public NoteResult execute(String name,String pwd) throws Exception{
		NoteResult result = userService.checkLogin(name, pwd);
		return result;
	}
	
}