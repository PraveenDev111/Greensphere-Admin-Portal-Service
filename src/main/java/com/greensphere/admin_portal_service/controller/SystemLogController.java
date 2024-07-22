package com.greensphere.admin_portal_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greensphere.admin_portal_service.model.SystemLogModel;
import com.greensphere.admin_portal_service.service.SystemLogService;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping(value = "/api/v1/admin/systemlogs")
public class SystemLogController {

    @Autowired
    SystemLogService systemlogrepo;

    @GetMapping(value = "/", produces = "application/json")
    public ResponseEntity<List<SystemLogModel>> fetchAll() {
        List<SystemLogModel> allLogs = systemlogrepo.fetchAllLogs();
        return new ResponseEntity<>(allLogs, HttpStatus.OK);
    }

}
