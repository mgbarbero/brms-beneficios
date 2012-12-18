package com.redhat.latam.brms.model;

import org.bson.types.ObjectId;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;

@Entity
public class Configuracion {

	@Id
	private ObjectId id;

	private int refreshTime;
	private String changeSet;

	public ObjectId getId() {

		return this.id;
	}

	public int getRefreshTime() {

		return refreshTime;
	}

	public void setRefreshTime(int refreshTime) {

		this.refreshTime = refreshTime;
	}

	public String getChangeSet() {

		return changeSet;
	}

	public void setChangeSet(String changeSet) {

		this.changeSet = changeSet;
	}

}
