// DOM 加载完再执行
$(function() {


    $("#username").focusout(function() {
        var username = $("input[name='username']").val();

        // 加载其他模块的页面到右侧工作区
        $.ajax({
            url: '/verify',
            type: 'GET',
            data:{"username":username},
            success: function(data){
                if (data.message == '账号不存在') {
                    toastr.error(data.message);
                    $("#mysubmit").attr("disabled","true");
                } else {
                    toastr.success(data.message);
                    $("#mysubmit").removeAttr("disabled");
                }
            }
        });
    });

});