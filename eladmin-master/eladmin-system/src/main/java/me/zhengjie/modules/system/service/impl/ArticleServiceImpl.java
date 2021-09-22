package me.zhengjie.modules.system.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.zhengjie.modules.system.domain.aims.request.AddArticleRequestData;
import me.zhengjie.modules.system.domain.aims.request.Article;
import me.zhengjie.modules.system.service.ArticleService;
import me.zhengjie.modules.utils.RestTemplateService;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@Slf4j
@Service
@RequiredArgsConstructor
public class ArticleServiceImpl implements ArticleService {

    private static final String ARTICLE_PATH = "/articles";

    private static final String SINGLE_ARTICLE_PATH = "/article";

    private final RestTemplateService restTemplateService;


    public void addArticle(AddArticleRequestData addArticleRequestData) {
        MultiValueMap<String, String> queryVariables = new LinkedMultiValueMap<String, String>();
        this.restTemplateService.exchangeWithPathQueryVariablesPostMethod(
                AddArticleRequestData.class,
                ARTICLE_PATH,
                queryVariables,
                HttpMethod.POST,
                addArticleRequestData
        );
    }

    @Override
    public Article[] getAllArticles(String stationCode) {
        MultiValueMap<String, String> queryVariables = new LinkedMultiValueMap<String, String>();
        queryVariables.add("stationCode", stationCode);
        queryVariables.add("page", "0");
        queryVariables.add("size", "1000");
        ResponseEntity<Article[]> responseEntity = this.restTemplateService.exchangeWithPathQueryVariablesGetMethod(
                Article[].class,
                ARTICLE_PATH,
                queryVariables,
                HttpMethod.GET);

        return responseEntity.getBody();
    }

    public void deleteArticle(String articleId, String stationCode){
        MultiValueMap<String, String> queryVariables = new LinkedMultiValueMap<String, String>();
        queryVariables.add("stationCode", stationCode);
        queryVariables.add("articleId", articleId);

        this.restTemplateService.exchangeWithPathQueryVariablesDeleteMethod(
                Article[].class,
                ARTICLE_PATH + SINGLE_ARTICLE_PATH,
                queryVariables,
                HttpMethod.DELETE);
    }

}
