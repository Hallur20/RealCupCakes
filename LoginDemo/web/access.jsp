<%-- 
    Document   : access
    Created on : Mar 2, 2017, 7:35:48 PM
    Author     : Hallur
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="newcss.css">
        <title>JSP Page</title>
    </head>
    <body><center><img class="cupcakeImage" src="CupcakeImage.jpg"></img></center><center><h1>You're logged in as: <%= session.getAttribute("email")%> balance: <%= session.getAttribute("uBalance") + "$"%> <a href="login.jsp">Log Out</a></h1>
        <p><%= session.getAttribute("order")%></p>
        <p style="color: red;">note: if you already made an order, you cannot make another (if you try to, order will remain the same.)</p></center>
        <%
            ArrayList<String> bName = (ArrayList<String>) request.getAttribute("bName");
            ArrayList<Integer> bPrice = (ArrayList<Integer>) request.getAttribute("bPrice");
            ArrayList<String> tName = (ArrayList<String>) request.getAttribute("tName");
            ArrayList<Integer> tPrice = (ArrayList<Integer>) request.getAttribute("tPrice");

            int amount1 = 0;
            int totalAmount1 = 0;
            int price1 = 0;
            int sum1 = 0;
            int amount = 0;
            int totalAmount = 0;
            int price = 0;
            int sum = 0;
            String allOrder = "Bottoms:";
            %><center><form class="BTselection" action="DataServlet"><%
            %> <h1>BOTTOMS</h1><%
            for (int i = 0; i < bName.size() && i < bPrice.size(); i++) {
            %> <label ><%= bName.get(i)%></label><input class="inputB" type="text" name="bottoms<%=+i%>"></input> <%
                }%><br><br><h1>TOPPINGS</h1><% for (int i = 0; i < tName.size() && i < tPrice.size(); i++) {
            %> <label ><%= tName.get(i)%></label><input class="inputT "type="text" name="toppings<%=+i%>"></input> <%
                }
            %> <br><br><input type="submit" value="Add To Cart"</input>
            
                </form></center><center><h1>Bottoms</h1> <%
            for (int i = 0; i < bName.size(); i++) {

                try {
                    amount1 = Integer.parseInt(request.getParameter("bottoms" + i));
                    totalAmount1 += Integer.parseInt(request.getParameter("bottoms" + i));
                    price1 = bPrice.get(i);
                    sum1 += amount1 * price1;
                    out.println("<h1 style=\"color:red;\">" + bName.get(i) + " x " + request.getParameter("bottoms" + i) + " - " + bPrice.get(i) + "$</h1>");
                    try {
                        int a = Integer.parseInt(request.getParameter("bottoms" + i));
                        allOrder += "[" + bName.get(i) + " x " + request.getParameter("bottoms" + i) + " for " + (a * bPrice.get(i) + "$]");
                    } catch (Exception ex) {

                    }
                } catch (Exception ex) {

                }
            }
        %> <h1>Toppings</h1> <% allOrder += "<br> Toppings:"; %>
        <% for (int i = 0; i < tName.size(); i++) {

                try {
                    amount = Integer.parseInt(request.getParameter("toppings" + i));
                    totalAmount += Integer.parseInt(request.getParameter("toppings" + i));
                    price = tPrice.get(i);
                    sum += amount * price;
                    out.println("<h1 style=\"color:blue;\">" + tName.get(i) + " x " + request.getParameter("toppings" + i) + " - " + tPrice.get(i) + "$</h1>");
                    try {
                        int b = Integer.parseInt(request.getParameter("toppings" + i));
                        allOrder += "[" + tName.get(i) + " x " + request.getParameter("toppings" + i) + " for " + (b * tPrice.get(i) + "$]");
                    } catch (Exception ex) {

                    }
                } catch (Exception ex) {

                }
            }
            request.setAttribute("totalSum", (sum1 + sum));
            %>
        <%
            if (totalAmount1 != totalAmount || ((sum1 + sum) == 0)) {
                out.println("<h1 style=\"color:yellow\">This message will show up if: you haven't made your choice yet, or if you haven't ordered as many bottoms as toppings (Example: 2 chocolate bottoms and 2 strawberry toppings).</h1>");
            } else {%>
        <h1><%= "Total Price:" + (sum1 + sum) + "$"%></h1><button onclick="myFunction()">Make A Purchase</button> <%}%></center>

        <script>
            function myFunction() {
                var balance = <%= session.getAttribute("uBalance")%>;
                var order = "<%= allOrder%>";
                var sum = <%= sum%>;
                var sum1 = <%= sum1%>;
                var user = "<%= session.getAttribute("email")%>";
                if (balance >= (sum + sum1)) {
                    document.write("<head></head><body><div style=\"width:500px;position:absolute;margin: -100px 0 0 -200px;top:50%;left:50%;border:dotted;\"><Center>\n\
                                    Customer Email:" + user + "<br>" + order + "<br><hr>Total Price is:" + (sum + sum1) + "$ <br><a href=\"javascript:history.back()\">Cancel</a>\n\
<form action = \"PayServlet\">\n\
<input type = \"hidden\" name=\"bottomSum\" value=\"" + sum1 + "\">\n\
<input type = \"hidden\" name=\"toppingsSum\" value=\"" + sum + "\">\n\
<input type = \"hidden\" name=\"emailSend\" value=\"" + user + "\">\n\
<input type = \"hidden\" name=\"balanceSend\" value=\"" + balance + "\">\n\
<input type = \"submit\" value=\"Pay Now\"\
</form></Center></div></body>");
                } else {
                    alert("Cost: " + (sum1 + sum) + "$ - Your balance: " + balance + "$ ...you can't afford this!");
                }
            }
        </script>
    </body>
</html>
