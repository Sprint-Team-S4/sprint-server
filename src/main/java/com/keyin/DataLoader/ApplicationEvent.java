package com.keyin.DataLoader;

import org.springframework.context.event.ContextRefreshedEvent;

public interface ApplicationEvent {
    void onApplicationEvent(ContextRefreshedEvent event);
}
