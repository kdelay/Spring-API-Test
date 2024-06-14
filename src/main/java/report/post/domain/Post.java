package report.post.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Post {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String contents;

    private LocalDateTime createAt;
    private LocalDateTime modifiedAt;

    public Post(String username, String password, String title, String contents) {
        this.username = username;
        this.password = password;
        this.title = title;
        this.contents = contents;
        craeteDate();
    }

    private void craeteDate() {
        this.createAt = LocalDateTime.now();
        this.modifiedAt = LocalDateTime.now();
    }

    public Post(String username, String title, String contents) {
        this.username = username;
        this.title = title;
        this.contents = contents;
    }
}
