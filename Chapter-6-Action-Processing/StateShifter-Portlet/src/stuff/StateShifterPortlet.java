package stuff;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.WindowState;

public class StateShifterPortlet extends GenericPortlet {

   @Override
   protected void doView(RenderRequest renderRequest, RenderResponse renderResponse)
         throws PortletException, IOException {

      renderResponse.setContentType("text/html");

      PortletURL portletURL = renderResponse.createActionURL();
      portletURL.setParameter("shift",  "true");

      PrintWriter printWriter = renderResponse.getWriter();
      printWriter.print("<a href='" + portletURL + "'>State Shift!!!</a>");
   }

   @Override
   public void processAction(ActionRequest actionRequest, ActionResponse actionResponse)
      throws PortletException, IOException {

      if (actionRequest.getParameter("shift") != null) {
         WindowState state = actionRequest.getWindowState();

         if (state.equals(WindowState.NORMAL)) {
            actionResponse.setWindowState(WindowState.MAXIMIZED);
         }

         if (state.equals(WindowState.MAXIMIZED)) {
            actionResponse.setWindowState(WindowState.MINIMIZED);
         }

         if (state.equals(WindowState.MINIMIZED)) {
            actionResponse.setWindowState(WindowState.NORMAL);
         }
      }
   }
}
