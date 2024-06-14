package report.post.repository.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder @AllArgsConstructor
@Schema(description = "게시글 선택 조회 DTO")
public class PostSelectResDTO {

    @Schema(description = "id")
    private Long id;

    @Schema(description = "제목")
    private String title;

    @Schema(description = "작성 내용")
    private String contents;

    @Schema(description = "작성자명")
    private String username;

    @Schema(description = "작성 날짜")
    private LocalDateTime createAt;

    @Schema(description = "수정 날짜")
    private LocalDateTime modifiedAt;
}
