package com.example.foyerspring.Schedular;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Slf4j
public class test {
@Scheduled(fixedRate = 100000)
    void affiche(){
        log.info("Bonjour");
    }

}
