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

        if (clientRepository.findByName(postingSaveReqDTO.getName()).isPresent()) {
            throw new IllegalArgumentException("이미 등록된 유저입니다.");
        }
        Client client = new Client(postingSaveReqDTO.getName(), postingSaveReqDTO.getPassword());
        clientRepository.save(client);

        return postRepository.save(postingSaveReqDTO.toEntity(client));
    }
}
