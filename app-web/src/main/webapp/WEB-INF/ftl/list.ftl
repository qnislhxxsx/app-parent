<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript" src="http://172.22.1.114:18080/SpringWeb/js/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="http://172.22.1.114:18080/SpringWeb/js/json2.js"></script>
<title>Insert title here</title>
</head>
<body>
list2<br/>
<#list samples as sample>  
	id : ${sample.id}, name : ${sample.name}  <br/>  
</#list>  
</body>
<script type="text/javascript">
$(function(){
	var datas=[];
	var data1={"id":"test","name":"gz"};  
    var data2={"id":"ququ","name":"gr"};  
    datas.push(data1);  
    datas.push(data2);  
	$.ajax({ 
            type:"POST", 
            url:"http://172.22.1.114:18080/SpringWeb/sample/arrayPost", 
            dataType:"json",      
            contentType:"application/json",               
            data:JSON.stringify(datas), 
            success:function(data){ 
                alert(data);   	                
            } 
   }); 
	
});
</script>

</html>