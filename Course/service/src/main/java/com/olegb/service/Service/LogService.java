package com.olegb.service.Service;

import com.olegb.service.Model.Log;
import com.olegb.service.Repository.LogRepository;
import com.olegb.service.Service.Contracts.ILogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogService implements ILogService {

    @Autowired
    private LogRepository logRepository;

    @Override
    public List<Log> getAllLogs(){

        return logRepository.findAll();
    }
    @Override
    public void deleteLog(){
      logRepository.deleteAll();
    }

}
