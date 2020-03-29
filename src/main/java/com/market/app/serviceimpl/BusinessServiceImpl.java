package com.market.app.serviceimpl;

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;
import com.market.app.dto.BusinessDto;
import com.market.app.dto.BusinessUpdateDto;
import com.market.app.model.Business;
import com.market.app.repository.BusinessRepository;
import com.market.app.service.BusinessService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.util.NumberUtils;

import javax.inject.Inject;
import java.time.LocalDateTime;

@Component
public class BusinessServiceImpl implements BusinessService {
    @Inject
    BusinessRepository businessRepository;

    @Inject
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public Business createBusiness(BusinessDto dto) {
        Business newBusinessAccount = new Business();
        LocalDateTime createdDate = LocalDateTime.now();
        newBusinessAccount.setBusinessName(dto.getBusinessName().trim());
        newBusinessAccount.setBusinessAddress(dto.getBusinessAddress());
        newBusinessAccount.setBusinessEmail(dto.getBusinessEmail().trim());
        PhoneNumberUtil phoneUtil = PhoneNumberUtil.getInstance();
        try {
            Phonenumber.PhoneNumber phoneNumber = phoneUtil.parse(dto.getPhoneNumber().trim(), "NGR");
            newBusinessAccount.setPhoneNumber(phoneUtil.format(phoneNumber, PhoneNumberUtil.PhoneNumberFormat.INTERNATIONAL));
        } catch (NumberParseException e) {
            logger.error(e.getMessage());
        }
        portalUser.setEmail(userDto.getEmail().trim());
        portalUser.setDateCreated(LocalDateTime.now());
        portalUser.setPassword(bCryptPasswordEncoder.encode(userDto.getPassword().trim()));
        portalUser.setResetPassword(userDto.isResetPassword());
        newBusinessAccount.setPhoneNumber(NumberUtils.);
        newBusinessAccount.setCreatedDate(createdDate.toString());
        newBusinessAccount.setLastUpdate(createdDate.toString());
        businessRepository.save(newBusinessAccount);
        return newBusinessAccount;
    }

    @Override
    public Business updateBusinessDetail(BusinessUpdateDto updateDto) {
        return null;
    }
}
