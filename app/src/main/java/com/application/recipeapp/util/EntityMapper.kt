package com.application.recipeapp.util

interface EntityMapper<Entity, DomainModel> {

    fun mapToEntity(domain: DomainModel): Entity

    fun mapFromEntity(entity: Entity): DomainModel
}