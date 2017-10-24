$(document).ready(function(){
	$("#pageId").on('click','.pre,.next,.first,.last',jumpToPage)
				
})
//设置分页
function setPagination(pageObject){
	/*console.log(JSON.stringify(pageObject))*/
 //绑定总页数
 $("#pageId").data("pageCounts",pageObject.pageCounts);
	/*console.log(pageObject.pageCounts)*/
 	$(".pageCounts").html('总页数('+pageObject.pageCounts+')')
 //绑定当前页面
 $("#pageId").data("pageCurrent",pageObject.pageCurrent);
	/*console.log(pageObject.pageCurrent)*/
 	$(".pageCurrent").html("当前页("+pageObject.pageCurrent+")")
}
function jumpToBeginOrEnd(){
	
}
//跳转到下一页
function jumpToPage(){
	//获得点击对象上class属性对应的值
	var clazz=$(this).attr("class");
	//获得pageId对象上绑定的pageCurrent对应的值
	var pageCurrent=$('#pageId').data("pageCurrent");
	//获得pageId对象上绑定的pageCount对应的值
	var pageCounts=$('#pageId').data("pageCounts")
	//判断点击的是否是上一页
	if(clazz=='pre'&&pageCurrent>1){
		pageCurrent--;
	}
	//判断点击的是否是下一页
	if(clazz=="next"&&pageCurrent<pageCounts){
		pageCurrent++;
	}
	if(clazz=="first"){
		pageCurrent=1;
	}
	if(clazz=="last"){
		pageCurrent=pageCounts
	}
	//重写绑定pageCurrent的值,
	$('#pageId').data("pageCurrent",pageCurrent);
	//重新执行查询操作
	doGetObjects();
}
