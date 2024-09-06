package ru.anyline.resttdl.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.anyline.resttdl.DTO.DeveloperDTO;
import ru.anyline.resttdl.mapper.DeveloperMapper;
import ru.anyline.resttdl.model.Developer;
import ru.anyline.resttdl.repository.DeveloperRepo;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class DeveloperServiceImpl {

    private final DeveloperRepo developerRepo;

    public List<DeveloperDTO> findAll() {
        return developerRepo.findAll()
                .stream()
                .map(DeveloperMapper.INSTANCE::toDeveloperDTO)
                .collect(Collectors.toList());
    }

    public Optional<DeveloperDTO> findById(Long id) {
        return developerRepo.findById(id)
                .map(DeveloperMapper.INSTANCE::toDeveloperDTO);
    }

    public DeveloperDTO save(DeveloperDTO developerDTO) {
        Developer developer = DeveloperMapper.INSTANCE.toDeveloper(developerDTO);
        return DeveloperMapper.INSTANCE.toDeveloperDTO(developerRepo.save(developer));
    }

    public void deleteById(Long id) {
        developerRepo.deleteById(id);
    }
}
