package report.post.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import report.post.repository.dto.response.PostSelectResDTO;
import report.post.service.PostService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Tag(name = "posting", description = "게시물 관련 API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/posts")
public class PostController {

    private final PostService postService;

    @Operation(summary = "전체 게시글 목록 조회")
    @GetMapping
    public Map<String, List<PostSelectResDTO>> all() {
        Map<String, List<PostSelectResDTO>> response = new HashMap<>();
        response.put("postList", postService.all());
        return response;
    }

//    @Operation(summary = "게시글 작성", description = "게시글을 작성합니다.")
//    @PostMapping
//    public Post save(@RequestBody PostSaveReqDTO postSaveReqDTO) {
//        return postService.save(postSaveReqDTO);
//    }
//
//    @Operation(summary = "선택 게시글 조회", description = "선택한 게시글을 조회합니다.")
//    @GetMapping("/{postId}")
//    public PostSelectResDTO select(@PathVariable Long postId) {
//        return postService.select(postId);
//    }
//
//    @Operation(summary = "선택 게시글 수정", description = "선택한 게시글을 수정합니다.")
//    @PatchMapping("/{postId}")
//    public Post update(@PathVariable Long postId, @RequestBody PostUpdateReqDTO postUpdateReqDTO) {
//        return postService.update(postId, postUpdateReqDTO);
//    }
//
//    @Operation(summary = "선택 게시글 삭제", description = "선택한 게시글을 삭제합니다.")
//    @DeleteMapping("/{postId}")
//    public String delete(@PathVariable Long postId, String password) {
//        try {
//            return postService.delete(postId, password);
//        } catch (IllegalArgumentException e) {
//            return e.getMessage();
//        }
//    }
}