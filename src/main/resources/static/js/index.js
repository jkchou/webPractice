/**
 * Created by lenovo on 2016/5/11.
 */
$(function () {   //鼠标点击左侧nav 更换背景图片
    $('.nav-left1').click(function () {
        $(this).toggleClass("nav-left2");
    });

    //nav部分鼠标悬停 更换背景图片
    $('.nav-list li a').mouseover(function () {
        $(this).addClass('nav-panel-list');
    }).mouseout(function () {
        $(this).removeClass('nav-panel-list');
    });
    //点击删除第二类产品
    $(".delete-nj").click(function () {
        var variety_name=$(this).parent().parent().children(".mingcheng").children("h4").text();
        console.log(variety_name);
        var conf = confirm('确定删除吗？');
        if (conf) {
            $(this).parent().parent().addClass('brick').one('webkitAnimationEnd oanimationend msAnimationEnd animationend', function (e) {
                $(this).remove();
                $.ajax({
                    async:false,
                    url:"/FarmSchedulingCategory/deleteVariety",
                    method:"post",
                    data:{
                        varietyName:variety_name,
                    },
                    success(){
                        // console.log(variety_name)
                        window.location.reload();
                    },
                    error(err){
                      console.log(err);
                    }
                })
            });
        }
    });
//点击删除box

    $(".delete-box").click(function () {
        var conf = confirm('确定删除吗？');
        if (conf) {
            $(this).parent().parent().parent().parent().addClass('brick').one('webkitAnimationEnd oanimationend msAnimationEnd animationend', function (e) {
                $(this).remove();
            });
        }
    });
    //点击删除table>tr
    $(".delete-table").click(function () {
        var conf = confirm('确定删除吗？');
        if (conf) {
            $(this).parent().parent().parent().addClass('brick').one('webkitAnimationEnd oanimationend msAnimationEnd animationend', function (e) {
                $(this).remove();
            });
        }
    });
    //点击删除种类
    //删除一级列表
    //传入一级列表id，返回刷新
    $(".delete-zhonglei").click(function () {
        var category_name=$(this).parent().parent().parent().children().children("h3").text();
        var conf = confirm('确定删除吗？');
        if (conf) {
            $(this).parent().parent().parent().parent().addClass('brick').one('webkitAnimationEnd oanimationend msAnimationEnd animationend', function (e) {
                $(this).remove();
                $.ajax({
                    async: false,
                    url: "/FarmSchedulingCategory/deleteCategory",
                    method: "post",
                    data:{
                        categoryName:category_name,
                    },
                    success(data){
                        console.log(category_name);
                    },
                    error(err){
                        console.log(err);
                    }
                })
            });
        }
    });
    //点击删除认证信息
    $(".delete-xinxi").click(function () {
        var conf = confirm('确定删除吗？');
        if (conf) {
            $(this).parent().parent().parent().parent().parent().parent().addClass('brick').one('webkitAnimationEnd oanimationend msAnimationEnd animationend', function (e) {
                $(this).remove();
            });
        }
    });
    ////点击按钮 清除图片
    //$('#sale-reset').click(function () {
    //    $('.img-detail').attr('src','');
    //});
    //当页面加载时：
    $('.section-right1').addClass('col-xs-10').removeClass('col-xs-8').css('margin-left', '8%');
    $('.chart').css('margin-left', '12%');
    // 伸缩菜单二级 生产
    $(".shensuo-btn img").click(function () {
        if ($('.section-right1').is('.col-xs-10')) {
            $('.nav-shensuo').show();
            $('.shensuo-btn').css('left', '33.3%');
            $('.section-right1').addClass('col-xs-8').removeClass('col-xs-10').css('margin-left', '25%');
            $('.chart').css('margin-left', '0');
        } else {
            $('.nav-shensuo').hide();
            $('.shensuo-btn').css('left', '16.66666667%');
            $('.section-right1').addClass('col-xs-10').removeClass('col-xs-8').css('margin-left', '8%');
            $('.chart').css('margin-left', '10%');

        }
    });
    //点击按钮可编辑-园区管理
    $('.yuanqu-bianji-btn').click(function () {
        var Text = $(this).text();
        if (Text == '编 辑') {
            $('.yuanqu-table input').removeAttr('disabled').focus();
            $(this).text('保 存');

        } else {
            $('.yuanqu-table input').attr('disabled', 'disabled');
            $(this).text('编 辑');
        }
    });
    //生产控制 off按钮；
    $('.qiehuan-img img').click(function () {
        var src = $(this).attr('src');
        if (src == 'images/on.png') {
            $(this).attr("src", "images/off.png");
            $('.fade.in').css('opacity', '0.5');
            $('.shebeizhuangtai').html('设 备 状 态：关闭');
        } else if (src == 'images/off.png') {
            $(this).attr("src", "images/on.png");
            $('.fade.in').css('opacity', '1');
            $('.shebeizhuangtai').html('设 备 状 态：开启');
        }
    });


})

//伸缩二级菜单 资源-设备管理
function changeFeedback(id) {
    var str = document.getElementById(id).className;
    var tag = str.substring(20, str.length);
    if (tag == "plus") {
        document.getElementById(id).className = "glyphicon glyphicon-minus";
    } else {
        document.getElementById(id).className = "glyphicon glyphicon-plus";
    }
}

//伸缩二级菜单 资源-设备管理

function getCurrentScheduling(e){

    var currentName1=$(e).next().next().children("h4").text()
    var currentYlut=$(e).next().next().children("h3").text()
    var currentPlot=$(e).next().next().children("h2").text()
    var currentGrowthCycle=$(e).next().next().children("h1").text()
    $("#leibie1").val(currentName1);
    $("#muchan1").val(currentYlut);
    $("#dikuai1").val(currentPlot);
    $("#zhouqi1").val(currentGrowthCycle);
    // console.log(currentName1);
    // console.log(currentYlut);
    // console.log(currentPlot);
    // console.log(currentGrowthCycle);
    // $("#leibie1").val(currentName);
}

function changezhonglei(id, category_id,divId) {
    var str = document.getElementById(id).className;
    var tag = str.substring(20, str.length);
    var category_name = document.getElementById(category_id).innerText;
    // console.log(id)
    // console.log(category_id)
    // console.log(category_name)
    if (tag == "chevron-down") {
        $.ajax({
            async:false,
            url: "/FarmSchedulingCategory/getScheduling",
            method: "post",
            data: {
                "category": category_name
            },
            // contentType:"application/x-www-form-urlencoded;charset=UTF-8",
            success: function (data) {
                console.log(category_name);
                $("#currentCategory").val(category_name);
                data += "<div class=\"col-xs-5 nongjiguanli_emptybox\">\n" +
                    "                                    <div class=\"row\">\n" +
                    "                                        <div class=\"col-xs-1 col-xs-offset-4\">\n" +
                    "                                            <a href=\"#\"aria-hidden=\"true\" data-toggle=\"modal\"\n" +
                    "                                               data-target=\"#tianjiazhonglei\" type=\"button\"><span\n" +
                    "                                                    class=\"glyphicon glyphicon-plus-sign\"></span></a>\n" +
                    "                                        </div>\n" +
                    "                                        <div class=\"col-xs-6\">\n" +
                    "                                            <h4>添加品种</h4>\n" +
                    "                                        </div>\n" +
                    "                                    </div>\n" +
                    "                                </div>" +
                    "<script>"+
                    "$(\".delete-nj\").click(function () {\n" +
                    "        var variety_name=$(this).parent().parent().children(\".mingcheng\").children(\"h4\").text();\n" +
                    "        console.log(variety_name);\n" +
                    "        var conf = confirm('确定删除吗？');\n" +
                    "        if (conf) {\n" +
                    "            $(this).parent().parent().addClass('brick').one('webkitAnimationEnd oanimationend msAnimationEnd animationend', function (e) {\n" +
                    "                $(this).remove();\n" +
                    "                $.ajax({\n" +
                    "                    async:false,\n" +
                    "                    url:\"/FarmSchedulingCategory/deleteVariety\",\n" +
                    "                    method:\"post\",\n" +
                    "                    data:{\n" +
                    "                        varietyName:variety_name,\n" +
                    "                    },\n" +
                    "                    success(){\n" +
                    "                        console.log(variety_name)\n" +
                    "                    },\n" +
                    "                    error(err){\n" +
                    "                      console.log(err);  \n" +
                    "                    }\n" +
                    "                })\n" +
                    "            });\n" +
                    "        }\n" +
                    "    });</script>"

                $(`#${divId}`).html(data);
                setTimeout(function (){
                    console.log(2);
                    document.getElementById(id).className = "glyphicon glyphicon-chevron-up";
                },200)
            },
            error: function (err) {
                console.log(err.statusText);
                console.log('异常');
            }
        })
    } else {
        document.getElementById(id).className = "glyphicon glyphicon-chevron-down";
    }
}

//由身份证号自动生成生日

function dealCard() {
    var birthday = getBirthday();
    var c = document.getElementById("birth");

    switch (birthday) {
        case 0:
            alert("Sorry,the program runs wrong!");
            break;
        case 1:
            alert("You must be input again!");
            break;
        default:
            c.value = birthday;
            break;

    }
}

function getBirthday() {
    var a = document.getElementById("card").value;
    if (15 == a.length || 18 == a.length) {
        var left = a.length - 12;
        var right = a.length - 4;
        var b = a.slice(left, right);
        if (8 == b.length) {
            return b;
        } else return 0;
    } else return 1;
}

//资源-设备
//是否确定  修改设备状态
function gradeChange() {
    var objS = document.getElementsByClassName("xiugai_zhi")[0];
    var grade = objS.options[objS.selectedIndex].grade;
    alert("确定修改么?");
}

function gradeChange() {
    var objS1 = document.getElementsByClassName("xiugai_zhi")[1];
    var grade1 = objS1.options[objS1.selectedIndex].grade;
    alert("确定修改么?");
}

function gradeChange() {
    var objS2 = document.getElementsByClassName("xiugai_zhi")[2];
    var grade2 = objS2.options[objS2.selectedIndex].grade;
    alert("确定修改么?");
}

function gradeChange() {
    var objS3 = document.getElementsByClassName("xiugai_zhi")[3];
    var grade3 = objS3.options[objS3.selectedIndex].grade;
    alert("确定修改么?");
}

function gradeChange() {
    var objS4 = document.getElementsByClassName("xiugai_zhi")[4];
    var grade4 = objS4.options[objS4.selectedIndex].grade;
    alert("确定修改么?");
}

function gradeChange() {
    var objS5 = document.getElementsByClassName("xiugai_zhi")[5];
    var grade5 = objS5.options[objS5.selectedIndex].grade;
    alert("确定修改么?");
}

function gradeChange() {
    var objS6 = document.getElementsByClassName("xiugai_zhi")[6];
    var grade6 = objS6.options[objS6.selectedIndex].grade;
    alert("确定修改么?");
}

function gradeChange() {
    var objS7 = document.getElementsByClassName("xiugai_zhi")[7];
    var grade7 = objS7.options[objS7.selectedIndex].grade;
    alert("确定修改么?");
}

function gradeChange() {
    var objS8 = document.getElementsByClassName("xiugai_zhi")[8];
    var grade8 = objS8.options[objS8.selectedIndex].grade;
    alert("确定修改么?");
}


var imagePath ;
var baseUrl = "http://127.0.0.1:8888/static/";

function uploadImage(imgId) {
    var formData = new FormData();
    let file = document.getElementById('saveImage').files[0];
    formData.append("file",file);
    $.ajax({
        async:false,
        method:"post",
        url:"/api/scheduling/image",
        cache: false,
        contentType: false,
        processData: false,
        data:formData,
        success(data){
            console.log(data)
            imagePath = data;
            var src = baseUrl + imagePath
            $(`#${imgId}`).attr("src",src);
        },
        error(err){
            console.log(err)
        }
    })
}

function updatezhonglei(e){
     var createDate=$(e).parent().prev().children("#createDate").val();
     var miaoshu=$(e).parent().prev().prev().children("#miaoshu").val();
     var ylut=$(e).parent().prev().prev().prev().children("#muchan2").val();
     var name=$(e).parent().prev().prev().prev().prev().children("#leibie").val();
    //formData.append('picture', $(e).parent().prev().prev().prev().prev().prev().children('#picture').files[0]);
    // let file = document.getElementById('picture').files[0];
/*    console.log(typeof formData);
    console.log(formData);*/
    $.ajax({
        async:false,
        method:"post",
        url:"/FarmSchedulingCategory/updateCategory",
        data:{
            createDate:createDate,
            edescribe:miaoshu,
            ylut:ylut,
            name:name,
            imgPath: imagePath,
        },
        success(data){

        },
        error(err){
            console.log(err)
        }
    })


    // console.log(createDate);
    // console.log(miaoshu);
    // console.log(ylut);
    // console.log(name);
}
