package Listener;

import org.apache.catalina.SessionEvent;
import org.apache.catalina.SessionListener;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

//@WebListener
public class MyListener implements HttpSessionListener,HttpSessionAttributeListener,ServletRequestListener,ServletRequestAttributeListener,SessionListener {
    @Override
    public void attributeAdded(HttpSessionBindingEvent se) {

    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent se) {

    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent se) {

    }

    @Override
    public void attributeAdded(ServletRequestAttributeEvent srae) {
        System.out.println("添加了一个attribute:"+srae.getName()+":"+srae.getValue());
    }

    @Override
    public void attributeRemoved(ServletRequestAttributeEvent srae) {

    }

    @Override
    public void attributeReplaced(ServletRequestAttributeEvent srae) {

    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        System.out.println("我被销毁了3213");
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        System.out.println("我被创建了321312");
    }

    @Override
    public void sessionEvent(SessionEvent sessionEvent) {

    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {

    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {

    }
}
