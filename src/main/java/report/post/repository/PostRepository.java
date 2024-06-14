package report.post.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import report.post.domain.Post;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findAllByOrderByCreateAtDesc();
}
