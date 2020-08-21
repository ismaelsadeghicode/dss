<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Main</title>
</head>
<style>
    .btn{
        padding:5px 20px;
        border: 1px solid black;
        margin:5px;
        color: white;
        background-color: #000;
        transition: .3s ease-in-out;
    }
    .btn:hover{
        color:black;
        background-color: white;
    }
    a{
        text-decoration: none;
    }
</style>
<body>
<div>
    <h1>Welcome To admin panel! </h1>
    <p1>Choose your Function</p1>
</div>

<form action="/sales">
    <span class="btn">
        <button type="submit">Let's go to sales!</button>
    </span>
</form>
<form method="post" action="/showallusers">
    <span class="btn">
        <button type="submit">Show me all users</button>
    </span>
</form>
<form method="post" action="/cashincrease">
        <h1>Cash increase functionality</h1>
        <h2>Please enter required information</h2>
        <label for="inputEmail"  class="sr-only">Email address</label>
        <input type="email" name="email" id="inputEmail" placeholder="Email address" required autofocus>
        <label for="inputAmount">Amount</label>
        <input type="amount" name="amount" id="inputAmount" placeholder="amount" required>
        <span class="btn">
            <button type="submit">Submit</button>
        </span>
</form>
<form method="post" action="/addOneUser">
        <h1>Adding user functionality</h1>
        <h2>Please enter required information</h2>
        <label for="inputEmail"  class="sr-only">Email address</label>
        <input type="email" name="email"  placeholder="Email address" required autofocus>
        <label for="inputPassword">Password</label>
        <input type="password" name="password" id="inputPassword" placeholder="password" required>
        <span class="btn">
             <button type="submit">Submit</button>
        </span>
</form>
<form method="post" action="/showOneUser">
    <h1>Showing custom user functionality</h1>
    <h2>Please enter required information</h2>
    <label for="inputEmail"  class="sr-only">Email address</label>
    <input type="email" name="email"  placeholder="Email address" required autofocus>
    <span class="btn">
             <button type="submit">Submit</button>
        </span>
</form>
<form method="post" action="/editOneUser">
    <h1>editing user functionality</h1>
    <h2>Please enter required information</h2>
    <label for="inputID"  class="sr-only">ID</label>
    <input type="number" name="id" id="inputID" placeholder="ID" required autofocus>
    <label for="inputEmail"  class="sr-only">Email address</label>
    <input type="email" name="email"  placeholder="Email address" required autofocus>
    <label for="inputPassword">Password</label>
    <input type="password" name="password"  placeholder="password" required>
    <label for="inputUsername"  class="sr-only">Username</label>
    <input type="text" name="username" id="inputUsername" placeholder="Username" required autofocus>
    <label for="inputPhoneNumber"  class="sr-only">Phone Number</label>
    <input type="number" name="phone_number" id="inputPhoneNumber" placeholder="Phone Number" required autofocus>
    <label for="inputCash"  class="sr-only">Wallet cash</label>
    <input type="number" name="wallet" id="inputCash" placeholder="Wallet cash" required autofocus>
    <label for="inputIsMale"  class="sr-only">Is Male</label>
    <input type="checkbox" name="isMale" id="inputIsMale" placeholder="Is Male" required autofocus>
    <label for="inputIsFemale"  class="sr-only">Is Female</label>
    <input type="checkbox" name="isFemale" id="inputIsFemale" placeholder="Is Female" required autofocus>
    <span class="btn">
             <button type="submit">Submit</button>
        </span>
</form>
<form method="post" action="/deleteOneUser">
    <h1>Deleting user functionality</h1>
    <h2>Please enter required information</h2>
    <label for="inputID"  class="sr-only">ID</label>
    <input type="number" name="id" placeholder="ID" required autofocus>
    <span class="btn">
             <button type="submit">Submit</button>
        </span>
</form>


</body>
</html>
