/*    */ package de.hybris.platform.customerreview.constants;
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
/*    */ @Deprecated
/*    */ public class GeneratedCustomerReviewConstants
/*    */ {
/*    */   public static final String EXTENSIONNAME = "customerreview";
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
/*    */   public static class TC
/*    */   {
/* 30 */     public static final String CUSTOMERREVIEW = "CustomerReview".intern();
/* 31 */     public static final String CUSTOMERREVIEWAPPROVALTYPE = "CustomerReviewApprovalType".intern();
/*    */   }
/*    */   
/*    */   public static class Attributes
/*    */   {
/*    */     public static class Product {
/* 37 */       public static final String AVERAGERATING = "averageRating".intern();
/* 38 */       public static final String NUMBEROFREVIEWS = "numberOfReviews".intern();
/* 39 */       public static final String PRODUCTREVIEWS = "productReviews".intern();
/*    */     }
/*    */     
/*    */     public static class User {
/* 43 */       public static final String CUSTOMERREVIEWS = "customerReviews".intern();
/*    */     }
/*    */   }
/*    */   
/*    */   public static class Enumerations
/*    */   {
/*    */     public static class CustomerReviewApprovalType {
/* 50 */       public static final String APPROVED = "approved".intern();
/* 51 */       public static final String PENDING = "pending".intern();
/* 52 */       public static final String REJECTED = "rejected".intern();
/*    */     }
/*    */   }
/*    */   
/*    */   public static class Relations {
/* 57 */     public static final String REVIEWTOPRODUCTREL = "ReviewToProductRel".intern();
/* 58 */     public static final String REVIEWTOUSERREL = "ReviewToUserRel".intern();
/*    */   }
/*    */ }