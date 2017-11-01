package com.nilerbarcelos.model;

import javax.persistence.EntityManager;

import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdResolver;

public class IdResolver implements ObjectIdResolver{

	private EntityManager entityManager;

	public IdResolver(final EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public void bindItem(final ObjectIdGenerator.IdKey id, final Object pojo) {
	}

	@Override
	public boolean canUseFor(final ObjectIdResolver resolverType) {
		return false;
	}

	@Override
	public ObjectIdResolver newForDeserialization(final Object context) {
		return this;
	}

	@Override
	public Object resolveId(final ObjectIdGenerator.IdKey id) {
		return this.entityManager.find(id.scope, id.key);
	}
}
