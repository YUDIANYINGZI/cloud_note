package cn.whbing.note.service;

import java.sql.Timestamp;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.whbing.note.dao.NoteBookDao;
import cn.whbing.note.entity.NoteBook;
import cn.whbing.note.entity.NoteResult;
import cn.whbing.note.util.NoteUtil;

@Service
public class NoteBookServiceImp1 implements NoteBookService{

	@Resource
	private NoteBookDao noteBookDao;
	
	@Override
	public NoteResult loadNoteBooks(String userId) {
		List<NoteBook> list=noteBookDao.findByUser(userId);
		NoteResult result=new NoteResult();
		result.setStatus(0);
		result.setMsg("��ѯ�ʼǱ��ɹ�");
		result.setData(list);
		
		return result;
	}

	@Override
	public NoteResult addNoteBook(String noteBookName,String userId) {
		//�û������noteBookName��userId�������½��ıʼǱ�
		//�½��ʼǱ�
		NoteBook noteBook=new NoteBook();
		noteBook.setCn_notebook_name(noteBookName);
		noteBook.setCn_user_id(userId);
		noteBook.setCn_notebook_type_id("1");//Ĭ������
		noteBook.setCn_notebook_id(NoteUtil.createId());
		//desc�ֶ���Ϊ��
		//����ʱ��ΪTimestamp����
		Timestamp nowTime=new Timestamp(System.currentTimeMillis());
		noteBook.setCn_notebook_createtime(nowTime);
		noteBookDao.save(noteBook);;
		NoteResult result=new NoteResult();
		result.setStatus(0);
		result.setMsg("��ӱʼǱ��ɹ�");		
		result.setData(noteBook.getCn_notebook_id());//����noteId��Ϊ�˺��湤��
		return result;
	}

}
