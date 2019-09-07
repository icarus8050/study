package com.example.transactionalex;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

@Service
@Slf4j
public class AService {

    @Transactional
    public String simpleA() {
        log.info("Current Transactional name : " + TransactionSynchronizationManager.getCurrentTransactionName());
        simpleA_sub();
        return "simpleA";
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW, timeout = 100)
    void simpleA_sub() {
        log.info("Current Transactional name : " + TransactionSynchronizationManager.getCurrentTransactionName());
    }
}
