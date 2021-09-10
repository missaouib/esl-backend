package me.zhengjie.modules.system.service;

import me.zhengjie.modules.system.domain.aims.request.AddArticleRequestData;
import me.zhengjie.modules.system.domain.aims.request.Article;

public interface ArticleService {
    void addArticle(AddArticleRequestData addArticleRequestData);
    Article[] getAllArticles(String stationCode);
    void deleteArticle(String articleId, String stationCode);
}
