package stuff;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

public class NumberGuesserPortlet extends GenericPortlet {

   @Override
   public void processAction(ActionRequest actionRequest, ActionResponse actionResponse)
         throws PortletException, IOException {
      String parameterName = actionResponse.getNamespace() + "number";
      String parameterValue = actionRequest.getParameter(parameterName);

      actionResponse.setRenderParameter(parameterName, parameterValue);
   }

   @Override
   protected void doView(RenderRequest request, RenderResponse response)
         throws PortletException, IOException {
      // see if a number is passed to the server as a parameter
      String number = request.getParameter(response.getNamespace() + "number");

      // if no number was entered, just show the form
      if (number == null) {
         String url = "/numberguesser.jsp";
         getPortletContext().getRequestDispatcher(url).include(request, response);
      }
      else {
         // if a number was entered, display the correct answer
         response.setContentType("text/html");

         PrintWriter printWriter = response.getWriter();

         printWriter.println("You guessed " + number + "<br />");
         printWriter.println("The number was 5. <br />");

         // create a link back to the portlet using a PortletURL
         printWriter.println("<a href = \"" + response.createRenderURL() + "\">Try Again</a>");
      }
   }
}
