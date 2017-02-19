package com.wtlib.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;


public class UserIdListener extends HttpSessionBindingEvent implements HttpSessionListener {

    /**
     * @see HttpSessionBindingEvent#HttpSessionBindingEvent(HttpSession, String)
     */
    public UserIdListener(HttpSession session, String name) {
        super(session, name);
        // TODO Auto-generated constructor stub
    }
       
    /**
     * @see HttpSessionBindingEvent#HttpSessionBindingEvent(HttpSession, String, Object)
     */
    public UserIdListener(HttpSession session, String name, Object value) {
        super(session, name, value);
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent se)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent se)  { 
         // TODO Auto-generated method stub
    }
	
}
