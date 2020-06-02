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
  
spring和springMVC的整合:
1. 不整合: 需要將spring所管理的內容都交給springMVC管理，這樣會造成業務邏輯混亂
2. 整合: spring的配置文件什麼時候加載? 怎麼加載
解決方法: 監聽器，可以在ServletContext加載時，通過監聽器加載spring的配置文件，創建spring容器
spring提供的監聽器: ContextLoaderListener

3. bean被創建兩次的問題， 在springMVC終止掃描控制層，在spring中，通過包含或排除對所掃描的包進行制定
4. spring和springMVC的關係:
spring是父容器
springMVC是子容器
規定: 子容器能夠調用訪問父容器中的Bean， 而父容器不能夠調用訪問子容器的bean

