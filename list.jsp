
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Sondages</title>
    <link rel="stylesheet" href="css/style.css"/>
</head>
<body>
<h1>Application de Sondage</h1>

<% String msg = (String) session.getAttribute("msg");
   if (msg != null) { %>
    <p class="msg"><%= msg %></p>
<% session.removeAttribute("msg"); } %>

<form method="post">
    <input type="text" name="question" placeholder="Question" required/>
    <input type="text" name="options" placeholder="Option 1" required/>
    <input type="text" name="options" placeholder="Option 2" required/>
    <input type="text" name="options" placeholder="Option 3"/>
    <button>Créer</button>
</form>

<hr/>

<%
java.util.List polls = (java.util.List) request.getAttribute("polls");
for (Object o : polls) {
    com.example.polls.model.Poll p = (com.example.polls.model.Poll) o;
%>
<div class="poll">
    <h3><%= p.getQuestion() %></h3>
    <form action="vote" method="post">
        <input type="hidden" name="pollId" value="<%= p.getId() %>"/>
        <% for (int i = 0; i < p.getOptions().size(); i++) { %>
            <button name="option" value="<%= i %>">
                <%= p.getOptions().get(i).getText() %>
                (<%= p.getOptions().get(i).getVotes() %>)
            </button>
        <% } %>
    </form>
    <a href="delete?id=<%= p.getId() %>">Supprimer</a>
</div>
<% } %>

</body>
</html>
