package com.petconnect.petconnect.services;

import com.petconnect.petconnect.Entities.Post;
import com.petconnect.petconnect.repositories.PostRepo;
import com.petconnect.petconnect.repositories.ServiceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class AdminService implements IAdminService{
    @Autowired
    private PostRepo postRepo;
    @Autowired
    private ServiceRepo serviceRepo;

    @Override
    public List<Post> getNonValidatedPosts() {
        return this.postRepo.findByValidatedFalse();
    }

    @Override
    public void validatePost(long idPost){
        Optional<Post> post= postRepo.findById(idPost);
        if(post.isPresent()){
            post.get().setValidated(true);
            postRepo.save(post.get());
        }
        else {
            throw new IllegalArgumentException("Post with: "+idPost+" not found!");
        }
    }

    @Override
    public List<com.petconnect.petconnect.Entities.Service> getNonValidatedServices() {
        return this.serviceRepo.findByValidatedFalse();
    }

    @Override
    public void validateService(long idService) {
        Optional<com.petconnect.petconnect.Entities.Service> service= serviceRepo.findById(idService);
        if(service.isPresent()){
            service.get().setValidated(true);
            serviceRepo.save(service.get());
        }
        else{
            throw new IllegalArgumentException("Service with: "+idService+" not found!");
        }

    }
}
