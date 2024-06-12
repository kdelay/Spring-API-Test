package report.post.repository.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import report.post.domain.Client;
import report.post.domain.Post;

@Getter
@Schema(description = "게시글 작성 DTO")
public class PostingSaveReqDTO {

    @Schema(description = "제목", example = "제목", required = true)
    private String title;

    @Schema(description = "작성 내용", example = "내용", required = true)
    private String contents;

    @Schema(description = "작성자명", example = "A", required = true)
    private String name;

    @Schema(description = "비밀번호", example = "1234", required = true)
    private String password;

    @Builder
    public PostingSaveReqDTO(String title, String contents, String name, String password) {
        this.title = title;
        this.contents = contents;
        this.name = name;
        this.password = password;
    }

    public Post toEntity(Client client) {
        return Post.builder()
                .client(client)
                .title(title)
                .contents(contents)
                .build();
    }
}
