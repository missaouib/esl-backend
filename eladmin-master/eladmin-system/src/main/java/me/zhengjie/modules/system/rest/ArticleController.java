package me.zhengjie.modules.system.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import me.zhengjie.annotation.rest.AnonymousDeleteMapping;
import me.zhengjie.annotation.rest.AnonymousGetMapping;
import me.zhengjie.annotation.rest.AnonymousPostMapping;
import me.zhengjie.modules.system.domain.aims.request.AddArticleRequestData;
import me.zhengjie.modules.system.service.ArticleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Api(tags = "Articles Management")
@RequestMapping("/api/articles")
public class ArticleController {

    private final ArticleService articleService;

    @ApiOperation("Get List of articles by StationCode")
    @AnonymousGetMapping
//    @PreAuthorize("@el.check('roles:list')")
    public ResponseEntity<Object> getAllArticles(@RequestParam String stationCode){
        return new ResponseEntity<>(articleService.getAllArticles(stationCode), HttpStatus.OK);
    }

    @ApiOperation("Add/Update Articles")
    @AnonymousPostMapping
//    @PreAuthorize("@el.check('roles:list')")
    public ResponseEntity<Object> updateArticles(@RequestBody AddArticleRequestData addArticleRequestData){
        articleService.addArticle(addArticleRequestData);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @ApiOperation("Delete an article by articleId and StationCode")
    @AnonymousDeleteMapping
//    @PreAuthorize("@el.check('roles:list')")
    public ResponseEntity<Object> deleteArticle(@RequestParam String articleId, @RequestParam String stationCode){
        articleService.deleteArticle(articleId, stationCode);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
