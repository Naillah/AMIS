package com.minagri.amis.services;

import com.minagri.amis.dto.OrganizationDTO;
import com.minagri.amis.dto.PersonDTO;
import com.minagri.amis.models.UserEntity;
import com.minagri.amis.repositories.UserEntityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserEntityRepo userEntityRepo;

    @Autowired
    public UserService(UserEntityRepo userEntityRepo) {
        this.userEntityRepo = userEntityRepo;
    }

    public UserEntity registerPerson(PersonDTO personDTO) {
        validateUniqueFields(personDTO.getIdentificationDocNumber(), personDTO.getEmail(), personDTO.getPhone());

        UserEntity userEntity = mapPersonDtoToEntity(personDTO);
        userEntity.setType("person");
        userEntity.setStatus("active");
        return userEntityRepo.save(userEntity);
    }

    public UserEntity registerOrganization(OrganizationDTO organizationDTO) {
        validateUniqueFields(organizationDTO.getIdentificationDocNumber(), organizationDTO.getEmail(), organizationDTO.getPhone());

        UserEntity userEntity = mapOrganizationDtoToEntity(organizationDTO);
        userEntity.setType("organization");
        userEntity.setStatus("active");
        return userEntityRepo.save(userEntity);
    }

    private void validateUniqueFields(String idNumber, String email, String phone) {
        if (userEntityRepo.existsByIdentificationDocNumber(idNumber)) {
            throw new IllegalArgumentException("User with the same identification document number already exists");
        }
        if (userEntityRepo.existsByEmail(email)) {
            throw new IllegalArgumentException("User with the same email already exists");
        }
        if (userEntityRepo.existsByPhone(phone)) {
            throw new IllegalArgumentException("User with the same phone number already exists");
        }
    }

    private UserEntity mapPersonDtoToEntity(PersonDTO personDTO) {
        UserEntity userEntity = new UserEntity();
        userEntity.setFirstname(personDTO.getFirstname());
        userEntity.setLastname(personDTO.getLastname());
        userEntity.setIdentificationDocType(personDTO.getIdentificationDocType());
        userEntity.setIdentificationDocNumber(personDTO.getIdentificationDocNumber());
        userEntity.setAddress(personDTO.getAddress());
        userEntity.setEmail(personDTO.getEmail());
        userEntity.setPhone(personDTO.getPhone());
        return userEntity;
    }

    private UserEntity mapOrganizationDtoToEntity(OrganizationDTO organizationDTO) {
        UserEntity userEntity = new UserEntity();
        userEntity.setName(organizationDTO.getName());
        userEntity.setIdentificationDocType(organizationDTO.getIdentificationDocType());
        userEntity.setIdentificationDocNumber(organizationDTO.getIdentificationDocNumber());
        userEntity.setAddress(organizationDTO.getAddress());
        userEntity.setEmail(organizationDTO.getEmail());
        userEntity.setPhone(organizationDTO.getPhone());
        return userEntity;
    }
}
