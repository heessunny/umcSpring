package umc.spring.service.StoreService;


import umc.spring.domain.Store;
import umc.spring.web.dto.StoreRequestDTO;

import java.util.Optional;

public interface StoreCommandService {


    Store CreateStore(StoreRequestDTO.CreateDto request);

    Optional<Store> findStoreById(Long regionId);
}
