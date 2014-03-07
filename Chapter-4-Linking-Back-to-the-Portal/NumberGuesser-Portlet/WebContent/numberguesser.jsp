<%@ page contentType = "text/html" %>
<%@ taglib uri = "http://java.sun.com/portlet_2_0" prefix = "portlet" %>
<portlet:defineObjects />
<p>I'm thinking of a number between 1 and 10. What is it?</p>
<form action = "<%= renderResponse.createActionURL()%>" method = "post">

	<%-- <input type = "text" name = "number" size = "10" /> --%>

	<%-- ensure form data doesn't get confused with form data of another portlet --%>
	<input type = "text" name = "<%= renderResponse.getNamespace() %>number" size = "10" />

	<%-- The following is an alternative way of doing the above. --%>
	<%-- <input type = "text" name = "<portlet:namespace />number" size = "10" /> --%>

	<input type = "submit" value = "Guess!!"  />
</form>
