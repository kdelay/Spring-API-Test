package report.post.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import report.post.domain.Client;
import report.post.domain.Post;
import report.post.repository.ClientRepository;
import report.post.repository.PostRepository;
import report.post.repository.dto.PostingSaveReqDTO;

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
    public Post save(PostingSaveReqDTO postingSaveReqDTO) {
        //게시글 저장할 때 client 함께 저장
        Post post = postingSaveReqDTO.toEntity(saveClient(postingSaveReqDTO));
        return postRepository.save(post);
    }

    private Client saveClient(PostingSaveReqDTO postingSaveReqDTO) {
        Client client = new Client(postingSaveReqDTO.getName(), postingSaveReqDTO.getPassword());
        clientRepository.save(client);
        return client;
    }

}
