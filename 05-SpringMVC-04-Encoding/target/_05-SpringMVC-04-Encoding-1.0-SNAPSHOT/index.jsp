<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>测试编码集</title>
</head>
<body>
<form method="post" action="/user/register">
  <table align="center">
    <tr>
      <td>姓名</td>
      <td><input type="text" name="name"></td>
    </tr>
    <tr>
      <td>年龄</td>
      <td><input type="text" name="age"></td>
    </tr>
    <tr>
      <td>性别</td>
      <td>
       男 <input value="男" type="radio" name="gender" checked>
      女  <input value="女" type="radio" name="gender">
      </td>
    </tr>
    <tr>
      <td>信息</td>
      <td><input type="text" name="info"></td>
    </tr>
    <tr>
      <td colspan="2" align="center">
        <input type="submit" value="提交">
        <input type="reset" value="重置">
      </td>
    </tr>
  </table>
</form>
</body>
</html>