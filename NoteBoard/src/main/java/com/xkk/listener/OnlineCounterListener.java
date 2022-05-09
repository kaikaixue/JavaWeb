package com.xkk.listener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class OnlineCounterListener implements HttpSessionListener 
{ 
	public void sessionCreated(HttpSessionEvent hse) 
	{ 
		OnlineCounter.raise(); 
		System.out.println("raise"+OnlineCounter.getOnline());
	} 
	public void sessionDestroyed(HttpSessionEvent hse) 
	{ 
		 OnlineCounter.reduce(); 
		 System.out.println("reduce"+OnlineCounter.getOnline());
	} 
} 
/*
   <listener> 
     <listener-class>mylistener.OnlineCounterListener</listener-class> 
    </listener>
 */

