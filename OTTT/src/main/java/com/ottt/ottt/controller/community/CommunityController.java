package com.ottt.ottt.controller.community;

import java.util.Base64;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ottt.ottt.dao.login.LoginUserDao;
import com.ottt.ottt.dto.ArticleDTO;
import com.ottt.ottt.dto.ArticleLikeDTO;
import com.ottt.ottt.dto.ArticleSearchDTO;
import com.ottt.ottt.dto.UserDTO;
import com.ottt.ottt.service.community.freecomuity.CommunityService;


@Controller
@RequestMapping(value = "/community")
public class CommunityController {
	
	@Autowired
	CommunityService communityService;
	@Autowired
	LoginUserDao loginUserDao;

	private static final Logger logger = LoggerFactory.getLogger(CommunityController.class);
	
	//freecommunity 메인호출
	@GetMapping("/freecommunity")
	public String freecommunity(@RequestParam(value = "category", required = false) String category, Model m, HttpServletRequest request, HttpSession session, String toURL) throws Exception {
		
		logger.info(">>>>>>>>>>>>>>>>>>>>> @GetMapping /freecommunity freecommunity 진입 ");
		logger.info(">>>>>>>>>>>>>>>>>>>>> category 선택한 카테고리 : "+category);
		
		UserDTO userDTO = loginUserDao.select((String)session.getAttribute("id"));
		
		System.out.println("=============================session.getAttribute() : " + session.getAttribute("id"));
		System.out.println("=============================userDTO : " + userDTO);
						
		
		if(userDTO != null) {
			logger.info(">>>>>>>>>>>>>>> 로그인 아이디 정보 >>>>>>>>>>>>>>>>>>>> "+userDTO.getUser_id());
		}else {
			logger.info(">>>>>>>>>>>>>>> 로그인상태가 아닙니다. ");
		}

		/*
		if(!loginCheck(request)) {
			return "redirect:/login/login?toURL="+request.getRequestURL();		
		}
		*/
		//UserDTO userDTO = loginUserDao.select((String)session.getAttribute("id"));

		m.addAttribute("category",category);
		m.addAttribute(userDTO);
		
		return "/community/freecommunity/communityMain";		

	}
	
	//community 저장
	@PostMapping("/freecommunity")
	public String freecommunity_post(ArticleDTO articleDTO, HttpServletRequest request, Model m) {
		
		logger.info(">>>>>>>>>>>>>>>>>>>>> @PostMapping /freecommunity freecommunityPost 진입 ");
		
		try {

			HttpSession session = request.getSession();

			UserDTO userDTO = loginUserDao.select((String)session.getAttribute("id"));
			m.addAttribute(userDTO);
        	if (userDTO == null) {	   
        		logger.info("!!!! 로그인이 필요합니다. !!!!");
        		return "redirect:/login";
        	}

        	articleDTO.setUser_no(userDTO.getUser_no());
        	
        	if (!articleDTO.getUpFile().isEmpty()) {
        		
        		
        		Base64.Encoder encoder = Base64.getEncoder();

        		byte[] photoEncode = encoder.encode(articleDTO.getUpFile().getBytes());
        		
        		articleDTO.setArticle_image( new String(photoEncode, "UTF8") );
        		logger.info(">>>>>> 업로드 파일 이름은? "+articleDTO.getUpFile().getOriginalFilename());
        		articleDTO.setArticle_image_name(articleDTO.getUpFile().getOriginalFilename());
        		
        	}
        	
        	communityService.insert(articleDTO);	        		

		} catch (Exception e) {
			e.printStackTrace();
		}
				
		return "redirect:/community/freecommunity";
	}
	
	//community 글 자세히보기
	@GetMapping("/post")
	public String freecommunityPost(ArticleDTO dto, HttpServletRequest request, Model m ) {
		
		logger.info(">>>>>>>>>>>>>>>>>>>>> @GetMapping /post freecommunityPost 진입 ");
		
		try {
		
			HttpSession session = request.getSession();
			
			UserDTO userDTO = loginUserDao.select((String)session.getAttribute("id"));
			m.addAttribute(userDTO);

			if(userDTO != null) {
				dto.setUser_no(userDTO.getUser_no());
			}
			
			ArticleDTO articleDTO = communityService.select(dto);

			m.addAttribute("articleDTO", articleDTO);
			m.addAttribute("mode", "view");
		
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:/community";
		}
		return "/community/freecommunity/communityPost";		
	}
	
	//community 글 수정모드로 진입
	@GetMapping("/updatePost")
	public String freecommunityUpdatePost(ArticleDTO dto, Model m ) {
		
		logger.info(">>>>>>>>>>>>>>>>>>>>> @GetMapping /updatePost freecommunityUpdatePost 진입 ");

		try {
			ArticleDTO articleDTO = communityService.select(dto);
			m.addAttribute("articleDTO", articleDTO);
			UserDTO userDTO = loginUserDao.selectNo(articleDTO.getUser_no());
			m.addAttribute("userDTO", userDTO);
			m.addAttribute("mode", "update");
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:/community";
		}

		return "/community/freecommunity/communityPost";		

	}
	
	//수정하기
	@PostMapping("/update")
	public String freecommunitUpdate(ArticleDTO articleDTO, HttpServletRequest request) {
		
		logger.info(">>>>>>>>>>>>>>>>>>>>> @PostMapping /update freecommunityUpdatePost 진입 ");
		
		String returnUrl = "";
		
		try {
			
			HttpSession session = request.getSession();
			UserDTO userDTO = loginUserDao.select((String)session.getAttribute("id"));
        	
			if (userDTO == null) {	   
        		logger.info("!!!! 로그인이 필요합니다. !!!!");
        		return "redirect:/login";
        	}

        	articleDTO.setUser_no(userDTO.getUser_no());

        	if (!articleDTO.getUpFile().isEmpty()) {
        		
        		Base64.Encoder encoder = Base64.getEncoder();

        		byte[] photoEncode = encoder.encode(articleDTO.getUpFile().getBytes());
        		
        		articleDTO.setArticle_image( new String(photoEncode, "UTF8") );
        		
        		logger.info(">>>>>> 업로드 파일 이름은? "+articleDTO.getUpFile().getOriginalFilename());

        		articleDTO.setArticle_image_name(articleDTO.getUpFile().getOriginalFilename());
        		
        	}
        	
        	
        	if(communityService.modify(articleDTO) > 0) {
				returnUrl =  "redirect:/community/post?mode=view&article_no="+articleDTO.getArticle_no();
			}else {
				returnUrl =  "redirect:/community";
			}
        	
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:/community";
		}
		return returnUrl;
	}
	
	
	//삭제하기
	@PostMapping("/delete")
	public String freecommunitDelete(Locale locale, Model m, Integer article_no) throws Exception{

		logger.info(">>>>>>>>>>>>>>>>>>>>> @PostMapping /delete freecommunitDelete 진입 ");
		
		//정상적으로 수정 및 삭제를하면 마이바티스에서 1을 반환한다. 
		if(communityService.delete(article_no) == 1) {	//숫자 1이면 정상처리
			return "redirect:/community/freecommunity";
		}else {
			return "redirect:/community/freecommunity";
		}

	}
	
	public boolean loginCheck(HttpServletRequest request) {
		 //1. 세션을 얻어 (false는 session이 없어도 새로 생성하지 않음, 반환값은 null)
		HttpSession session = request.getSession(false);
		 //2. 세션에 id가 있는지 확인, 있으면 true를 반환 
		return session != null && session.getAttribute("id")!=null;
	}
	
	//메인 new 목록
	@PostMapping("/ajax/getArticleList")
	@ResponseBody
	public Map<String,Object> getArticleList(ArticleSearchDTO dto, HttpSession session) throws Exception {
		
		logger.info(">>>>>>>>>>>>>>>>>>>>> @PostMapping /ajax/getArticleList getArticleList 진입 ");
		logger.info(">>>>>>>>>>>>>>>>>>>>> ArticleSearchDTO >>>> "+dto.toString());

		Map<String, Object> result = new HashMap<String,Object>();
		
		//왼쪽 카테고리가 "내가쓴글","내가 좋아요한 글", "내가 댓글단 글" 일때 회원번호를 ArticleSearchDTO에 담는다.
		if( "myPost".equals(dto.getCategory()) 
				|| "myLike".equals(dto.getCategory()) 
					|| "myComment".equals(dto.getCategory())) {

			UserDTO userDTO = loginUserDao.select((String)session.getAttribute("id"));
			
        	if (userDTO == null) {	   
        		result.put("message", "로그인이 필요합니다.");
        		return result;
	        }
			
			dto.setUser_no(userDTO.getUser_no());

		}

		result.put("message", "success");
		result.put("list", communityService.getArticleList(dto));
		result.put("totalCount", communityService.getArticleTotalCount(dto));
		
		return result;

	}
	
	//좋아요 눌렀는지 조회
	@PostMapping("/ajax/selectLikeCount")
	@ResponseBody
	public Map<String,Object> selectLikeCount(ArticleLikeDTO dto, HttpSession session) throws Exception {
		
		logger.info(">>>>>>>>>>>>>>>>>>>>> @PostMapping /ajax/selectLikeCount selectLikeCount 진입 ");
		logger.info(">>>>>>>>>>>>>>>>>>>>> ArticleLikeDTO >>>> "+dto.toString());

		Map<String, Object> result = new HashMap<String,Object>();
		
		UserDTO userDTO = loginUserDao.select((String)session.getAttribute("id"));
    	if (userDTO == null) {	   
    		result.put("message", "로그인이 필요합니다.");
    		return result;
        }

    	dto.setUser_no(userDTO.getUser_no());

		result.put("message", "success");
		result.put("result", communityService.selectLikeCount(dto) );
		
		return result;

	}
	
	//좋아요 저장
	@PostMapping("/ajax/insertLike")
	@ResponseBody
	public Map<String,Object> insertLike(ArticleLikeDTO dto, HttpSession session) throws Exception {
		
		logger.info(">>>>>>>>>>>>>>>>>>>>> @PostMapping /ajax/insertLike insertLike 진입 ");
		logger.info(">>>>>>>>>>>>>>>>>>>>> ArticleLikeDTO >>>> "+dto.toString());

		Map<String, Object> result = new HashMap<String,Object>();
		
		UserDTO userDTO = loginUserDao.select((String)session.getAttribute("id"));
    	if (userDTO == null) {	   
    		result.put("message", "로그인이 필요합니다.");
    		return result;
        }
		dto.setUser_no(userDTO.getUser_no());

		result.put("message", "success");
		result.put("success", communityService.insertLike(dto) );
		
		return result;

	}
	
	//좋아요 삭제
	@PostMapping("/ajax/deleteLike")
	@ResponseBody
	public Map<String,Object> deleteLike(ArticleLikeDTO dto, HttpSession session) throws Exception {
		
		logger.info(">>>>>>>>>>>>>>>>>>>>> @PostMapping /ajax/deleteLike deleteLike 진입 ");
		logger.info(">>>>>>>>>>>>>>>>>>>>> ArticleLikeDTO >>>> "+dto.toString());

		Map<String, Object> result = new HashMap<String,Object>();
		
		UserDTO userDTO = loginUserDao.select((String)session.getAttribute("id"));
    	if (userDTO == null) {	   
    		result.put("message", "로그인이 필요합니다.");
    		return result;
        }
		dto.setUser_no(userDTO.getUser_no());

		result.put("message", "success");
		result.put("success", communityService.deleteLike(dto) );
		
		return result;

	}
}




	




















