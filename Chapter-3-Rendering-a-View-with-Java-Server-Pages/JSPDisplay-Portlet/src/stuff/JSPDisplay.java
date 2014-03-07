package stuff;

import java.io.IOException;

import javax.portlet.GenericPortlet;
import javax.portlet.PortletContext;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

public class JSPDisplay extends GenericPortlet {
   protected void doView(RenderRequest request, RenderResponse response) throws PortletException, IOException {
      String url = "/welcome.jsp";

      PortletContext portletContext = getPortletContext();
      PortletRequestDispatcher portletRequestDispatcher = portletContext.getRequestDispatcher(url);
      portletRequestDispatcher.include(request,  response);
   }
}
