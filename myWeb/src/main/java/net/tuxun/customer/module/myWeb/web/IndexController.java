package net.tuxun.customer.module.myWeb.web;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import net.tuxun.core.mybatis.page.PageNav;
import net.tuxun.core.mybatis.page.PageQuery;
import net.tuxun.customer.module.myWeb.bean.Article;
import net.tuxun.customer.module.myWeb.bean.MessagePerple;
import net.tuxun.customer.module.myWeb.bean.MusicInfo;
import net.tuxun.customer.module.myWeb.service.IArticleService;
import net.tuxun.customer.module.myWeb.service.IMessagePerpleService;
import net.tuxun.customer.module.myWeb.service.IMusicInfoService;

@Controller
@RequestMapping("/index")
public class IndexController {

	//文章表服务
	 @Autowired
	 IArticleService iArticleService;
	 //音乐服务
	 @Autowired
	 IMusicInfoService iMusicInfoService;
	 //留言服务
	 @Autowired
	 IMessagePerpleService iMessagePerpleService;
	 
	 @RequestMapping("toFengMian")
	 public String toFengMian(){
		 return "myWeb/fengmian";
	 }
	 
	 /**
	  * 各个模块详细列表
	  * @param categoryId
	  * @param query
	  * @param model
	  * @return
	  */
	 @RequestMapping("/toList")
	 public String toList(String categoryId, PageQuery query, Model model){
		 query.search("categoryId", categoryId);
		 query.order("createDate", "desc");
		 PageNav<Article> pageNav = iArticleService.pageResult(query);
		 model.addAttribute("pageNav", pageNav);
		 return "myWeb/list";
	 }
	
	/**
	 * 微博首页
	 * @param query
	 * @param model
	 * @return
	 */
	@RequestMapping("/toIndex")
	public String toIndex(PageQuery query,Model model){
		query.search("categoryId", "001");
		query.order("createDate", "desc");
		PageNav<Article> pageNav = iArticleService.pageResult(query);
		model.addAttribute("pageNav", pageNav);
		return "myWeb/index";
	}
	
	/**
	 * 加载音乐
	 * @param query
	 * @param model
	 * @return
	 */
	@RequestMapping("/toMusic")
	public String toMusic(PageQuery query, Model model){
		 PageNav<MusicInfo> pageNav = iMusicInfoService.pageResult(query);
		model.addAttribute("pageNav", pageNav);
		return "myWeb/music/music";
	}
	
	/**
	 * 弹出留言板
	 * @return
	 */
	@RequestMapping("/toLiveMessage")
	public String toLiveMessage(){
		return "myWeb/liveMessage";
	}
	
	/**
	 * 保存留言板信息
	 * @return
	 */
	@RequestMapping("/saveLiveMessage")
	@ResponseBody
	public Map<String, Object> saveLiveMessage(HttpServletRequest request, String messagePerple, String messageEmail, String messageContent, String messageTitle, Model model){
		String ip= request.getRemoteAddr();
		
		/*String ip = "";
		try {
			ip = InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} */
		System.out.println(ip);
		MessagePerple messageperple = new MessagePerple();
		messageperple.setCreateTime(new Date());
		messageperple.setMessageContent(messageContent);
		messageperple.setMessageEmail(messageEmail);
		messageperple.setMessagePerple(messagePerple);
		messageperple.setMessageTitle(messageTitle);
		messageperple.setMessagePerpleIp(ip);
	    
		iMessagePerpleService.save(messageperple);
		Map<String, Object> flag = new HashMap<String, Object>();
		flag.put("message", true);
		return flag;
	}
	
	/**
	 * 获取个人技能文章
	 * @param categoryId
	 * @param model
	 * @param query
	 * @return
	 */
	@RequestMapping("/getGRJN")
	@ResponseBody
	public List<Article> getGRJN(String categoryId, Model model, PageQuery query){
		query.search("categoryId", categoryId);
		query.order("createDate", "desc");
		PageNav<Article> pageNav = iArticleService.pageResult(query);
		for(Article article : pageNav.getList()){
			article.setCmsComments(((Article) iArticleService.get(article.getId())).getCmsComments());
		}
		model.addAttribute("pageNav", pageNav);
		return pageNav.getList();
	}
	
	//查看页面
	@RequestMapping("/toView")
	public String toView(String id, Model model){
		Article article = iArticleService.get(id);
		article.setHits(article.getHits()+1);
		iArticleService.modifyNotNull(article);
		
		model.addAttribute("bean", article);
		return "myWeb/view";
	}
}
