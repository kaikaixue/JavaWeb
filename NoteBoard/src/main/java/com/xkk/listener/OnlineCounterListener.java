package com.xkk.listener;
import com.xkk.bean.DO.UserDO;
import com.xkk.bean.entity.User;
import com.xkk.mapper.UserMapper;
import com.xkk.util.MySessionUtils;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.HashMap;

@WebListener
public class OnlineCounterListener implements HttpSessionListener ,HttpSessionAttributeListener
{
	public static HashMap<Integer, String> LOGIN_USER = new HashMap<Integer, String>();
	SqlSession sqlSession = MySessionUtils.getSession();
	UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

	@Override
	public void attributeAdded(HttpSessionBindingEvent event) {

		UserDO userDO = userMapper.getInfo((Integer) event.getValue());
		LOGIN_USER.put(userDO.getId(), userDO.getName());
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent event) {
		UserDO userDO = userMapper.getInfo((Integer) event.getValue());
		LOGIN_USER.remove(userDO.getId());
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent event) {
		HttpSessionAttributeListener.super.attributeReplaced(event);
	}

//	public void sessionCreated(HttpSessionEvent hse)
//	{
//		OnlineCounter.raise();
//		System.out.println("raise"+OnlineCounter.getOnline());
//	}
//	public void sessionDestroyed(HttpSessionEvent hse)
//	{
//		 OnlineCounter.reduce();
//		 System.out.println("reduce"+OnlineCounter.getOnline());
//	}
} 
/*
   <listener> 
     <listener-class>mylistener.OnlineCounterListener</listener-class> 
    </listener>
 */

