package com.company.project.service.impl;

import com.company.project.dao.RawdataMapper;
import com.company.project.model.Rawdata;
import com.company.project.service.RawdataService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2019/01/05.
 */
@Service
@Transactional
public class RawdataServiceImpl extends AbstractService<Rawdata> implements RawdataService {
    @Resource
    private RawdataMapper rawdataMapper;

}
