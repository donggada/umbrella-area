package com.example.umbrellaarea.umbrellaarea.umbrellaArea.service.Umbrella;

import com.example.umbrellaarea.umbrellaarea.umbrellaArea.dto.Umbrella.ReturnUmbrellaDto;
import com.example.umbrellaarea.umbrellaarea.umbrellaArea.dto.Umbrella.SaveUmbrellaDto;
import com.example.umbrellaarea.umbrellaarea.umbrellaArea.dto.Umbrella.UseUmbrellaDto;
import com.example.umbrellaarea.umbrellaarea.umbrellaArea.entity.Umbrella;
import com.example.umbrellaarea.umbrellaarea.umbrellaArea.entity.UmbrellaZone;
import com.example.umbrellaarea.umbrellaarea.umbrellaArea.repository.Umbrella.UmbrellaRepository;
import com.example.umbrellaarea.umbrellaarea.umbrellaArea.repository.UmbrellaZone.UmbrellaZoneRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UmbrellaService {
    private final UmbrellaRepository umbrellaRepository;
    private final UmbrellaZoneRepository umbrellaZoneRepository;

}
