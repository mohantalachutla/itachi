<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1">
        <title>SignUp</title>
    </head>
    <body>
        <form action="SignUp" method="Post">
            <div>
                <label for="firstName">First Name</label>
                <input id="firstname" name="firstname" type="text"/>
            </div>
            <div>
                <label for="lastname">Last Name</label>
                <input id="lastname" name="lastname" type="text"/>
            </div>
            <div>
                <label for="password">Password</label>
                <input id="password" name="password" type="password"/>
            </div>
            <div>
                <label for="cfmpassword">Password</label>
                <input id="cfmpassword" name="cfmpassword" type="password"/>
            </div>
            <div>
                <label for="age">Age</label>
                <input id="age" name="age" type="number"/>
            </div>
            <div>
                <label for="sex">Sex</label>
                <input id="sex" name="sex" type="text"/>
            </div>
            <div>
                <label for="dob">Date of Birth</label>
                <input id="dob" name="dob" type="text"/>
            </div>
            <div>
                <label for="email">E-mail</label>
                <input id="email" name="email" type="text"/>
            </div>
            <div>
                <button id="signup" name="signup" type="submit">SignUp </button>
            </div>
            <br><br>
            <a href="LogIn">Already have an account?</a>
        </form>
    </body>
</html>