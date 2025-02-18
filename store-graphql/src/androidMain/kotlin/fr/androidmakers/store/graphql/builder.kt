package fr.androidmakers.store.graphql

import android.content.Context
import com.apollographql.apollo3.ApolloClient
import com.apollographql.apollo3.cache.normalized.api.MemoryCacheFactory
import com.apollographql.apollo3.cache.normalized.apolloStore
import com.apollographql.apollo3.cache.normalized.normalizedCache
import com.apollographql.apollo3.cache.normalized.sql.SqlNormalizedCacheFactory

fun GraphQLStore(context: Context): GraphQLStore {
    val cacheFactory = MemoryCacheFactory(20_000_000).chain(SqlNormalizedCacheFactory(context))
    val apolloClient = ApolloClient.Builder()
            .serverUrl("https://kiki-conf.ew.r.appspot.com/graphql")
            //.serverUrl("http://10.0.2.2:8080/graphql")
            .normalizedCache(cacheFactory)
            .build()
    return GraphQLStore(apolloClient)
}