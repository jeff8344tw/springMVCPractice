<html>
<script type="text/javascript" src="js/jquery-3.5.1.min.js" />
<script type="text/javascript">
    function test(){
        $.ajax({
           url:"testAjax_DELETE",
           type:"DELETE",
           data:{ id:1001 },
           dataType:"json",
           success:function(obj){
               alert(obj);
           }
        });
    }

    $(function(){
        $("#btn").click(function(){
            $.ajax({
                url:"testJson",
                type:"POST",
                data:{},
                dataType:"text",
                success:function(msg){
                    // 第一種實現方式
                    // var tb = "<table>";
                    // tb += "<tr><th>id</th><th>lastName</th><th>email</th><th>gender</th><th>departmentName</th></tr>"
                    // for(var i in msg){
                    //     var emp = msg[i];
                    //     tb += "<tr><td>"+emp.id+"</td><td>"+emp.lastName+"</td><td>"+emp.email+"</td><td>"+emp.gender+"</td><td>"+emp.department.departmentName+"</td><td>"+"</td></tr>";
                    // }
                    // tb += "</table>";
                    // $("body").append(tb);
                    // 第二種實現方式
                    $("body").append("<table></table>")
                    $("table").append("<tr><th>id</th><th>lastName</th><th>email</th><th>gender</th><th>departmentName</th></tr>")
                    for(var i in msg){
                        var emp = msg[i];
                        $("table").append("<tr><td>"+emp.id+"</td><td>"+emp.lastName+"</td><td>"+emp.email+"</td><td>"+emp.gender+"</td><td>"+emp.department.departmentName+"</td><td>"+"</td></tr>");
                    }
                }
            })
        })
    })
</script>
<body>
    <h2>Hello World!</h2>
    <a href="test">test springMVC</a>
    <br />
    <a href="emps">emp info</a>
    <br />
    <input id = "btn" type="button" value="text ajax" />
    <a href="testJson">test json</a>

    <br/>
    <form action="testRest" method="post">
        <input type="submit" value="testPost" />
    </form>
    <br/>
    <form action="/testEncoding" method="post">
        <input name="username" type="text" />
        <input type="submit" value="testEncoding" />
    </form>

    <br/>
    <form action="testRest" method="post">
        <input type="hidden" name="_method" value="PUT"/>
        <input type="submit" value="testPUT" />
    </form>

    <br/>
    <form action="testRest/1001" method="post">
        <input type="hidden" name="_method" value="DELETE"/>
        <input type="submit" value="testDELETE" />
    </form>

    <input type="button" value="testAJAX" onclick="test()" />

    <br />

    <a href="textListener" >test listener</a>
</body>
</html>
