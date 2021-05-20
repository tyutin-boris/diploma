package com.boris.skillbox.diploma.skillbox_diploma.service;

import com.boris.skillbox.diploma.skillbox_diploma.model.entity.GlobalSettings;
import com.boris.skillbox.diploma.skillbox_diploma.repository.GlobalSettingsRepository;
import com.boris.skillbox.diploma.skillbox_diploma.service.interfaces.GlobalSettingsService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

@Service
public class GlobalSettingsServiceImpl implements GlobalSettingsService {

    private final GlobalSettingsRepository repository;

    public GlobalSettingsServiceImpl(GlobalSettingsRepository repository) {
        this.repository = repository;
    }


    @Override
    public List<GlobalSettings> findAllGlobalSettings() {
        return repository.findAll();
    }

    @Override
    public void saveAll(Map<String, Boolean> settings) {
        List<GlobalSettings> allGlobalSettings = new CopyOnWriteArrayList<>(findAllGlobalSettings());
        allGlobalSettings.forEach(s -> s.setValue(settings.get(s.getCode())));
        repository.saveAll(allGlobalSettings);
    }

    @Override
    public Map<String, Boolean> getAllGlobalSettings() {
        return repository.findAll().stream()
                .collect(Collectors.toMap(GlobalSettings::getCode, GlobalSettings::isValue));
    }
}
