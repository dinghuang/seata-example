package io.seata.sample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * @author dinghuang123@gmail.com
 * @date 2019/06/14
 */
@Service
public class StorageService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional(rollbackOn = Exception.class)
    public void deduct(String commodityCode, int count) {
        jdbcTemplate.update("update storage_tbl set count = count - ? where commodity_code = ?",
            new Object[] {count, commodityCode});
    }
}
