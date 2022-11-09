package sjht.erp.board.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import sjht.erp.board.dto.BoardResponse;
import sjht.erp.board.service.BoardService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    // 게시글 리스트
    @GetMapping("/board/list.do")
    public String boardlist() {
        return "/board/list";
    }

    // 게시글 리스트
    @PostMapping("/board/list.do")
    @ResponseBody
    public List<BoardResponse> boardList() {
        List<BoardResponse> response = boardService.boardList();
        return response;
    }

    // 게시글 상세 페이지
    @GetMapping("/board/detail.do")
    public String boarddetail(HttpServletRequest request, @RequestParam("bno") int bno) {
        request.setAttribute("bno", bno);
        return "/board/detail";
    }

    // 게시글 상세 페이지
    @PostMapping("/board/detail.do")
    @ResponseBody
    public BoardResponse boardDetail(HttpServletRequest request) {
        request.getAttribute("empNo");
        int bno = (int) request.getAttribute("bno");
        System.out.println(bno);
        BoardResponse response = boardService.boardDetail(bno);
        return response;
    }

}