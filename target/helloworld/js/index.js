$(function(){
	$("#finish").on('click',function(){
		
		var title = $("#title").val().trim();
		var language = $("#language").val().trim();
		var type = $("#type").val().trim();
		var price = $("#price").val().trim();
		var introduce = $("#introduce").val().trim();
		var note = $("#note").val().trim();
		// var path = $("#path")[0].files;
		// var doc = $("#doc")[1].file;

		var status = "未完成";
		var flag = 0;

		// var jsonData = {
		// 	order_title : title,
		// 	order_language :language,
		// 	order_type :type,
		// 	order_price : price,
		// 	order_status : status,
		// 	doc : doc,
        //     attachment : path,
		// 	order_introduce :introduce,
		// 	order_note : note,
		// 	order_flag : flag,
        //     order_delivery_time : $("#deliverytime").val()
		// }

        var jsonData = new FormData();
        jsonData.append('order_title',title);
        jsonData.append('order_language',language);
        jsonData.append('order_type',type);
        jsonData.append('order_price',price);
        jsonData.append('order_status',status);
        jsonData.append('order_introduce',introduce);
        jsonData.append('order_note',note);
        jsonData.append('order_flag',flag);
        jsonData.append('order_delivery_time',$("#deliverytime").val());
        jsonData.append('doc',$("#path")[0].files);
        jsonData.append('attachment',$("#doc")[1].files);

		$.ajax({
			type:"POST",
			url:"/ITKIM/order/create",
			// async:false,
            cache:false,
			// data : JSON.stringify(jsonData),
            data : jsonData,
			processData :false,
			dataType :'json',
			// contentType:'application/json',
            // contentType : 'multipart/form-data',
            // contentType :false,
			error :function(request){
				layer.alert("连接超时");
			},
			success: function(data){
				var jsondata = eval("("+data+")");
				if(jsondata.code == 0){
					layer.alert("添加成功");
				}else{
					layer.alert(data.meg,{icon:5});
				}
			}
		});
	});
})
