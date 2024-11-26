package umc.spring.converter;

import umc.spring.domain.Store;
import umc.spring.web.dto.StoreRequestDTO;
import umc.spring.web.dto.StoreResponseDTO;

import java.time.LocalDateTime;

public class StoreConverter {

    public static StoreResponseDTO.CreateResultDTO toCreateDTO(Store store) {

        return StoreResponseDTO.CreateResultDTO.builder()
                .storeId(store.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }


    public static Store toStore(StoreRequestDTO.CreateDto request) {

        return Store.builder()
                .name(request.getName())
                .address(request.getAddress())
                .build();
    }
}
