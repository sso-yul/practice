package com.ottt.ottt.dao.review;

import java.util.List;

import com.ottt.ottt.dto.CommentDTO;
import com.ottt.ottt.dto.ReviewDTO;

public interface ReviewDao {
	//리뷰 페이지
	int delete(Integer review_no, int user_no) throws Exception;			//삭제
	int update(ReviewDTO reviewDTO) throws Exception;						//수정
	int insert(ReviewDTO dto) throws Exception ;							//작성
	double ratingAvg() throws Exception;
	int updateCommentCnt(Integer review_no, int cnt)throws Exception;
	int deleteCommentCnt(Integer review_no, int cnt)throws Exception;
	
	ReviewDTO selectReview(Integer content_no, Integer user_no)throws Exception;
	
	int count() throws Exception;

	List<ReviewDTO> selectAll() throws Exception;
//	List<CommentDTO> selectCommentsByBoard(??) throws Exception;
	
	//리플 페이지
	CommentDTO selectReply(Integer cmt_no) throws Exception;
	ReviewDTO replyReview(Integer content_no, Integer review_no) throws Exception;
	int replyCount(Integer review_no) throws Exception;
	List<CommentDTO> allreply(Integer review_no) throws Exception;
	int insertReply(CommentDTO commentDTO) throws Exception;
	int deleteReply(Integer cmt_no, int user_no)throws Exception;
}
