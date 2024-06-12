package report.post.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @NoArgsConstructor
public class Client {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "client")
    private List<Post> postList = new ArrayList<>();

    @NonNull
    private String name;

    @NonNull
    private String password;

    public Client(@NonNull String name, @NonNull String password) {
        this.name = name;
        this.password = password;
    }
}