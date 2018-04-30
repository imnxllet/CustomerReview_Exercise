/*    */ package de.hybris.platform.customerreview.services;
/*    */ 
/*    */ import de.hybris.platform.core.model.product.ProductModel;
/*    */ import de.hybris.platform.core.model.user.UserModel;
/*    */ import de.hybris.platform.customerreview.CustomerReviewService;
/*    */ import de.hybris.platform.customerreview.model.CustomerReviewModel;
/*    */ import de.hybris.platform.product.ProductService;
/*    */ import de.hybris.platform.servicelayer.ServicelayerTransactionalTest;
/*    */ import de.hybris.platform.servicelayer.user.UserService;
/*    */ import de.hybris.platform.util.Config;
/*    */ import java.util.List;
/*    */ import java.util.Set;
/*    */ import java.util.TreeSet;
/*    */ import javax.annotation.Resource;
/*    */ import org.junit.After;
/*    */ import org.junit.Assert;
/*    */ import org.junit.Before;
/*    */ import org.junit.Test;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CustomerReviewServiceTest
/*    */   extends ServicelayerTransactionalTest
/*    */ {
/*    */   @Resource
/*    */   private CustomerReviewService customerReviewService;
/*    */   @Resource
/*    */   private ProductService productService;
/*    */   @Resource
/*    */   private UserService userService;
/*    */   private UserModel userModel01;
/*    */   private UserModel userModel02;
/*    */   private ProductModel productModel01;
/*    */   private String oldMinimalRating;
/*    */   private String oldMaximalRating;
/*    */   
/*    */   @Before
/*    */   public void setUp()
/*    */     throws Exception
/*    */   {
/* 61 */     createCoreData();
/* 62 */     createDefaultCatalog();
/* 63 */     this.productModel01 = this.productService.getProduct("testProduct1");
/* 64 */     this.userModel01 = this.userService.getUser("anonymous");
/* 65 */     this.userModel02 = this.userService.getCurrentUser();
/*    */     
/* 67 */     this.oldMinimalRating = Config.getParameter("customerreview.minimalrating");
/* 68 */     this.oldMaximalRating = Config.getParameter("customerreview.maximalrating");
/*    */     
/*    */ 
/* 71 */     Config.setParameter("customerreview.minimalrating", String.valueOf(0));
/* 72 */     Config.setParameter("customerreview.maximalrating", String.valueOf(4));
/*    */   }
/*    */   
/*    */   @After
/*    */   public void tearDown()
/*    */   {
/* 78 */     Config.setParameter("customerreview.minimalrating", this.oldMinimalRating);
/* 79 */     Config.setParameter("customerreview.maximalrating", this.oldMaximalRating);
/*    */   }
/*    */   
/*    */   @Test
/*    */   public void testCustomerReviewService()
/*    */   {
/* 85 */     Assert.assertEquals("no rating", 0.0D, this.customerReviewService.getNumberOfReviews(this.productModel01).doubleValue(), 0.001D);
/* 86 */     this.customerReviewService.createCustomerReview(Double.valueOf(1.0D), "headline_anonymous", "comment_anonymous", this.userModel01, 
/* 87 */       this.productModel01);
/* 88 */     Assert.assertEquals("rating 1", 1.0D, this.customerReviewService.getNumberOfReviews(this.productModel01).doubleValue(), 0.001D);
/* 89 */     this.customerReviewService.createCustomerReview(Double.valueOf(2.0D), "headline_admin", "comment_admin", this.userModel02, 
/* 90 */       this.productModel01);
/* 91 */     Assert.assertEquals("rating 2", 2.0D, this.customerReviewService.getNumberOfReviews(this.productModel01).doubleValue(), 0.001D);
/* 92 */     Assert.assertEquals("average rating 1.5", 1.5D, this.customerReviewService.getAverageRating(this.productModel01).doubleValue(), 0.001D);
/* 93 */     List<CustomerReviewModel> reviews = this.customerReviewService.getAllReviews(this.productModel01);
/* 94 */     Set<String> comments = new TreeSet();
/* 95 */     comments.add("comment_anonymous");
/* 96 */     comments.add("comment_admin");
/* 97 */     for (CustomerReviewModel reviewModel : reviews)
/*    */     {
/* 99 */       Assert.assertTrue(comments.contains(reviewModel.getComment()));
/*    */     }
/*    */   }
/*    */ }