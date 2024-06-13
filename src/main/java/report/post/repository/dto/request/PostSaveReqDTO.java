package report.post.repository.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

@Getter
@Schema(description = "게시글 작성 DTO")
public class PostSaveReqDTO {

    @Schema(description = "제목", example = "제목", required = true)
    private String title;

    @Schema(description = "작성 내용", example = "내용", required = true)
    private String contents;

    @Schema(description = "작성자명", example = "A", required = true)
    private String clientName;

    @Schema(description = "비밀번호", example = "1111", required = true)
    private String password;

    public PostSaveReqDTO(String title, String contents, String clientName, String password) {
        this.title = title;
        this.contents = contents;
        this.clientName = clientName;
        this.password = password;
    }
}
