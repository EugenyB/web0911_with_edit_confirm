package com.example.web0911.db;

import org.springframework.beans.factory.annotation.Value;

/**
 * Projection for {@link Book}
 */
public interface BookInfo {
    Integer getId();

    @Value("#{target.title + ' by ' + target.author.name}")
    String getFullTitle();

    Integer getPages();
}