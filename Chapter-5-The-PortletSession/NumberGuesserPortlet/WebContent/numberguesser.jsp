<%@ page contentType = "text/html" %>
<%@ taglib uri = "http://java.sun.com/portlet_2_0" prefix = "portlet" %>
<portlet:defineObjects />
<%= renderRequest.getPortletSession().getAttribute("message") %>
<p>I'm thinking of a number between 1 and 10. What is it?</p>
<form action = "<%= renderResponse.createActionURL()%>" method = "post">
	<input type = "text" name = "number" size = "10" />
	<input type = "submit" value = "Guess!!"  />
</form>

Number of guesses: <%= renderRequest.getPortletSession().getAttribute("guesses") %>
