package stuff;

import java.io.IOException;

import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

public class HelloWorldPortlet extends GenericPortlet {
   protected void doView(RenderRequest request, RenderResponse response) throws PortletException, IOException {
      response.setContentType("text/html");
      response.getWriter().println("Hello Portlet");
   }
}
