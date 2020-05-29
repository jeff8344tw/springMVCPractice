springMVCPractice

spsringMVC的搭建過程:
1.導入jar
2.在web.xml中配置springMVC的核心(前端)控制器DispatcherServlet
作用: 加載springMVC的配置文件,在下方的配置方式下，DispatcherServlet自動加載配置文件，此時的配置文件有默認的位置和名稱
    默認位置:WEB-INF下，默認名稱:<servlet-name>-servlet.xml，例如以下配置方式的文件名:springMVC-servlet.xml
    當家載了配置文件，springMVC就會根據數據掃描組件找到控制層
    <servlet>
        <servlet-name>springMVC</servlet-name>
        <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
    </servlet>
    <servlet-mapping>
        <servlet-name>springMVC</servlet-name>
        <!--路徑模型-->
        <url-pattern>/</url-pattern>
    </servlet-mapping>
3. 創建一個POJO(普通的java對象)，在此類加上@Controller註解，springMVC就會將此類做為控制層加載，讓其處理請求響應
4. 在控制層中，需要在方法上設置@RequestMapping(value="hello")，
springMVC就是通過此註解將請求路徑與控制層中的方法匹配，此時請求路徑為localhost:8080/projectName/xxx
5.處理請求的方法會返回一個字符串，及視圖名稱，最終會通過配置文件中配置的試圖解析器實現頁面跳轉
方式:prefix + 視圖名稱 + suffix ， 此為最終跳轉的頁面路徑
  

