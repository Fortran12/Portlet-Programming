package stuff;

import java.io.IOException;
import java.io.PrintWriter;

import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

public class SimpleSessionPortlet extends GenericPortlet {

   protected void doView(RenderRequest renderRequest, RenderResponse renderResponse)
         throws PortletException, IOException {

      renderResponse.setContentType("text/html");

      PrintWriter printWriter = renderResponse.getWriter();

      // grab the PortletSession out of the PortletRequest
      PortletSession session = renderRequest.getPortletSession();

      // pull the visitCount out of the session.
      // On the first visit, this will be null.
      String visitCount = (String) session.getAttribute("timesvisited");

      if (visitCount == null) {
         // If this is the first time viewing the portlet,
         // set the timevisited value to 1
         session.setAttribute("timesvisited", "1");

         printWriter.print("Welcome to our little portlet!");
         printWriter.print("Click refresh, minimize or maximize");
      } else {
         // If this portlet has been visited before, increase the count.
         int newCount = Integer.parseInt(visitCount) + 1;
         session.setAttribute("timesvisited", "" + newCount);

         printWriter.print("Number of times visiting this portlet: ");
         printWriter.print(newCount);
      }
   }
}
