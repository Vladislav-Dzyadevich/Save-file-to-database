package com.company.service;

import com.company.dto.MusicDto;
import com.company.entity.Music;

import java.util.List;

public interface MusicService {
    void addMusic(MusicDto musicDto);
    List<Music> showMusic();
}
