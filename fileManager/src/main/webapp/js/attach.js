$(document).ready(function(){
	$('#modal-dialog').on('click','.btn-upload',doUpload)
	$('#uploadFormId').on('click','.btn-down',doDownload)
	$('#search').on('click','.btn-default-lg',doGetObjects)
					  doGetObjects();
	$('#download').on('click','.btn-default',doSomeDown);
	/*document.getElementById("#searchNameId").scrollIntoView();*/
	
	
});
/**全选复选框*/
	function checkAll2(obj){
		console.log(11111);
		console.log(obj);
		var fuxuan=document.getElementById('checkAll');
		var allcheckBox=document.getElementsByName('selectItem');
		console.log(allcheckBox);
		if(fuxuan.checked){
			for(var i in allcheckBox)
				allcheckBox[i].checked=true;
		}else{
			for(var i in allcheckBox)
				allcheckBox[i].checked=false;
		}
	}
	/**批量下载*/
function doSomeDown(){
	var checkedIds = getCheckedIds();
	if(checkedIds==''){
		alert("至少选择一个")
		return;
	};
	console.log(JSON.stringify(checkedIds));
	param={"ids":checkedIds};
	console.log(JSON.stringify(param));
	var url="doSomeDown.do";
	$.post(url,param,function(result){
		if(result.state==1){
			console.log(JSON.stringify(result))
			alert("下载成功");
			
		}else{
			alert(result.message);
		}
	});
}
/**获得选中的ID*/
function getCheckedIds(){
	var checkedIds='';
	//获得tbody对象中名字为checkedItem的input对象
	$('tbody input[name="selectItem"]')
	//迭代input对象
	.each(function(){
		//判定这个input对象是否是选中的input
		if($(this).is(":checked")){//$(this).prop("checked")
			//将选中的checkbox的值拼接为字符串
			if(checkedIds==''){
			checkedIds+=$(this).val();
			}else{
			checkedIds+=","+$(this).val();
			}//"1,2,3,4,5";
		};
	})
	return checkedIds;
}

/**下载*/
function doDownload(){
	var id=
		$(this).parent().parent().data("id");
		/*console.log("id="+id);*/
		var url="doDownload.do?id="+id;
		document.location.href=url;
}
/**上传*/
function doUpload(){
		var url='doSaveObject.do';
//		console.log(1111);
		$("#saveFormId").ajaxSubmit({
		type:'post',
		url:url,
		dataType:'json',
		success:function(result){
//			console.log(2222)
			console.log(JSON.stringify(result))
			if(result.state==1){
			$("#modal-dialog").modal("hide");
		
			doGetObjects();
			}else{
			alert(result.message);
			}
		}
	});	
}


/*显示所有文件*/
function doGetObjects(){
	var url="doFindObjects.do";
	var param=getQueryFormData();
	var pageCurrent=$("#pageId").data("pageCurrent");
	
	if(!pageCurrent){pageCurrent=1};
	param.pageCurrent=pageCurrent;
	console.log(123)
	/*console.log(JSON.stringify(param.fileName));*/
	$.post(url,param,function(result){
//		console.log(JSON.stringify(result))
		if(result.state==1){
//			console.log(JSON.stringify(result.data))
//			console.log(JSON.stringify(result.data.list))
			setTables(result.data.list);
			//分页
			setPagination(result.data.pageObject);
			/*console.log(JSON.stringify(result.data.pageObject))
			console.log(JSON.stringify(result.data.pageObject.pageCounts))*/
		}else{
			alert(result.message);
		}
	});
}
/*获得参数*/
function getQueryFormData(){
	var param={'fileName':$("#searchNameId").val()};
	return param;
}
/*初始化表格*/
function setTables(list){
	var tBody=$("#tbodyId");
	tBody.empty();
	var tds='<td><input type="checkbox" name="selectItem" value="[id]"></td>'
		+'<td>[fileName]</td>'
		+'<td>[size]</td>'
		+'<td>[createdTime]</td>'
	    +'<td><input type="button" class="btn-down" value="下载"></td>';
	for(var i in list){
		var tr=$("<tr></tr>");
		tr.data("id",list[i].id);
		tr.append(
	    tds.replace("[id]",list[i].id)
	       .replace("[fileName]",list[i].fileName)
	       .replace("[size]",list[i].size)
	       .replace("[createdTime]",list[i].createdTime));
	    tBody.append(tr);
		}
	}