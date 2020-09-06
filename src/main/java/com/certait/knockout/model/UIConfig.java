package com.certait.knockout.model;

public class UIConfig {

	private DataModel dataModel;

	public UIConfig(DataModel dataModel) {
		this.dataModel = dataModel;
	}

	public boolean isEligibleForMaleOptions() {
		return dataModel.isMale();
	}

	public boolean isEligibleForFemaleOptions() {
		return dataModel.isFemale();
	}

	public boolean isEligibleForPensionOptions() {
		return (dataModel.isMale() && dataModel.getAge() >= 65) || (dataModel.isFemale() && dataModel.getAge() >= 60);
	}
}
