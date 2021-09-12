<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 2021/9/2
  Time: 12:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
    <title>Title</title>

</head>
<script type="text/javascript" src="js/jquery-1.8.0.min.js"></script>


<script type="text/javascript">

            $(function(){
                $("#uid").blur(function(){
                    //1.获得value值
                    var uid = $(this).val();
                    //2.发送请求
                    $.post("/getuser","uid="+uid,function(rs){
                        //转换成可以处理的js
                        rs=eval("("+rs+")");
                        //此时的rs是json格式的对象
                        $("#uname").val(rs.username);
                        $("#pass").val(rs.password);
                    });
                });
            })
    function x() {
        alert("返回");
        window.history.back(-1);
    }

</script>
<body>
uid:<input type="text" id="uid"><br>
name:<input type="text" id="uname"><br>
pass:<input type="text" id="pass"><br>
欢迎~<%=session.getAttribute("userName")%>
<input type="button" name="backButton"  value="返回" class="buttonleg" onclick="x()">



</body>
</html>
