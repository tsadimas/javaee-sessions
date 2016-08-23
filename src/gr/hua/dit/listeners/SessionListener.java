package gr.hua.dit.listeners;

import java.util.Date;
import java.text.SimpleDateFormat;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionIdListener;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class SessionListener implements HttpSessionListener, HttpSessionIdListener {
	private SimpleDateFormat formatter = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss");

	private String date() {
		return this.formatter.format(new Date());
	}

	@Override
	public void sessionCreated(HttpSessionEvent e) {
		System.out.println(this.date() + ": Session " + e.getSession().getId() + " created.");

	}

	@Override
	public void sessionDestroyed(HttpSessionEvent e) {
		System.out.println(this.date() + ": Session " + e.getSession().getId() + " destroyed.");

	}

	@Override
	public void sessionIdChanged(HttpSessionEvent e, String oldSessionId) {
		System.out.println(this.date() + ": Session ID " + oldSessionId + " changed to " + e.getSession().getId());

	}

}
