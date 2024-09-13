package com.greensphere.admin_portal_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;

import com.greensphere.admin_portal_service.model.SystemLogModel;
import com.greensphere.admin_portal_service.repository.SystemLogRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class SystemLogService {

    @Autowired
    private SystemLogRepository systemLogRepository;

    public void logAction(Long userId, String action, String details) {
        SystemLogModel log = new SystemLogModel();
        log.setUserId(userId);
        log.setAction(action);
        log.setDetails(details);
        log.setTimestamp(LocalDateTime.now());
        systemLogRepository.save(log);
    }

    public List<SystemLogModel> fetchAllLogs() {
        Pageable limit = PageRequest.of(0, 50, Sort.by(Sort.Direction.DESC, "id"));
        return systemLogRepository.findAll(limit).getContent();
    }
}
