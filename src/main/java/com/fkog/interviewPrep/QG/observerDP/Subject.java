package com.fkog.interviewPrep.QG.observerDP;

public interface Subject {
	public void register(Observer o);

	public void unregister(Observer o);

	public void notifyObserver();
}
