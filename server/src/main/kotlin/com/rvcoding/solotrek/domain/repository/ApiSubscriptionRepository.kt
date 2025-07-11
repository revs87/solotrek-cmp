package com.rvcoding.solotrek.domain.repository

import com.rvcoding.solotrek.domain.data.db.SubscriptionEntity

interface ApiSubscriptionRepository {
    fun getAllSubscriptions(): List<SubscriptionEntity>
    fun getUserSubscriptions(userId: String): List<SubscriptionEntity>
    fun getUserSubscribers(userId: String): List<SubscriptionEntity>
    suspend fun subscribe(subscription: SubscriptionEntity)
    suspend fun unsubscribe(userId: String, userSubscribedId: String)
}