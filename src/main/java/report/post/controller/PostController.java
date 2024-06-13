package report.post.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import report.post.domain.Post;
import report.post.repository.dto.request.PostSaveReqDTO;
import report.post.repository.dto.request.PostUpdateReqDTO;
import report.post.repository.dto.response.PostSelectResDTO;
import report.post.service.PostService;

import java.util.List;

@Tag(name = "posting", description = "게시물 관련 API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/posting")
public class PostController {

    private final PostService postService;

    @Operation(summary = "모든 게시글 조회", description = "모든 게시글을 조회합니다.")
    @ApiResponse(responseCode = "200", description = "Success",
                content = {@Content(schema = @Schema(implementation = List.class))})
    @GetMapping("/all")
    public List<Post> all() {
        return postService.all();
    }

    @Operation(summary = "게시글 작성", description = "게시글을 작성합니다.")
    @PostMapping
    public Post save(@RequestBody PostSaveReqDTO postSaveReqDTO) {
        return postService.save(postSaveReqDTO);
    }

    @Operation(summary = "선택 게시글 조회", description = "선택한 게시글을 조회합니다.")
    @GetMapping("/{postId}")
    public PostSelectResDTO select(@RequestParam Long postId) {
        return postService.select(postId);
    }

    @Operation(summary = "선택 게시글 수정", description = "선택한 게시글을 수정합니다.")
    @PutMapping("/{postId}")
    public Post update(@RequestParam Long postId, @RequestBody PostUpdateReqDTO postUpdateReqDTO) {
        return postService.update(postId, postUpdateReqDTO);
    }
}