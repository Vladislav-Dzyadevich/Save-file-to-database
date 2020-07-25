package com.company.service;

import com.company.dto.MusicDto;
import com.company.entity.Music;
import com.company.repository.MusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MusicServiceImpl implements MusicService {
    @Autowired
    private MusicRepository musicRepository;
    @Override
    public void addMusic(MusicDto musicDto) {
        Music music = new Music();
        music.setName(musicDto.getName());
        music.setAuthor(musicDto.getAuthor());
        music.setGenre(musicDto.getGenre());
        musicRepository.save(music);
    }

    @Override
    public List<Music> showMusic() {
        return musicRepository.findAll();
    }
}
