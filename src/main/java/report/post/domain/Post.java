package report.post.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
public class Post {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    private Client client;

    @NonNull
    private String title;

    @NonNull
    private String contents;

    private LocalDateTime createDate;

    @Builder
    public Post(Client client, @NonNull String title, @NonNull String contents) {
        this.client = client;
        this.title = title;
        this.contents = contents;
        this.createDate = LocalDateTime.now();
    }
}
