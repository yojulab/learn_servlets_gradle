<% int day=3; %>
    <html>

    <head>
        <title>IF...ELSE Example</title>
    </head>

    <body>
        <div>
            day value : <%= day %>
        </div>
        <% if (day==1 || day==7) { %>
            <p> Today is weekend</p>
        <% } else { %>
            <p> Today is not weekend</p>
        <% } %>
    </body>

    </html>