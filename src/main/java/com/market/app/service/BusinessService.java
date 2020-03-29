package com.market.app.service;

import com.market.app.dto.BusinessDto;
import com.market.app.dto.BusinessUpdateDto;
import com.market.app.model.Business;
import org.springframework.stereotype.Service;

@Service
public interface BusinessService {
     Business createBusiness(BusinessDto dto);

     Business updateBusinessDetail(BusinessUpdateDto updateDto);
}
