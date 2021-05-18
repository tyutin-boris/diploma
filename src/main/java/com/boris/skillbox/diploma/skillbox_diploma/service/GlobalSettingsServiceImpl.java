package com.boris.skillbox.diploma.skillbox_diploma.service;

import com.boris.skillbox.diploma.skillbox_diploma.model.entity.GlobalSettings;
import com.boris.skillbox.diploma.skillbox_diploma.repository.GlobalSettingsRepository;
import com.boris.skillbox.diploma.skillbox_diploma.service.interfaces.GlobalSettingsService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
public class GlobalSettingsServiceImpl implements GlobalSettingsService {

    private final GlobalSettingsRepository repository;

    public GlobalSettingsServiceImpl(GlobalSettingsRepository repository) {
        this.repository = repository;
    }


    @Override
    public List<GlobalSettings> getAllGlobalSettings() {
        return repository.findAll();
    }

    @Override
    public void saveAll(Map<String, Boolean> settings) {
        List<GlobalSettings> allGlobalSettings = new CopyOnWriteArrayList<>(getAllGlobalSettings());
        allGlobalSettings.forEach(s -> s.setValue(settings.get(s.getCode())));
        repository.saveAll(allGlobalSettings);
    }
}
