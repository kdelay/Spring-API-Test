package report.post.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import report.post.domain.Client;
import report.post.domain.Post;
import report.post.repository.ClientRepository;
import report.post.repository.PostRepository;
import report.post.repository.dto.request.PostSaveReqDTO;
import report.post.repository.dto.response.PostSelectResDTO;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final ClientRepository clientRepository;

    @Transactional
    public List<Post> all() {
        return postRepository.findAllByOrderByCreateDateDesc();
    }

    @Transactional
    public Post save(PostSaveReqDTO postSaveReqDTO) {

        if (clientRepository.findByName(postSaveReqDTO.getName()).isPresent()) {
            throw new IllegalArgumentException("이미 등록된 유저입니다.");
        }
        Client client = new Client(postSaveReqDTO.getName(), postSaveReqDTO.getPassword());
        clientRepository.save(client);

        return postRepository.save(postSaveReqDTO.toEntity(client));
    }

    @Transactional
    public PostSelectResDTO select(Long postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("선택한 게시글이 없습니다."));
        return new PostSelectResDTO(post.getTitle(), post.getClient().getName(), post.getCreateDate(), post.getContents());
    }
}
