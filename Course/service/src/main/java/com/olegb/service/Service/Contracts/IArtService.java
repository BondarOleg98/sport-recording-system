package com.olegb.service.Service.Contracts;

import com.olegb.service.Model.ArtStyle;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface IArtService {
    List<ArtStyle> getAllArts();
    ArtStyle createArt(ArtStyle artStyle);
    ArtStyle OneArt(UUID id);
    ArtStyle replaceArt(ArtStyle newArt, UUID id);
    Map<String, Boolean> deleteArt(UUID id);
}
