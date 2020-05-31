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
</script>
<body>
    <h2>Hello World!</h2>
    <a href="test">test springMVC</a>
    <br />
    <a href="emps">emp info</a>

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
</body>
</html>
