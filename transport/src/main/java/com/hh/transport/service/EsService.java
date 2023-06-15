package com.hh.transport.service;

import com.hh.transport.domain.dto.TransportDTO;

public interface EsService {

    int saveEs();
    TransportDTO query();

}
