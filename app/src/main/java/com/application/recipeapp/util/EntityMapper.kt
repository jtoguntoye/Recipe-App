package com.application.recipeapp.util

interface EntityMapper<T, DomainModel> {

    fun mapFromDomainModel(domainModel: DomainModel): T

    fun mapToDomainModel(domain: T): DomainModel
}