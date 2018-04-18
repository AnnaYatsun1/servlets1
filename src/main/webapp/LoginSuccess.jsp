<%@ page import="java.io.PrintWriter" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Captcha</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<center>
    <form action="captchaTest.jsp" method="post">
        <center>
            <%
                PrintWriter out1 = response.getWriter();
                out1.print(session.getAttribute("publicKey"));
            %>
        </center>

        <tr>
            <td>Inpubt Public Key</td>
            <td><input type="text" name="PublicKey"></td>
            <td><input type="submit" value="submit"></td>
        </tr>
        </table>
    </form>
</center>
</form>

</body>
</html>