package stuff;

import java.io.IOException;
import java.io.PrintWriter;

import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

public class SessionViewerPortlet extends GenericPortlet {

   protected void doView(RenderRequest request, RenderResponse response)
         throws PortletException, IOException {

      response.setContentType("text/html");

      PrintWriter out = response.getWriter();
      PortletSession session = request.getPortletSession();
      Object count = session.getAttribute("timesvisited", PortletSession.APPLICATION_SCOPE);

      if (count != null) {
         out.print("I found the count in the session: ");
         out.print(count.toString());
      } else {
         out.print("Couldn't find the count in the session.");
      }
   }
}
