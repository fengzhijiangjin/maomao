<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title> - 表单验证 jQuery Validation</title>
    <meta name="keywords" content="">
    <meta name="description" content="">

    <link rel="shortcut icon" href="favicon.ico"> 
    <link href="/assets/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="/assets/css/font-awesome.css?v=4.4.0" rel="stylesheet">
    <link href="/assets/css/animate.css" rel="stylesheet">
    <link href="/assets/css/style.css?v=4.1.0" rel="stylesheet">

</head>

<body class="gray-bg">
    <div class="wrapper wrapper-content animated fadeInRight">
        <div class="row">
            <div class="col-sm-12">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5>商品轮播图添加</h5>
                    </div>
                    <div class="ibox-content">
                        <p>用于商品轮播图的添加：</p>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-sm-12">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5>完整验证表单</h5>
                    </div>
                    <div class="ibox-content">
                        <form class="form-horizontal m-t" id="frm" enctype="multipart/form-data" method="post" action="${ctx}/rollPic/admin/addRollPic">
                        	<input type="hidden" id="productId" name="productId" value="${productId}">
                            <div class="form-group">
                                <label class="col-sm-3 control-label">图片：</label>
                                <div class="col-sm-8">
                                    <input id="file" name="file" class="form-control" type="file" >
                                </div>
                            </div>


                            <div class="form-group">
                                <div class="col-sm-8 col-sm-offset-3">
                                    <button class="btn btn-primary" enctype="multipart/form-data" type="submit">提交</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>

    </div>


    <!-- 全局js -->
    <script src="/assets/js/jquery.min.js?v=2.1.4"></script>
    <script src="/assets/js/bootstrap.min.js?v=3.3.6"></script>

    <!-- 自定义js -->
    <script src="/assets/js/content.js?v=1.0.0"></script>

    <!-- jQuery Validation plugin javascript-->
    <script src="/assets/js/plugins/validate/jquery.validate.min.js"></script>
    <script src="/assets/js/plugins/validate/messages_zh.min.js"></script>
    <script src="/assets/js/plugins/layer/layer.min.js"></script>
    <script src="/assets/js/plugins/layer/laydate/laydate.js"></script>
    <script type="text/javascript">
    $(document).ready(function () {
	  	//外部js调用
	    // laydate({
	    //     elem: '#birthday', //目标元素。由于laydate.js封装了一个轻量级的选择器引擎，因此elem还允许你传入class、tag但必须按照这种方式 '#id .class'
	    //     event: 'focus' //响应事件。如果没有传入event，则按照默认的click
	    // });

	    $("#frm").validate({

    	    submitHandler:function(form){
                var myform = new FormData();

                myform.append('file', $("#file")[0].files[0]);
                myform.append('productId',${productId} );


    	    	$.ajax({
   	    		   type: "POST",
   	    		   // dataType: "json",
   	    		   url: "/rollPic/admin/addRollPic",
   	    		   data: myform,

   	    		   success: function(msg){
                       // alert("操作成功！！！");
                           layer.msg(msg.message, {time: 2000},function(){
	   						var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
	   						parent.layer.close(index);
	   					});
   	    		   }
   	    		});
            } 
    	});
    });
    </script>

</body>

</html>
