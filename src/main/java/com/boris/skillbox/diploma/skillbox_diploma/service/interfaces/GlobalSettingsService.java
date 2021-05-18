package com.boris.skillbox.diploma.skillbox_diploma.service.interfaces;

import com.boris.skillbox.diploma.skillbox_diploma.model.entity.GlobalSettings;

import java.util.List;
import java.util.Map;

public interface GlobalSettingsService {

    List<GlobalSettings> getAllGlobalSettings();

    void saveAll(Map<String, Boolean> settings);
}
