package com.dz.repositories.async;

import com.dz.models.View;
import com.dz.repositories.ViewRepository;

public class SaveThread extends Thread {

    private ViewRepository viewRepository;

    private View view;

    public SaveThread(ViewRepository viewRepository, View view) {
        this.viewRepository = viewRepository;
        this.view = view;
    }

    @Override
    public void run() {
        viewRepository.save(view);
    }
}
