<%-- 
    Document   : users
    Created on : 19-Apr-2022, 3:47:08 PM
    Author     : honeylene
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!--<link rel="stylesheet" href="usercss.css">-->
        <title>User Manager</title>
    </head>
    <body>
        <div class="showAll">
            <form method="post" action="user">
            <table>
                    <tr>
                        <th>Email</th>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Role</th>
                        <th>Edit</th>
                        <th>Delete</th>
                            
                    </tr>
                    <c:forEach items ="${users}" var="user">
                        <tr>
                        <th>${user.email}</th>
                        <th>${user.firstName}</th>
                        <th>${user.lastName}</th>
                        <c:forEach items ="${roles}" var="role">
                            <c:if test="${user.role.roleId == role.roleId}">
                                <th>${role.roleName}</th>
                            </c:if>
                        </c:forEach>
                        <th><a href="user?action=Edit&editEmail=${user.email}&editFirstName=${user.firstName}&editLastName=${user.lastName}">Edit</a></th>
                        <th><a href="user?action=Delete&deleteEmail=${user.email}">Delete</a></th>
                        </tr>
                    </c:forEach>
                </table>
            </form>
        </div>
        <div class="addUser">
            <form method="post" action="user" class="adduserform">
                <input type="email" name="email" id="email" placeholder="Email Address" required autofocus>
                <br>
                <input type="text" name="firstname" id="fname" placeholder="First Name" title="Please enter first name" required>
                <br>
                <input type="text" name="lastname" id="lname" placeholder="Last Name" title="Please enter last name" required>
                <br>
                <input type="password" name="password" id="password">
                <br>
                
                <select name="roleOption">
                    <c:forEach items ="${roles}" var="role">
                        <option value="${role.roleName}">${role.roleName}</option>
                    </c:forEach>
                </select>
                <input type="submit" name="action" value="Add">
            </form>
        </div>
        <div class="edit">
            <form method="post" action="user">
                <input type="email" name="Editedemail" value="${editEmail}">
                <br>
                <input type="text" name="Editedfirstname" value="${editFirstName}">
                <br>
                <input type="text" name="Editedlastname" value="${editLastName}">
                <br>
                <select name="Editedrole">
                    <c:forEach items ="${roles}" var="role">
                        <option value="${role.roleName}">${role.roleName}</option>
                    </c:forEach>
                </select>
                <input type="submit" name="action" value="Edit">
            </form>
        </div>

    </body>
</html>