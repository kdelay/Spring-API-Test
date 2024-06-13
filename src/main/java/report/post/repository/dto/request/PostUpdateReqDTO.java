package report.post.repository.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

@Getter
@Schema(description = "게시글 수정 DTO")
public class PostUpdateReqDTO {

    @Schema(description = "비밀번호", example = "1111")
    private String password;

    @Schema(description = "제목", example = "제목 수정")
    private String title;

    @Schema(description = "작성자명", example = "AAA")
    private String clientName;

    @Schema(description = "작성 내용", example = "내용 수정")
    private String contents;
}
