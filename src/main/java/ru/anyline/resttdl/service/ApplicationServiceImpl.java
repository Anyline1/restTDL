package ru.anyline.resttdl.service;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.anyline.resttdl.DTO.ApplicationDTO;
import ru.anyline.resttdl.mapper.ApplicationMapper;
import ru.anyline.resttdl.model.Application;
import ru.anyline.resttdl.repository.ApplicationRepo;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@AllArgsConstructor
@Service
public class ApplicationServiceImpl implements ApplicationService{

    private final ApplicationRepo applicationRepo;

    @Override
    public List<ApplicationDTO> findAll() {
        return applicationRepo.findAll()
                .stream()
               .map(ApplicationMapper.INSTANCE::toApplicationDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<ApplicationDTO> findById(Long id) {
        return applicationRepo.findById(id)
                .map(ApplicationMapper.INSTANCE::toApplicationDTO);
    }

    @Override
    public ApplicationDTO save(ApplicationDTO applicationDTO) {
        Application application = ApplicationMapper.INSTANCE.toApplication(applicationDTO);
        return ApplicationMapper.INSTANCE.toApplicationDTO(applicationRepo.save(application));
    }

    @Override
    public void deleteById(Long id) {
        applicationRepo.deleteById(id);
    }
}
