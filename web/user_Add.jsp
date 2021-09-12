<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<script type="text/javascript">
    function test(){
        //创建xmlhttpservice
        var xmlhttp;
        if (window.XMLHttpRequest){
            xmlhttp=new XMLHttpRequest();
        }else if(window.ActiveXObject){
            xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
        }
        //打开链接
        var uname=document.getElementById("userName").value;
        xmlhttp.open("post","/testuname",true);
        //返回指定函数
        xmlhttp.onreadystatechange=function (){
            //判断状态
            if(xmlhttp.readyState==4){
                var text=xmlhttp.responseText;
                document.getElementById("rs").innerText=text;
            }
        }
        //发送数据
        xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded;charset=UTF-8");
        console.log(uname)
        xmlhttp.send("username="+uname);

    }

</script>
<body>

                <form action ="/user/add" method="get">
                    用户姓名<input type="text" id="userName" name="userName" onblur="test()"/><br>
                    <span id="rs">ss</span><br>
                    用户密码<input type="password" name="password"/>
                    <input type="submit" value="提交" />
                </form>


</body>
</html>