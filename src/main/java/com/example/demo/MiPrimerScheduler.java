package com.example.demo;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MiPrimerScheduler {

    @Scheduled(cron = "0 */1 * * * *")
    public void myTask() {
        System.out.println("Tarea programada ejecutada cada minuto...");
    }
}