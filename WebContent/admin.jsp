<%@ page import="java.sql.*, com.project.util.DBConnection" %>
<link rel="stylesheet" href="style.css">
<h2>Admin Panel</h2>

<table border="1">
<tr>
    <th>ID</th>
    <th>Category</th>
    <th>Description</th>
    <th>Status</th>
    <th>Action</th>
</tr>

<%
Connection con = DBConnection.getConnection();
Statement st = con.createStatement();
ResultSet rs = st.executeQuery("SELECT * FROM complaints");

while(rs.next()) {
%>

<tr>
    <td><%= rs.getInt("id") %></td>
    <td><%= rs.getString("category") %></td>
    <td><%= rs.getString("description") %></td>
    <td><%= rs.getString("status") %></td>

    <td>
        <form action="updateStatus" method="post">
            <input type="hidden" name="id" value="<%= rs.getInt("id") %>">
            <select name="status">
                <option>Pending</option>
                <option>In Progress</option>
                <option>Resolved</option>
            </select>
            <button type="submit">Update</button>
        </form>
    </td>
</tr>

<%
}
%>

</table>