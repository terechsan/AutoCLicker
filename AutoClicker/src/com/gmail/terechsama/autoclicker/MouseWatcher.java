package com.gmail.terechsama.autoclicker;

import java.awt.MouseInfo;

import com.gmail.terechsama.autoclicker.view.RootLayoutController;

import javafx.application.Platform;

public class MouseWatcher extends Thread{
	private RootLayoutController controller;
	
	public MouseWatcher(RootLayoutController controller) {
		this.setDaemon(true);
		this.controller = controller;
	}
	
	@Override
	public void run() {
		while(true) {
			int x = (int) MouseInfo.getPointerInfo().getLocation().getX();
			int y = (int) MouseInfo.getPointerInfo().getLocation().getY();
			
			Platform.runLater(new Runnable() {
				@Override
				public void run() {
					controller.setCoordinateLabel(x, y);
				}
			});
			
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
