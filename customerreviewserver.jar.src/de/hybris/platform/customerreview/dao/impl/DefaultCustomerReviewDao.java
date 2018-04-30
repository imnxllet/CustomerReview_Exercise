/*    */ package de.hybris.platform.customerreview.dao.impl;
/*    */ 
/*    */ import de.hybris.platform.core.model.c2l.LanguageModel;
/*    */ import de.hybris.platform.core.model.product.ProductModel;
/*    */ import de.hybris.platform.customerreview.dao.CustomerReviewDao;
/*    */ import de.hybris.platform.customerreview.model.CustomerReviewModel;
/*    */ import de.hybris.platform.jalo.Item;
/*    */ import de.hybris.platform.servicelayer.internal.dao.AbstractItemDao;
/*    */ import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
/*    */ import de.hybris.platform.servicelayer.search.FlexibleSearchService;
/*    */ import de.hybris.platform.servicelayer.search.SearchResult;
/*    */ import java.util.Collections;
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class DefaultCustomerReviewDao
/*    */   extends AbstractItemDao
/*    */   implements CustomerReviewDao
/*    */ {
/*    */   public List<CustomerReviewModel> getReviewsForProduct(ProductModel product)
/*    */   {
/* 36 */     String query = "SELECT {" + Item.PK + "} FROM {" + "CustomerReview" + "} WHERE {" + "product" + "}=?product ORDER BY {" + "creationtime" + "} DESC";
/* 37 */     FlexibleSearchQuery fsQuery = new FlexibleSearchQuery(query);
/* 38 */     fsQuery.addQueryParameter("product", product);
/* 39 */     fsQuery.setResultClassList(Collections.singletonList(CustomerReviewModel.class));
/*    */     
/* 41 */     SearchResult<CustomerReviewModel> searchResult = getFlexibleSearchService().search(fsQuery);
/* 42 */     return searchResult.getResult();
/*    */   }
/*    */   
/*    */ 
/*    */   public List<CustomerReviewModel> getReviewsForProductAndLanguage(ProductModel product, LanguageModel language)
/*    */   {
/* 48 */     String query = "SELECT {" + Item.PK + "} FROM {" + "CustomerReview" + "} WHERE {" + "product" + "}=?product AND {" + "language" + "}=?language ORDER BY {" + "creationtime" + "} DESC";
/* 49 */     FlexibleSearchQuery fsQuery = new FlexibleSearchQuery(query);
/* 50 */     fsQuery.addQueryParameter("product", product);
/* 51 */     fsQuery.addQueryParameter("language", language);
/* 52 */     fsQuery.setResultClassList(Collections.singletonList(CustomerReviewModel.class));
/*    */     
/* 54 */     SearchResult<CustomerReviewModel> searchResult = getFlexibleSearchService().search(fsQuery);
/* 55 */     return searchResult.getResult();
/*    */   }
/*    */ }