package com.commets.micro.service.commets_micro_service.Aplicacion.casosDeUso;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.commets.micro.service.commets_micro_service.Aplicacion.puertos.in.ToogleLikeUseCase;
import com.commets.micro.service.commets_micro_service.Aplicacion.puertos.out.CommentRepository;
import com.commets.micro.service.commets_micro_service.Aplicacion.puertos.out.LikeRepository;
import com.commets.micro.service.commets_micro_service.Dominio.entidades.Like;

@Service
public class LikeServiceImpl implements ToogleLikeUseCase{

    private final LikeRepository likeRepo; private final CommentRepository cmtRepo;
    public LikeServiceImpl(LikeRepository l, CommentRepository c){likeRepo=l;cmtRepo=c;}

    @Override @Transactional
    public boolean ejecutarToogle(Long usr, Long cmt){
        boolean exists = likeRepo.find(cmt,usr).isPresent();
        if(exists){
            likeRepo.delete(cmt,usr); cmtRepo.updateLikeCount(cmt,-1); return false;
        }else{
            likeRepo.save(new Like(cmt,usr)); cmtRepo.updateLikeCount(cmt,1); return true;
        }
    }
}

