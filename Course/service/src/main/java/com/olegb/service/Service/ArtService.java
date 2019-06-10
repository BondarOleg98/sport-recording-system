package com.olegb.service.Service;

import com.olegb.service.Controller.NotFoundException;
import com.olegb.service.Model.ArtStyle;
import com.olegb.service.Model.Coach;
import com.olegb.service.Model.Student;
import com.olegb.service.Repository.ArtRepository;
import com.olegb.service.Repository.CoachRepository;
import com.olegb.service.Repository.StudentRepository;
import com.olegb.service.Service.Contracts.IArtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ArtService implements IArtService {

    @Autowired
    private ArtRepository artRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CoachRepository coachRepository;

    @Override
    public List<ArtStyle> getAllArts(){
        List<ArtStyle> artStyles = artRepository.findAll();
        return artStyles;
    }

    @Override
    public ArtStyle createArt(ArtStyle artStyle){
        UUID uuid = UUID.randomUUID();
        artStyle.setId(uuid);
        return artRepository.save(artStyle);
    }

    @Override
    public ArtStyle OneArt(UUID id) {
        return artRepository.findById(id).orElseThrow(() -> new NotFoundException("art", id));
    }

    @Override
    public ArtStyle replaceArt(ArtStyle newArt, UUID id) {

        return artRepository.findById(id)
                .map(art -> {
                    art.setName(newArt.getName());
                    return artRepository.save(art);
                }).orElseGet(() -> {
                    newArt.setId(id);
                    return artRepository.save(newArt);
                });

    }
    @Override
    public Map<String, Boolean> deleteArt(UUID id) {
        Map<String, Boolean>response = new HashMap<>();
        if(!artRepository.findById(id).isPresent()){
            response.put("Error 404: art not found",Boolean.FALSE);
            return response;
        } else {
            for (Student student:studentRepository.findAll()) {
                if(student.getArtStyle()!=null){
                    if(student.getArtStyle().getId().toString().equals(id.toString())){
                        student.setArtStyle(null);
                    }
                }

            }
            for (Coach coach:coachRepository.findAll()) {
                if(coach.getArtStyle()!=null){
                    if(coach.getArtStyle().getId().toString().equals(id.toString())){
                        coach.setArtStyle(null);
                    }
                }

            }
            artRepository.deleteById(id);
            response.put("Boolean",Boolean.TRUE);
            return response;
        }
    }
}
