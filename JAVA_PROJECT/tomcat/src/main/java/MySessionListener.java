import javax.servlet.*;

public final class MySessionListener
implements HttpSessionListener {
    public MySessionListener(){

    }
    public void sessionCreated(HttpSessionEvent sessionEvent){
        HttpSession session = sessionEvent.getSession();

        
        try {
            System.out.println("[MySessionListener] Session created: "+session);
            session.setAttribute("foo","bar");
        } catch (Exception e){
            System.out.println("[MySessionListener] Error setting session attribute:" + e.getMessage());
        }
    }
    public void sessionDestroyed(HttpSessionEvent sessionEvent){
        HttpSession session = sessionEvent.getSession();
        System.out.println("[MySessionListener] Session invaildated:" +session);
        System.out.println("[MySessionListener] Value of foo is:" +session.getAttribute("foo"));
    }
}
