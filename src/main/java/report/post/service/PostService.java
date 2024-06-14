package report.post.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import report.post.domain.Post;
import report.post.repository.PostRepository;
import report.post.repository.dto.response.PostSelectResDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    @Transactional
    public List<PostSelectResDTO> all() {
        List<Post> allList = postRepository.findAllByOrderByCreateAtDesc();
        return allList.stream()
                .map(post -> {
                    return PostSelectResDTO.builder()
                            .id(post.getId())
                            .title(post.getTitle())
                            .contents(post.getContents())
                            .username(post.getUsername())
                            .createAt(post.getCreateAt())
                            .modifiedAt(post.getModifiedAt())
                            .build();
                })
                .collect(Collectors.toList());
    }

//    @Transactional
//    public Post save(PostSaveReqDTO dto) {
//        return postRepository.save(new Post(dto.getClientName(), dto.getPassword(), dto.getTitle(), dto.getContents()));
//    }
//
//    @Transactional
//    public PostSelectResDTO select(Long postId) {
//        Post post = getPostById(postId);
//        return new PostSelectResDTO(post.getTitle(), post.getUsername(), post.getCreateAt(), post.getContents());
//    }
//
//    @Transactional
//    public Post update(Long postId, PostUpdateReqDTO dto) {
//        Post post = getPostById(postId);
//
//        if (isEqualPassword(post, dto.getPassword())) {
//            post.setUsername(dto.getClientName());
//            post.setTitle(dto.getTitle());
//            post.setContents(dto.getContents());
//        }
//        return post;
//    }
//
//    @Transactional
//    public String delete(Long postId, String password) {
//        Post post = getPostById(postId);
//
//        if (isEqualPassword(post, password)) {
//            postRepository.deleteById(postId);
//            postRepository.flush();
//        }
//
//        if (postRepository.findById(postId).isEmpty()) {
//            return "게시글을 삭제했습니다.";
//        } else return "게시글 삭제 실패";
//    }
//
//    private Post getPostById(Long postId) {
//        return postRepository.findById(postId)
//                .orElseThrow(() -> new IllegalArgumentException("선택한 게시글이 없습니다."));
//    }
//
//    private boolean isEqualPassword(Post post, String password) {
//        if (post.getPassword().equals(password)) {
//            return true;
//        } else throw new IllegalArgumentException("비밀번호가 틀립니다.");
//    }
}
