package com.olegb.service.Controller;

import com.olegb.service.Model.ArtStyle;
import com.olegb.service.Model.Coach;
import com.olegb.service.Model.Student;
import com.olegb.service.Service.ArtService;
//import com.olegb.service.Service.CoachService;
//import com.olegb.service.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/art")
public class ArtController {

    @Autowired
    private ArtService artService;


    @GetMapping
    public List<ArtStyle> getAllArts(){
        return artService.getAllArts();
    }

    @PostMapping("/create")
    public ArtStyle createArt(@RequestBody @Valid ArtStyle art){

        return artService.createArt(art);

    }
    @GetMapping("/{id}")
    public ArtStyle OneArt(@PathVariable UUID id) {

        return artService.OneArt(id);
    }
    @PostMapping("update/{id}")
    public ArtStyle replaceArt(@RequestBody @Valid ArtStyle newArt, @PathVariable UUID id) {

        return artService.replaceArt(newArt, id);
    }

    @GetMapping("delete/{id}")
    public void deleteArt(@PathVariable UUID id) {
        artService.deleteArt(id);
    }
}
