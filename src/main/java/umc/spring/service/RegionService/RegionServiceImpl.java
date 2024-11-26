package umc.spring.service.RegionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.domain.Region;
import umc.spring.repository.RegionRepository.RegionRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RegionServiceImpl implements RegionService {

    private final RegionRepository regionRepository;


    @Override
    public Optional<Region> findRegionById(Long regionId) {
        return regionRepository.findById(regionId);
    }
}
