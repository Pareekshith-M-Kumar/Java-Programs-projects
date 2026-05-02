<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Submit Complaint</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>

<h2>Submit Complaint</h2>

<form action="submitComplaint" method="post">
    
    Category:
    <select name="category">
        <option value="Electricity">Electricity</option>
        <option value="Water">Water</option>
        <option value="Internet">Internet</option>
    </select>
    <br><br>

    Description:
    <textarea name="description"></textarea>
    <br><br>

    <button type="submit">Submit</button>

</form>

</body>
</html>