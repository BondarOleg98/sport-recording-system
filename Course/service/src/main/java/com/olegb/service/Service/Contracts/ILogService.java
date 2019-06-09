package com.olegb.service.Service.Contracts;

import com.olegb.service.Model.Log;

import java.util.List;

public interface ILogService {
    List<Log> getAllLogs();
    void deleteLog();
}
