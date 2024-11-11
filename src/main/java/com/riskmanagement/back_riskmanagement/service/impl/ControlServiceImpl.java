package com.riskmanagement.back_riskmanagement.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.riskmanagement.back_riskmanagement.dto.model.Control;
import com.riskmanagement.back_riskmanagement.dto.request.ControlRequest;
import com.riskmanagement.back_riskmanagement.dto.response.ControlResponse;
import com.riskmanagement.back_riskmanagement.entity.ControlEntity;
import com.riskmanagement.back_riskmanagement.entity.RoleEntity;
import com.riskmanagement.back_riskmanagement.entity.StatusEntity;
import com.riskmanagement.back_riskmanagement.entity.UserEntity;
import com.riskmanagement.back_riskmanagement.exception.codes.ExceptionCodesRiskManagementDatabase;
import com.riskmanagement.back_riskmanagement.exception.riskmanagement.ControlException;
import com.riskmanagement.back_riskmanagement.exception.riskmanagement.UserException;
import com.riskmanagement.back_riskmanagement.repository.ControlRepository;
import com.riskmanagement.back_riskmanagement.repository.StatusRepository;
import com.riskmanagement.back_riskmanagement.repository.UserRepository;
import com.riskmanagement.back_riskmanagement.service.interfaces.ControlService;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class ControlServiceImpl implements ControlService {

    private final ControlRepository controlRepository;
    private final StatusRepository statusRepository;
    private final UserRepository userRepository;

    @Override
    public List<ControlResponse> findAll() {
        return controlRepository.findAll().stream()
                .map(controlEntity -> {
                    UserEntity user = userRepository.findById(controlEntity.getUserId().getUserId())
                            .orElseThrow(() -> new EntityNotFoundException("User no encontrado"));
                    StatusEntity status = statusRepository.findById(controlEntity.getStatusId().getStatusId())
                            .orElseThrow(() -> new EntityNotFoundException("Status no encontrado"));

                    Control control = Control.toModel(controlEntity);
                    return Control.toResponse(control,user.getName() ,status.getStatusName());
                })
                .collect(Collectors.toList());

    }


    @Override
    public ControlResponse findControlById(Integer id) {
        try{
            ControlEntity controlEntity = controlRepository.findById(id)
                    .orElseThrow(() -> new ControlException(ExceptionCodesRiskManagementDatabase.DB_RISK_MANAGEMENT_023, null));
            UserEntity user = userRepository.findById(controlEntity.getUserId().getUserId())
                    .orElseThrow(() -> new UserException(ExceptionCodesRiskManagementDatabase.DB_RISK_MANAGEMENT_011, null));
            StatusEntity status = statusRepository.findById(controlEntity.getStatusId().getStatusId())
                    .orElseThrow(() -> new EntityNotFoundException("Status no encontrado"));

            Control control = Control.toModel(controlEntity);
            return Control.toResponse(control,user.getName() , status.getStatusName());

        }catch(ControlException e){
            throw new ControlException(ExceptionCodesRiskManagementDatabase.DB_RISK_MANAGEMENT_023, e.getMessage());
        }

    }

    @Override
    public ControlResponse create(ControlRequest controlRequest) {

        Control controlToCreate = Control.toModel(controlRequest);

        UserEntity user = userRepository.findById(controlToCreate.getUserId())
                .orElseThrow(() -> new EntityNotFoundException("User no encontrado"));
        StatusEntity status = statusRepository.findById(controlToCreate.getStatusId())
                .orElseThrow(() -> new EntityNotFoundException("Status no encontrado"));

        ControlEntity controlEntity =  Control.toEntity(controlToCreate,user, status);

        ControlEntity savedEntity = controlRepository.save(controlEntity);

        Control controlCreated = Control.toModel(savedEntity);

        return Control.toResponse(controlCreated, user.getName(),status.getStatusName());
    }

    @Override
    public ControlResponse update(Integer id, ControlRequest controlRequest) {

        ControlEntity existingControlEntity = controlRepository.findById(id)
                .orElseThrow(() -> new ControlException(ExceptionCodesRiskManagementDatabase.DB_RISK_MANAGEMENT_009, "Usuario no encontrado"));

        UserEntity user = userRepository.findById(controlRequest.getUserId())
                .orElseThrow(() -> new EntityNotFoundException("User no encontrado"));
        StatusEntity status = statusRepository.findById(controlRequest.getStatusId())
                .orElseThrow(() -> new EntityNotFoundException("Status no encontrado"));

        Control control = Control.toModel(controlRequest);
        ControlEntity updatedEntity = Control.toEntity(control,user,status);


        // actualizar(guardar) la nueva instancia en el repositorio
        updatedEntity = controlRepository.save(updatedEntity);

        Control controlUpdated = Control.toModel(updatedEntity);
        return Control.toResponse(controlUpdated,user.getName(),status.getStatusName());
    }

    @Override
    public ControlResponse delete(Integer id) {
        ControlEntity controlEntity = controlRepository.findById(id)
                .orElseThrow(() -> new ControlException(ExceptionCodesRiskManagementDatabase.DB_RISK_MANAGEMENT_010, "Usuario no encontrado"));

        controlRepository.delete(controlEntity);

        UserEntity user = controlEntity.getUserId();
        StatusEntity status = controlEntity.getStatusId();
        Control controlDeleted = Control.toModel(controlEntity);
        return Control.toResponse(controlDeleted,user.getName(), status.getStatusName());

    }

}
