/**
 * 文件上传插件
 */
$(function(){
	$.ajax({
		url:"/index/getGRJN",
		data:{"categoryId":"002"},
		type:"get",
		dataType:"json",
		success:function(data){
			var gr0HTML = '';
			var gr1HTML = '';
			$.each(data, function(index, value){
				var createDate = new Date(value.createDate);
				
				if(index == 0){
					gr0HTML += '<figure> <img src="'+value.image+'" style="width:630px;height:250px"  alt="Panama Hat"><figcaption><strong>'+value.title+'</strong>'+value.description+'</figcaption></figure><div class="card"><h2>我的名片</h2>'+
				      '<p>网名：lesserPanda | 小熊猫</p><p>姓名：潘登</p><p>职业：java开发</p><p>电话：13396680863</p><p>Email：pandeng123321sina.com</p><ul class="linkmore"><li><a href="/" class="talk" title="给我留言"></a></li>'+
				      '<li><a href="/" class="address" title="联系地址"></a></li><li><a href="/" class="email" title="给我写信"></a></li><li><a href="/" class="photos" title="生活照片"></a></li><li><a href="/" class="heart" title="关注我"></a></li>'+
				      '</ul></div>';
				}else{
					gr1HTML += '<li><div class="arrow_box"><div class="ti"></div><!--三角形--><div class="ci"></div><!--圆形--><h2 class="title"><a href="/" target="_blank">'+value.title+
					'</a></h2><ul class="textinfo"><a href="/" target="_blank"><img src="'+value.image+'"></a><p class="slue">'+value.description+'</p></ul><ul class="details"><li class="likes"><a href="#">'+(value.pushParise == null?0:value.pushParise)+
					'</a></li><li class="comments"><a href="#">'+(value.cmsComments == null?0:value.cmsComments.size())+'</a></li><li class="icon-time"><a href="#">'+createDate.getFullYear()+'-'+(createDate.getMonth()+1)+'-'+createDate.getDay()+'</a></li></ul></div></li>';
				}
				
			})
			$("#mainbody .info").append(gr0HTML);
			$(".blogs .bloglist").append(gr1HTML);
		}
	})
});
