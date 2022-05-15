package com.example.ui.config;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoCredential;
import com.mongodb.WriteConcern;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories
public class BookRepositoryConfig extends AbstractMongoClientConfiguration {

    @Override
    protected String getDatabaseName() {
        return "bookstore";
    }

    @Override
    protected String getMappingBasePackage() {
        return "com.example.ui.domain";
    }

    @Override
    @Bean
    public MongoClient mongoClient() {
        return MongoClients.create(
            MongoClientSettings.builder()
            .applyConnectionString(new ConnectionString("mongodb+srv://analytics.zp8ia.mongodb.net/"))
            .credential(MongoCredential.createCredential("analytics", "bookstore", "analytics-password".toCharArray()))
            .retryWrites(true)
            .writeConcern(WriteConcern.MAJORITY)
            .build());

    }
}