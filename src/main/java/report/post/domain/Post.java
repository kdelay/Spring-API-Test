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
    private String clientName;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String contents;

    private LocalDateTime createDate;

    public Post(String clientName, String password, String title, String contents) {
        this.clientName = clientName;
        this.password = password;
        this.title = title;
        this.contents = contents;
        this.createDate = LocalDateTime.now();
    }

    public Post(String clientName, String title, String contents) {
        this.clientName = clientName;
        this.title = title;
        this.contents = contents;
    }
}
