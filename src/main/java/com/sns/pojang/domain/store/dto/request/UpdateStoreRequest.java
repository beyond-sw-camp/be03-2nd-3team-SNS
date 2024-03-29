package com.sns.pojang.domain.store.dto.request;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotEmpty;

@Data
public class UpdateStoreRequest {
    @NotEmpty(message = "가게상호명을 입력하시오.")
    private String name;
    @NotEmpty(message = "카테고리를 선택하시오.")
    private String category;
    @NotEmpty(message = "매장전화번호는 비어있으면 안됩니다.")
    private String storeNumber;
    @NotEmpty(message = "운영시간은 비어있으면 안됩니다.")
    private String operationTime;
    private String introduction;
}
