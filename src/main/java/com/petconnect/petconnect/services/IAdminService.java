package com.petconnect.petconnect.services;

import com.petconnect.petconnect.Entities.Post;
import com.petconnect.petconnect.Entities.Service;

import java.util.List;

public interface IAdminService {
    public List<Post> getNonValidatedPosts();
    public void validatePost(long idPost);
    public List<Service> getNonValidatedServices();
    public void  validateService(long idService);
}
